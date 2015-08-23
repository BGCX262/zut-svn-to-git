package fr.dorian.web.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import fr.dorian.business.ThreadBO;
import fr.dorian.model.Account;
import fr.dorian.model.Post;
import fr.dorian.model.Tag;
import fr.dorian.model.Thread;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.web.PostBean;
import fr.dorian.web.ThreadBean;
import fr.dorian.web.security.AccountContext;
import fr.dorian.web.security.Secure;


@Controller("threadBean")
@Scope("session")
public class ThreadBeanImpl implements ThreadBean, Serializable {
	
	private static final long serialVersionUID = -141334625413717339L;
	
	private static final Logger logger = Logger.getLogger(ThreadBean.class);

	/**
	 * Properties
	 */
	//Thread management
	@Qualifier("postBean")
	@Autowired(required = true)
	private PostBean postBean;
	
	@Autowired
	private ThreadBO threadBO;
		
	@Autowired
	private AccountContext accountContext;
	
	//Posts list
	
	private Integer id;
	private String title;
	private String content;
	private List<String> selectedTagsText;
	private boolean canEdit;
	
	//Thread object
	
	private Thread thread;
	
	/**
	 * Transactional methods
	 */
	
	//Create a new thread
	
	@Override
	@Secured(Secure.ROLE_USER)
	public String createThread() {
		logger.debug("create thread");
		try {
			this.thread = this.threadBO.create(title, this.content, accountContext.getCurrentAccount());
			this.setId(this.thread.getId());
			return Redirect.redirectThread("/jsp/thread/view", this.thread.getTitle());
		} catch (ServiceException e) {
			logger.error("thread creation failed", e);
		}
		return null;
	}
	
	//RedirectTo add new post to thread
	@Override
	@Secured(Secure.ROLE_USER)
	public String redirectToNewResponse() {
		this.postBean.setContent(null);
		this.postBean.setThreadId(this.id);
		return (Redirect.redirect("/jsp/post/attachPost"));
	}
	
	@Override
	public String goToAskQuestion() {
		this.getEmpty();
		return (Redirect.redirect("/jsp/post/askQuestion"));
	}
	
	@Override
	public String goToThreadList() {
		this.getEmpty();
		return (Redirect.redirect("/jsp/thread/list"));
	}
	
	//get all posts list
	@Override
	public List<Post> findAllPostFromThread() {
		logger.debug("find all post from thread // " + this.id);
		try {
			return this.threadBO.findAllPostsFromThread(this.id);
		} catch (ServiceException e) {
			logger.error("find all post from thread", e);
		}
		return null;
	}
	
	private void setProperties(Thread thread) {
		this.setId(thread.getId());
		this.setTitle(thread.getTitle());
		this.setThread(thread);
		this.canEdit = this.whoCanEdit();
	}
	
	@Override
	public String view(Integer threadId) {
		logger.debug("view thread");
		try {
			this.thread = this.threadBO.findById(threadId);
			this.setProperties(thread);
			return (Redirect.redirectThread("/jsp/thread/view", this.thread.getTitle()));
		} catch (ServiceException e) {
			logger.error("failed to close thread", e);
		}
		return null;
	}
	
	@Override
	public String createTutorialFromThread() {
		try {
			this.threadBO.createTutorialByThreadId(this.id);
		} catch (ServiceException e) {
			logger.error("validate thread failed", e);
		}
		return (Redirect.redirect("/jsp/thread/view"));
	}
	
	@Override
	public String destroyTutorialByThreadId(Integer threadId) {
		try {
			this.threadBO.destroyTutorialByThreadId(threadId);
		} catch (ServiceException e) {
			logger.error("validate thread failed", e);
		}
		return (Redirect.redirect("/jsp/thread/view"));
	}
	
	@Override
	public String validateThread(Integer postId) {
		try {
			this.thread = this.threadBO.validateThread(postId);
			this.setProperties(thread);
			return (Redirect.redirect("/jsp/thread/view"));
		} catch (ServiceException e) {
			logger.error("validate thread failed", e);
		}
		return null;
	}
	
	@Override
	public String unvalidateThread(Integer postId) {
		try {
			this.thread = this.threadBO.unvalidateThread(postId);
			this.setProperties(thread);
			return (Redirect.redirect("/jsp/thread/view"));
		} catch (ServiceException e) {
			logger.error("unvalidate thread failed", e);
		}
		return null;
	}
	
