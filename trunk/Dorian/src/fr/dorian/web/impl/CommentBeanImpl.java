package fr.dorian.web.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import fr.dorian.business.CommentBO;
import fr.dorian.model.Comment;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.web.CommentBean;
import fr.dorian.web.security.AccountContext;
import fr.dorian.web.security.Secure;
import fr.dorian.web.util.validator.ValidatorHelper;

@Controller("commentBean")
@Scope("session")
public class CommentBeanImpl implements CommentBean, Serializable {

	private static final long serialVersionUID = 6991599676468964409L;

	private static final Logger logger = Logger.getLogger(CommentBean.class);
	
	@Autowired
	private CommentBO commentBO;
	
	@Autowired
	private AccountContext accountContext;
	
	private String text;
	
	
	@Override
	@Secured(Secure.ROLE_USER)
	public void create(Integer tutorialId) {
		logger.debug("add comment");
		try {
			if (!ValidatorHelper.isRequired(text))
				return; // display error
			Comment comment = new Comment();
			comment.setAccount(this.accountContext.getCurrentAccount());
			comment.setText(this.text);
			this.commentBO.create(comment);
		} catch (ServiceException e) {
			logger.error("create comment failed", e);
		}
	}
	
	@Override
	@Secured(Secure.ROLE_SUPERVISOR)
	public List<Comment> getAll() {
		logger.debug("get all comments");
		try {
			return this.commentBO.findAll();
		} catch (ServiceException e) {
			logger.error("get all comments failed", e);
		}
		return null;
	}
	
	@Override
	public List<Comment> getByAccount(Integer accountId) {
		logger.debug("get all comments by account");
		try {
			return this.commentBO.findByAccountId(accountId);
		} catch (ServiceException e) {
			logger.error("get all comments failed by account", e);
		}
		return null;
	}

	@Override
	public List<Comment> getByTutorial(Integer tutorialId) {
		logger.debug("get all comments by tutorial");
		try {
			return this.commentBO.findByTutorialId(tutorialId);
		} catch (ServiceException e) {
			logger.error("get all comments failed by tutorial", e);
		}
		return null;
	}

	
	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}
	
}
