package fr.dorian.business.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import fr.dorian.business.AccountInfosBO;
import fr.dorian.business.ActivityBO;
import fr.dorian.business.ThreadBO;
import fr.dorian.business.TutorialBO;
import fr.dorian.model.Account;
import fr.dorian.model.Activity;
import fr.dorian.model.Post;
import fr.dorian.model.Tag;
import fr.dorian.model.Thread;
import fr.dorian.model.enums.ActivityCommandEnum;
import fr.dorian.service.dao.AccountDAO;
import fr.dorian.service.dao.PostDAO;
import fr.dorian.service.dao.TagDAO;
import fr.dorian.service.dao.ThreadDAO;
import fr.dorian.service.exception.ServiceException;

@Service
@Scope("session")
public class ThreadBOImpl implements ThreadBO, Serializable
{
	private static final long serialVersionUID = -1243169179671011088L;
	
	private static final Logger logger = Logger.getLogger(ThreadBO.class);

	/**
	 * Properties
	 */
	
	@Autowired
	private ThreadDAO threadDAO;
	
	//PostDAO
	
	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private AccountInfosBO accountInfosBO;
	
	@Autowired
	private ActivityBO activityBO;
	
	@Autowired
	private TagDAO tagDAO;
	
	@Autowired
	private TutorialBO tutorialBO;
	
	/**
	 * Transactional methods
	 */
	
	//Create a new thread plus the first thread post
	