	@Override
	@Secured(Secure.ROLE_USER)
	public String close() {
		logger.debug("close thread");
		try {
			this.thread.setClosed(true);
			this.threadBO.closeThread(accountContext.getCurrentAccount(), this.thread);
			return Redirect.redirect("/jsp/thread/list");
		} catch (ServiceException e) {
			logger.error("failed to close thread", e);
			return Redirect.redirectThread("/jsp/thread/view", this.thread.getTitle());
		}
	}
	
	/**
	 * Overriden controller methods
	 */
	@Override
	public void getEmpty() {
		this.setId(0);
		this.setTitle(null);
		this.setContent(null);
	}

	private boolean whoCanEdit() {
		Account account = accountContext.getCurrentAccount();
		if (account == null)
			return false;
		if (account.isSupervisor() == true)
			return true;
		return (this.thread.getCreatedBy().equals(account));
	}
	
	@Override
	public List<Tag> getThreadTags() {
		if (this.thread == null || this.thread.getTags() == null)
			return null; // display Error??
		Set<Tag> tags = this.thread.getTags();
		List<Tag> tagsList = new ArrayList<Tag>(tags); 
		return (tagsList);
	}
	
	@Override
	public List<String> onCompleteTag(String query) {
		logger.debug("complete");
		try {
			if (query == null)
				return null;
			
			List<String> suggestions = new ArrayList<String>();
			List<Tag> list = this.threadBO.findTagStartsWith(query);
			if (list == null || list.isEmpty())
				suggestions.add(query);
			for (Tag t : list)
				suggestions.add(t.getName());
			
			return suggestions;
		} catch (ServiceException e) {
			logger.error("complete failed", e);
		}
		return null;
	} 
	
	@Override
	public void onSelectTag(SelectEvent event) {
		if (this.selectedTagsText == null)
			this.selectedTagsText = new ArrayList<String>();
		
		this.selectedTagsText.add(event.getObject().toString());
		System.out.println(this.selectedTagsText);
	}
	
	@Override
	public String addTags() {
		logger.debug("add tags");
		try {
			if (this.accountContext.getCurrentAccount() == null)
				throw new AccessDeniedException("authentication failed");
			
			this.threadBO.addTags(this.accountContext.getCurrentAccount(), this.thread, this.selectedTagsText);
			
		} catch (ServiceException e) {
			logger.error("failed to add tags", e);
		}
		return Redirect.redirectThread("/jsp/thread/view", this.thread.getTitle());
	}

	@Override
	public List<Thread> getThreadsByAccount(Integer accountId) {
		logger.debug("find all threads by account");
		
		try {
			return this.threadBO.findByAccount(accountId);
		} catch (ServiceException e) {
			logger.error("find all threads by account failed", e);
		}
		return null;
	}
	
	@Override
	public String countByAccount(Integer accountId) {
		logger.debug("count by account");
		try {
			Long count = this.threadBO.countByAccountId(accountId);
			return count.toString();
		} catch (ServiceException e) {
			logger.error("count  by account failed", e);
		}
		return "0";
	}
	
	/**
	 * Accessors
	 */
	
	@Override
	public Integer getId() {return id;}
	@Override
	public void setId(Integer id) {this.id = id;}
	public ThreadBO getThreadService() {return threadBO;}
	public void setThreadService(ThreadBO threadService) {this.threadBO = threadService;}
	
	@Override
	public String getTitle() {return title;}
	@Override
	public void setTitle(String title) {this.title = title;}
	@Override
	public String getContent() {return content;}
	@Override
	public void setContent(String content) {this.content = content;}
	@Override
	public Thread getThread() {return thread;}
	@Override
	public void setThread(Thread thread) {this.thread = thread;}

	@Override
	public List<String> getSelectedTagsText() {return selectedTagsText;}
	@Override
	public void setSelectedTagsText(List<String> selectedTagsText) {this.selectedTagsText = selectedTagsText;}

	@Override
	public boolean isCanEdit() {return canEdit;}
	@Override
	public void setCanEdit(boolean canEdit) {this.canEdit = canEdit;}
}
