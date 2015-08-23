package fr.dorian.business.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import fr.dorian.business.ActivityBO;
import fr.dorian.business.TagBO;
import fr.dorian.model.Account;
import fr.dorian.model.Tag;
import fr.dorian.model.Thread;
import fr.dorian.model.Tutorial;
import fr.dorian.service.dao.AccountDAO;
import fr.dorian.service.dao.TagDAO;
import fr.dorian.service.dao.ThreadDAO;
import fr.dorian.service.dao.TutorialDAO;
import fr.dorian.service.exception.ServiceException;

@Service
@Scope("session")
public class TagBOImpl implements TagBO, Serializable {

	private static final long serialVersionUID = -8324561718317229656L;

	private static final Logger logger = Logger.getLogger(TagBO.class);
	
	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Autowired
	private TagDAO tagDAO;
	
	@Autowired
	private ActivityBO activityBO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private TutorialDAO tutorialDAO;
	
	@Autowired
	private ThreadDAO threadDAO;
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	
	@Override
	public List<Tag> findAll(Account account) throws ServiceException {
		logger.debug("find all by account");
		try {
			if (account == null)
				throw ServiceException.INVALID_REQUEST;
			
			return this.tagDAO.findForAccount(account);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}

	@Override
	public void persist(Tag tag) throws ServiceException {
		logger.debug("persist new tag");
		try {
			if (tag == null || tag.getCreatedBy() == null || tag.getName() == null)
				throw ServiceException.INVALID_REQUEST;

			Tag tmp = this.tagDAO.findByName(tag.getName());
			if (tmp == null)
				this.tagDAO.persist(tag);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}
	
	@Override
	public void createTags(Integer accountId, String tagNames) throws ServiceException {
		logger.debug("create tags");
		try {
			if (accountId == null || tagNames == null)
				throw ServiceException.INVALID_REQUEST;

			Account account = this.accountDAO.findById(accountId);
			if (account == null)
				throw ServiceException.INVALID_REQUEST;
			
			String[] namesArr = tagNames.split(",");
			if (namesArr.length < 1)
				throw ServiceException.INVALID_REQUEST;

			for (String name : namesArr) {				
				String tmpName = StringUtils.trim(name);
				if (tmpName.isEmpty())
					continue;

				if (this.tagDAO.findByName(tmpName) != null)
					continue;

				Tag tag = new Tag();
				tag.setName(tmpName);
				tag.setCreatedBy(account);
				tag.setDescription("");

				this.tagDAO.persist(tag);
			}
		} catch (Exception e) {
			throw new ServiceException("Internal error" ,e);
		}
	}

	@Override
	public void update(Tag tag) throws ServiceException {
		logger.debug("update tag");
		try {
			if (tag == null)
				throw ServiceException.INVALID_REQUEST;

			this.tagDAO.update(tag);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}

	@Override
	public void remove(Integer tagId) throws ServiceException {
		logger.debug("delete tag");
		try {
			if (tagId == null)
				throw ServiceException.INVALID_REQUEST;

			this.tagDAO.deleteById(tagId);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}

	@Override
	public Tag findById(Integer tagId) throws ServiceException {
		logger.debug("find by id");
		try {
			if (tagId == null)
				throw ServiceException.INVALID_REQUEST;
			
			return this.tagDAO.findById(tagId);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}

	@Override
	public Tag findByName(String name) throws ServiceException {
		logger.debug("find by name");
		try {
			if (name == null)
				throw ServiceException.INVALID_REQUEST;
			
			return this.tagDAO.findByName(name);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}

	@Override
	public List<Tag> findAll() throws ServiceException {
		logger.debug("find all tags");
		try {			
			return this.tagDAO.findAll();
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}

	@Override
	public List<Tag> findStartsWith(String query) throws ServiceException {
		try {
			if (query == null)
				throw ServiceException.INVALID_REQUEST;
			return this.tagDAO.findStartsWith(query);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}

	@Override
	public List<Tag> findAllByAccountId(Integer accountId)
			throws ServiceException {
		logger.debug("find all by account id");
		try {
			if (accountId == null)
				throw ServiceException.INVALID_REQUEST;
			Account account = this.accountDAO.findById(accountId);

			if (account == null)
				throw ServiceException.INVALID_REQUEST;
			
			return this.tagDAO.findForAccount(account);
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
			
			return this.tagDAO.countByAccount(account);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}

	@Override
	public List<Tag> findTagContains(String query) throws ServiceException {
		logger.debug("find tags contains");
		try {
			if (query == null)
				throw ServiceException.INVALID_REQUEST;
			return this.tagDAO.contains(query);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}

	@Override
	public List<Tag> findByTutorialId(Integer tutorialId) throws ServiceException {
		logger.debug("find by tutorial");
		try {
			if (tutorialId == null)
				throw ServiceException.INVALID_REQUEST;
			
			Tutorial tutorial = this.tutorialDAO.findById(tutorialId);
			if (tutorial == null)
				throw ServiceException.INVALID_REQUEST;
			
			return this.tagDAO.findByTutorial(tutorial);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}		
	}		

	@Override
	public List<Tag> findByThreadId(Integer threadId) throws ServiceException {
		logger.debug("find by thread");
		try {
			if (threadId == null)
				throw ServiceException.INVALID_REQUEST;
			
			Thread thread = this.threadDAO.findById(threadId);
			if (thread == null)
				throw ServiceException.INVALID_REQUEST;
			
			return this.tagDAO.findByThread(thread);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}		
	}
}
