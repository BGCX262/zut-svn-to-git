package fr.dorian.web.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import fr.dorian.business.PostBO;
import fr.dorian.model.Account;
import fr.dorian.model.Attachment;
import fr.dorian.model.Post;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.web.AttachmentBean;
import fr.dorian.web.PostBean;
import fr.dorian.web.security.AccountContext;
import fr.dorian.web.security.Secure;

@Scope("session")
@Controller("postBean")
public class PostBeanImpl implements PostBean, Serializable {

	private static final long serialVersionUID = 1809026871641537538L;
	
	private static final Logger logger = Logger.getLogger(PostBean.class);

	/**
	 * Properties
	 */
	// Bean
	@Qualifier("attachmentBean")
	@Autowired(required = true)
	private AttachmentBean attachmentBean;
	
	//Post management
	@Autowired
	private PostBO postBO;
	
	@Autowired
	private AccountContext accountContext;
	
    //Form properties
    
	private Integer id;
	private Integer threadId; 
    private String title;
    private String content;
    private Date created;
    private Date modified;
    private List<Attachment> attachments;
    
    /**
     * Transaction CRUD methods
     */
    
    //Create a new post
    
    @Override
    @Secured(Secure.ROLE_USER)
	public String createPost()
	{
    	try {
		Post post = new Post();
		post.setContent(content);
		post.setAccount(accountContext.getCurrentAccount());
		if (this.attachmentBean.hasAttachment()) {
			if (this.attachments == null)
				this.attachments = new ArrayList<Attachment>();
			
			this.attachments.addAll(this.attachmentBean.getAttachments());
		}
		// set thread
			this.postBO.createPost(this.threadId, post, attachments);
		} catch (ServiceException e) {
			logger.error("create post failed", e);
		}
    	return (Redirect.redirect("/jsp/thread/view"));
	}
    
    @Override
    public boolean canEdit(Post post) {
    	Account account = this.accountContext.getCurrentAccount();
    	if (post == null || account == null)
    		return false;
    	if (account.isSupervisor())
    		return true;
    	return account.equals(post.getAccount());
    }
    
	//Read a specific post
    @Override
    public Post readPost(Integer id) {
    	try {
			return (this.postBO.findById(id));
		} catch (ServiceException e) {
			logger.error("read post failed", e);
			//throw ContainsNotFound
		}
    	return null;
    }
	
	//Update a specific post
	
    @Override
    @Secured(Secure.ROLE_USER)
	public String updatePost(Integer id)
	{
		Post post = this.readPost(id);
		post.setContent(content);
		this.postBO.updatePost(post);
		this.getEmpty();
		return (Redirect.redirect("/jsp/thread/view"));
	}
	
	//Remove a specific post
	
    @Override
    @Secured(Secure.ROLE_USER)
	public void removePostById(Integer id) {
    	try {
			
    		this.postBO.deletePostById(accountContext.getCurrentAccount(), id);
		} catch (Exception e) {
			logger.error("Failed to remove post", e);
		}
	}
    
    /**
     * Additional transactional methods
     */
    
    //Get all posts
    @Override
    public List<Post> getAllPosts() {
    	logger.debug("get all posts");
        try {
			return (this.postBO.findAll());
		} catch (ServiceException e) {
			logger.error("get all posts failed", e);
		}
        return null;
    }

    //Get all posts with the same thread Id
    @Override
    public List<Post> getAllPostsByThreadId(Integer threadId) {
    	logger.debug("get all post by thread id");
    	try {
			return (this.postBO.findByThreadId(threadId));
		} catch (ServiceException e) {
			logger.error("get all posts by thread id failed", e);
		}
    	return null;
    }
    
    @Override
    public List<Post> getAllByAccountId(Integer accountId) {
    	logger.debug("get all by account id");
    	try {
			return this.postBO.findByAccountId(accountId);
		} catch (ServiceException e) {
			logger.error("failed to load all for account", e);
		}
    	return null;
    }
    //Remove all posts
    
    /**
     * Redirection methods
     */
    @Override
    @Secured(Secure.ROLE_USER)
    public String redirectTo(Post post)
    {
    	this.id = post.getId();
    	this.content = post.getContent();
    	return (Redirect.redirect("/jsp/post/editPost"));
    }
    
    /**
     * Overriden methods
     */
    
    //Empty all properties
    
    @Override
	public void getEmpty() {    	
		this.setId(0);
		this.setTitle(null);
		this.setContent(null);
	}
    
    @Override
	public String countByAccount(Integer accountId) {
		logger.debug("count by account");
		try {
			Long count = this.postBO.countByAccountId(accountId);
			return count.toString();
		} catch (ServiceException e) {
			logger.error("count  by account failed", e);
		}
		return "0";
	} 
    /**
     * Accessors
     */
    
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	@Override
	public String getContent() {return this.content;}
	@Override
	public void setContent(String content) {this.content = content;}
	public PostBO getPostService() {return (this.postBO);}
	public void setPostService(PostBO postService) {this.postBO = postService;}
	@Override
	public Integer getId() {return id;}
	@Override
	public void setId(Integer id) {this.id = id;}
	public Date getCreated() {return created;}
	public void setCreated(Date created) {this.created = created;}
	public Date getModified() {return modified;}
	public void setModified(Date modified) {this.modified = modified;}
	@Override
	public void setThreadId(Integer id) {this.threadId = id;}
	@Override
	public Integer getThreadId() {return this.threadId;	}
}