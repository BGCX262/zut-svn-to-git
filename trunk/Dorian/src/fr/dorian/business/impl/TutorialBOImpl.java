package fr.dorian.business.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import fr.dorian.business.TutorialBO;
import fr.dorian.model.Account;
import fr.dorian.model.Post;
import fr.dorian.model.Tag;
import fr.dorian.model.Thread;
import fr.dorian.model.Tutorial;
import fr.dorian.service.dao.AccountDAO;
import fr.dorian.service.dao.PostDAO;
import fr.dorian.service.dao.TagDAO;
import fr.dorian.service.dao.ThreadDAO;
import fr.dorian.service.dao.TutorialDAO;
import fr.dorian.service.exception.ServiceException;

@Service
@Scope("session")
public class TutorialBOImpl implements TutorialBO, Serializable {

	private static final long serialVersionUID = -8363648084946192391L;

	private static final Logger logger = Logger.getLogger(TutorialBO.class);
	
	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	private TutorialDAO tutorialDAO;
	
	@Autowired
	private ThreadDAO threadDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private TagDAO tagDAO;
	
	// OVERRIDES
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public List<Tutorial> findAll() throws ServiceException {
		logger.debug("find all");
		return this.tutorialDAO.findAll();
	}
	
	@Override
	public void createOrSave(Tutorial tutorial, List<String> selectedTagsText) throws ServiceException {
		logger.debug("create");
		try {
			if (tutorial == null)
				throw ServiceException.INVALID_REQUEST;
			
			if (tutorial.getId() == null)
				this.tutorialDAO.persist(tutorial);
			
			for (String name : selectedTagsText) {
				Tag tag = null;
				if ((tag = this.tagDAO.findByName(name)) != null) {
					tutorial.addTag(tag);
					continue;
				}
				
				tag = new Tag();
				tag.setName(name);
				tag.setCreatedBy(tutorial.getAccount());
				tag.addTutorial(tutorial);
				tag.setDescription("");

				this.tagDAO.persist(tag);
				tutorial.addTag(tag);
			}
			
			this.tutorialDAO.update(tutorial);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}
	
	@Override
	public void createFromThreadId(Integer threadId) throws ServiceException {
		logger.debug("create from thread");
		try {
			if (threadId == null)
				throw ServiceException.INVALID_REQUEST;
			
			Thread thread = this.threadDAO.findById(threadId);
			if (thread == null)
				throw ServiceException.INVALID_REQUEST;
			
			Tutorial tutorial = new Tutorial();
			tutorial.setAccount(thread.getCreatedBy());
			tutorial.setTitle(thread.getTitle());
			tutorial.setThread(thread);
			tutorial.setTags(thread.getTags());
			tutorial.setActived(true);
			
			Post post = thread.getPostValidate();
			tutorial.setContent(post.getContent());
			tutorial.setSecondAccount(post.getAccount());
			
			// Find thread question : first post of thread
			List<Post> threadPosts = null;
			if ((threadPosts = this.postDAO.findByThread(thread)) == null)
				throw ServiceException.INVALID_REQUEST;
			tutorial.setQuestion(threadPosts.get(0).getContent());
			
			this.tutorialDAO.persist(tutorial);
			
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}
	
	@Override
	public void destroyFromThreadId(Integer threadId) throws ServiceException {
		if (threadId == null)
			throw ServiceException.INVALID_REQUEST;
		Tutorial tutorial = this.tutorialDAO.findByThreadId(threadId);
		tutorial.setActived(false);
		this.tutorialDAO.update(tutorial);
	}
	
	@Override
	public List<Tutorial> findByAccountId(Integer accountId) throws ServiceException {
		logger.debug("find by account id");
		try {
			if (accountId == null)
				throw ServiceException.INVALID_REQUEST;
			
			Account account = this.accountDAO.findById(accountId);
			if (account == null)
				throw ServiceException.INVALID_REQUEST;
				
			return this.tutorialDAO.findByAccount(account);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}

	@Override
	public Tutorial findById(Integer tutorialId) throws ServiceException {
		logger.debug("find by id");
		try {
			if (tutorialId == null)
				throw ServiceException.INVALID_REQUEST;
			
			return this.tutorialDAO.findById(tutorialId);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
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
	public Long countByAccount(Integer accountId) throws ServiceException {
		logger.debug("count by account");
		try {
			if (accountId == null)
				throw ServiceException.INVALID_REQUEST;
			
			Account account = this.accountDAO.findById(accountId);
			if (account == null)
				throw ServiceException.INVALID_REQUEST;
			
			return this.tutorialDAO.countByAccount(account);
		} catch (Exception e) {
			throw new ServiceException("Internal Error", e);
		}
	}

	@Override
	public void addTags(Tutorial tutorial, List<String> selectedTagsText) throws ServiceException {
		logger.debug("add tags");
		try {
			if (tutorial == null || tutorial.getId() == null)
				throw ServiceException.INVALID_REQUEST;
			
			for (String name : selectedTagsText) {
				Tag tag = null;
				if ((tag = this.tagDAO.findByName(name)) != null) {
					tutorial.addTag(tag);
					continue;
				}

				tag = new Tag();
				tag.setName(name);
				tag.setCreatedBy(tutorial.getAccount());
				tag.addTutorial(tutorial);
				tag.setDescription("");

				this.tagDAO.persist(tag);
				tutorial.addTag(tag);
			}
			
			this.tutorialDAO.update(tutorial);
		} catch (Exception e) {
			throw new  ServiceException("Internal error", e);
		}
		
	}
}