	@Override
	public Thread create(String title, String content, Account account) throws ServiceException {
		try {
			if (title == null || content == null || account == null)
				throw ServiceException.INVALID_REQUEST;
			
			Thread thread = new Thread();
			
			thread.setTitle(title);
			thread.setActived(true);
			thread.setClosed(false);
			thread.setCreatedBy(account);
			
			this.threadDAO.persist(thread);
			
			Post post = new Post();
			post.setContent(content);
			post.setQuestion(true);
			post.setThread(thread);
			post.setActived(true);
			post.setAccount(account);
			
			postDAO.persist(post);
			
			thread.addPost(post);
			// evict  or flush pour synchroniser
			
			//thread.getPosts().add(post);
			
			try {
				Activity activity = new Activity(account, thread, ActivityCommandEnum.CREATE_NEW_TRHEAD, "");		
				this.activityBO.addCommandActivity(activity);
			} catch (ServiceException e) {
				logger.error("failed to register activity", e);
			}
			return thread;
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}
	
	//Attach a new post to thread
	
	@Override
	public void attachPostToThread(Post post, Integer threadId) throws ServiceException {
		logger.debug("attach post to thread");

		if (post == null || threadId == null)
			throw ServiceException.INVALID_REQUEST;
		
		Thread thread = this.threadDAO.findById(threadId);
		if (thread == null)
			throw ServiceException.INVALID_REQUEST;			
		
		this.postDAO.persist(post);
		thread.addPost(post);
		this.threadDAO.update(thread);
		
		try {
			JSONObject json = new JSONObject();
			json.put("postId", post.getId());			
			Activity activity = new Activity(post.getAccount(), thread, ActivityCommandEnum.ADD_NEW_POST, json.toString());		
			this.activityBO.addCommandActivity(activity);
		} catch (ServiceException e) {
			logger.error("failed to register activity", e);
		} catch (JSONException e) {
			logger.error("failed to register activity", e);
		}
	}

	//Delete a thread with its Id
	
	@Override
	public void deleteById(Integer threadId) throws ServiceException {
		logger.debug("delete by id");
		try {
			if (threadId == null)
				throw ServiceException.INVALID_REQUEST;
			
			Thread thread = this.threadDAO.findById(threadId);
			if (thread == null)
				throw ServiceException.INVALID_REQUEST;
			
			this.threadDAO.remove(thread);
		} catch (Exception e) {
			logger.error("Internal error", e);
		}
	}

	@Override
	public void createTutorialByThreadId(Integer threadId) throws ServiceException {
		logger.debug("create tutorial by thread id");
		if (threadId == null)
			throw ServiceException.INVALID_REQUEST;
		Thread thread = this.threadDAO.findById(threadId);
		if (thread == null)
			throw ServiceException.INVALID_REQUEST;

		this.tutorialBO.createFromThreadId(thread.getId());
	}
	
	@Override
	public void destroyTutorialByThreadId(Integer threadId) throws ServiceException {
		if (threadId == null)
			throw ServiceException.INVALID_REQUEST;
		Thread thread = this.threadDAO.findById(threadId);
		this.tutorialBO.createFromThreadId(thread.getId());
	}
	
	@Override
	public Thread validateThread(Integer postId) throws ServiceException{
		logger.debug("validate thread");
		try {
			if (postId == null)
				throw ServiceException.INVALID_REQUEST;
			
			Post post = this.postDAO.findById(postId);
			if (post == null)
				throw ServiceException.INVALID_REQUEST;
				
			Thread thread = post.getThread();
			if (thread == null)
				throw ServiceException.INVALID_REQUEST;
			
			thread.setPostValidate(post);
			this.threadDAO.update(thread);
			this.accountInfosBO.update(post.getAccount().getId(), 5);
			return thread;
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
		
	}
	
	@Override
	public Thread unvalidateThread(Integer postId) throws ServiceException {
		logger.debug("unvalidate thread");
		try {
			if (postId == null)
				throw ServiceException.INVALID_REQUEST;
			
			Post post = this.postDAO.findById(postId);
			if (post == null)
				throw ServiceException.INVALID_REQUEST;
				
			Thread thread = post.getThread();
			if (thread == null)
				throw ServiceException.INVALID_REQUEST;
				
			thread.setPostValidate(null);
			this.threadDAO.update(thread);
			this.accountInfosBO.update(post.getAccount().getId(), -5);
			return thread;
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}
	
	//Get all threads
	
	@Override
	public List<Thread> findAll() throws ServiceException {
		logger.debug("find all threads");
		return this.threadDAO.findAll();
	}
	
	@Override
	public List<Post> findAllPostsFromThread(Integer threadId) throws ServiceException {
		if (threadId == null)
			throw ServiceException.INVALID_REQUEST;
		
		return this.threadDAO.findPostsByThreadId(threadId);
	}

	@Override
	public void closeThread(Account account, Thread thread) throws ServiceException {
		logger.debug("close thread");
		
		if (thread == null)
			throw ServiceException.INVALID_REQUEST;
		
		this.threadDAO.update(thread);
		
		try {
			JSONObject json = new JSONObject();
			json.put("threadId", thread.getId());
			this.activityBO.addCommandActivity(new Activity(account, thread, ActivityCommandEnum.CLOSE_THREAD, json.toString()));
		} catch (ServiceException e) {
			logger.error("failed to register activity", e);
		} catch (JSONException e) {
			logger.error("failed to register activity", e);
		}
	}

	@Override
	public void addTags(Account account, Thread thread, List<String> tagnames)
			throws ServiceException {
		logger.debug("add tags");
		
		try {
			if (thread == null || account == null || tagnames == null) 
				throw ServiceException.INVALID_REQUEST;

			List<Integer> tagIds = new ArrayList<Integer>(tagnames.size());
			for (String name : tagnames) {
				
				Tag tag = null;
				if ((tag = this.tagDAO.findByName(name)) != null) {
					thread.addTag(tag);
					continue;
				}

				tag = new Tag();
				tag.setName(name);
				tag.setCreatedBy(account);
				tag.addThread(thread);
				tag.setDescription("");

				this.tagDAO.persist(tag);

				thread.addTag(tag);
				tagIds.add(tag.getId());
			}
			threadDAO.update(thread);

			try {
				JSONObject json = new JSONObject();
				json.put("tagIds", new JSONArray(tagIds));
				this.activityBO.addCommandActivity(new Activity(account, thread, ActivityCommandEnum.CREATE_NEW_TAG, json.toString()));
			} catch (ServiceException e) {
				logger.error("failed to register activity", e);
			} catch (JSONException e) {
				logger.error("failed to register activity", e);
			}
		} catch (Exception e) {
			throw new ServiceException("Internal Error", e);
		}
	}

	@Override
	public List<Thread> findByAccount(Integer accountId) throws ServiceException {
		logger.debug("find for account");
		try {
			if (accountId == null)
				throw ServiceException.INVALID_REQUEST;
			
			return this.threadDAO.findByAccountId(accountId);
		} catch (Exception e) {
			throw new ServiceException("Internal Error", e);
		}
	}

	@Override
	public Thread findById(Integer threadId) throws ServiceException {
		logger.debug("find by id");
		try {
			if (threadId == null)
				throw ServiceException.INVALID_REQUEST;
			return this.threadDAO.findById(threadId);
		} catch (Exception e) {
			throw new ServiceException("Internal Error", e);
		}
	}

	@Override
	public List<Tag> findTagStartsWith(String query) throws ServiceException {
		logger.debug("find tags starts with");
		try {
			if (query == null)
				throw ServiceException.INVALID_REQUEST;
			
			return this.tagDAO.findStartsWith(query);
		} catch (Exception e) {
			throw new ServiceException("Internal Error", e);
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
			
			return this.threadDAO.countByAccount(account);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}
	
}
