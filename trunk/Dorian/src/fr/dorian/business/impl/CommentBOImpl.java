package fr.dorian.business.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import fr.dorian.business.CommentBO;
import fr.dorian.model.Account;
import fr.dorian.model.Comment;
import fr.dorian.model.Tutorial;
import fr.dorian.service.dao.AccountDAO;
import fr.dorian.service.dao.CommentDAO;
import fr.dorian.service.dao.TutorialDAO;
import fr.dorian.service.exception.ServiceException;

@Service
@Scope("session")
public class CommentBOImpl implements CommentBO, Serializable {

	private static final long serialVersionUID = 5419902964885259083L;

	private static final Logger logger = Logger.getLogger(CommentBO.class);
	
	@Autowired
	private CommentDAO commentDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private TutorialDAO tutorialDAO;
	
	@Override
	public void create(Comment comment) throws ServiceException {
		logger.debug("create");
		try {
			if (comment == null)
				throw ServiceException.INVALID_REQUEST;
			this.commentDAO.persist(comment);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}
	
	@Override
	public List<Comment> findAll() throws ServiceException {
		logger.debug("find all");
		return this.commentDAO.findAll();
	}
	
	@Override
	public List<Comment> findByAccountId(Integer accountId) throws ServiceException {
		logger.debug("find by account id");
		try {
			if (accountId == null)
				throw ServiceException.INVALID_REQUEST;
			
			Account account = this.accountDAO.findById(accountId);
			if (account == null)
				throw ServiceException.INVALID_REQUEST;
			
			return this.commentDAO.findByAccount(account);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
		
	}
	
	@Override
	public List<Comment> findByTutorialId(Integer tutorialId) throws ServiceException {
		logger.debug("find by tutorial id");
		try {
			if (tutorialId == null)
				throw ServiceException.INVALID_REQUEST;
			
			Tutorial tutorial = this.tutorialDAO.findById(tutorialId);
			if (tutorial == null)
				throw ServiceException.INVALID_REQUEST;
			return this.commentDAO.findByTutorial(tutorial);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}
	
	
}
