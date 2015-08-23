package fr.dorian.business.impl;

import java.io.Serializable;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import fr.dorian.business.AttachmentBO;
import fr.dorian.business.PostBO;
import fr.dorian.model.Account;
import fr.dorian.model.Attachment;
import fr.dorian.model.Post;
import fr.dorian.model.Thread;
import fr.dorian.service.dao.AccountDAO;
import fr.dorian.service.dao.PostDAO;
import fr.dorian.service.dao.ThreadDAO;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.service.store.ObjectStore;
import fr.dorian.service.store.StoreException;
import fr.dorian.web.security.Secure;

/**
 * 
 * @author BloodSucker94
 *
 */

@Service("postService")
@Scope("session")
public class PostBOImpl implements PostBO, Serializable
{
	private static final long serialVersionUID = 1721648908597691564L;

	private static final Logger logger = Logger.getLogger(PostBO.class);
			
	/**
	 * Properties
	 */
	
	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private ThreadDAO threadDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private ObjectStore objectStore;
	
	@Autowired
	private AttachmentBO attachmentBO;
	
	/**
	 * Transactional CRUD methods
	 */
	//Create a new post
	
	@Override
	@Secured(Secure.ROLE_USER)
	public void createPost(Integer threadId, Post post, List<Attachment> tmpAttachments) throws ServiceException{
		logger.debug("create post");
		try {
			if (post == null || threadId == null)
				throw ServiceException.INVALID_REQUEST;
			
			Thread thread = this.threadDAO.findById(threadId);
			if (thread == null)
				throw ServiceException.INVALID_REQUEST;
			
			post.setThread(thread);
			this.postDAO.persist(post);
			
			if (tmpAttachments != null && !tmpAttachments.isEmpty()) {
				for (Attachment attachment : tmpAttachments) {
					
					attachment.setAccount(post.getAccount());
					attachment.setPost(post);
					
					try {
						String uuid = this.objectStore.store(attachment.getFile().getContents());
						attachment.setFileUUID(uuid);
					} catch (StoreException storeException) {
						throw new ServiceException("Stored failed", storeException);
					}
					
					this.attachmentBO.persist(attachment);
					post.addAttachment(attachment);
				}
			}
			this.postDAO.update(post);
			this.threadDAO.update(thread);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}
	
	//Read a specific post
	
	@Override
	public Post findById(Integer postId) throws ServiceException {
		logger.debug("find by id");
		try {
			if (postId == null)
				throw ServiceException.INVALID_REQUEST;
			
			return this.postDAO.findById(postId);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}
	
	//Update a specific post
	
	@Override
	public void updatePost(Post post) {
		this.postDAO.update(post);
	}
	
	//Remove a specific post
	
	@Override
	public void deletePostById(Account account, Integer id) throws ServiceException {
		logger.debug("delete post by id");
		
		if (account == null || id == null)
			throw ServiceException.INTERNAL_ERROR;
		
		Post post = this.postDAO.findById(id);
		
		if (post == null)
			throw ServiceException.INTERNAL_ERROR;
		
		Thread thread = post.getThread();
		if (!post.getAccount().equals(account) || !thread.getCreatedBy().equals(account))
			throw new ServiceException("Only thread owner or post owner can delete this post");
		
			// error invalid request
		
		thread.removePost(post);
		this.postDAO.deleteById(Post.class, id);
		this.threadDAO.update(thread);
	}
	
	/**
	 * Additional transactional methods
	 */
	
	//Get all posts
	
	@Override
	public List<Post> findAll() throws ServiceException {
		logger.debug("find all posts");
		return (this.postDAO.findAll());
	}
	
	//Get all posts by id 
	// To remove
	
	@Override
	public List<Post> findByThreadId(Integer threadId) throws ServiceException {
		logger.debug("find by thread id");
		try {
			if (threadId == null)
				throw ServiceException.INVALID_REQUEST;
			
			Thread thread = this.threadDAO.findById(threadId);
			if (thread == null)
				throw ServiceException.INVALID_REQUEST;
			
			return (this.postDAO.findByThread(thread));
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}
	
	@Override
	public Long countByAccountId(Integer accountId) throws ServiceException {
		logger.debug("count all for account id");
		try {
			if (accountId == null)
				throw ServiceException.INVALID_REQUEST;
			Account account = this.accountDAO.findById(accountId);
			
			if (account == null)
				throw ServiceException.INVALID_REQUEST;
			
			return this.postDAO.countByAccount(account);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}	
	
	@Override
	public List<Post> findByAccountId(Integer accountId) throws ServiceException {
		logger.debug("find by account id");
		try {
			if (accountId == null)
				throw ServiceException.INVALID_REQUEST;
			
			Account account = this.accountDAO.findById(accountId);
			if (account == null)
				throw ServiceException.INVALID_REQUEST;
			
			return this.postDAO.findByAccount(account);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}
	
}