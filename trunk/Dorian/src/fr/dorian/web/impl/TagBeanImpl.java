package fr.dorian.web.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.dorian.business.TagBO;
import fr.dorian.model.Account;
import fr.dorian.model.Tag;
import fr.dorian.service.exception.NotFoundException;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.web.TagBean;
import fr.dorian.web.security.AccountContext;
import fr.dorian.web.util.validator.ValidatorHelper;

@Controller("tagBean")
@Scope("session")
public class TagBeanImpl implements TagBean, Serializable {

	private static final long serialVersionUID = -1720097785018657410L;

	private static final Logger logger = Logger.getLogger(TagBean.class);
	
	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Autowired
	private AccountContext accountContext;
	
	@Autowired
	private TagBO tagBO;
	
	private Account account;
	
	// View
	private Tag tag;
	private String name;
	private String description;
	private boolean displayValueOnly;
	
	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public String create() {
		logger.debug("create new tag");
		try {
		
			if (!ValidatorHelper.isRequired(name))
				return "/jsp/tag/new"; // display message
			
			if (this.account == null)
				this.account = this.accountContext.getCurrentAccount();
			
			if (this.account == null)
				throw ServiceException.AUTHENTICATION_ERROR;
		
			if (this.name.contains(Tag.SEPARATOR))
				this.tagBO.createTags(this.account.getId(), name);
			else
				this.tagBO.persist(new Tag(this.name, this.account, this.description));
			this.setDescription("");
			this.setName("");
			return Redirect.redirect("/jsp/tag/list");
		} catch (Exception e) {
			logger.error("failed to create tag", e);
		}
		return "/jsp/tag/new";
	}

	@Override
	public String view(Integer tagId) {
		logger.debug("go to view ");
		try {
			this.tag = this.tagBO.findById(tagId);
			if (tag == null)
				throw new NotFoundException("tag not found");
			
			this.setName(tag.getName());
			this.setDescription(tag.getDescription());
			
			this.setDisplayValueOnly(false);
			return Redirect.redirect("/jsp/tag/view");
		} catch (Exception e) {
			logger.error("failed to view", e);
			return Redirect.redirect("/jsp/tag/list");
		}
	}
	
	public void goToView() {
		logger.debug("go to view " + tag);
		try {
			if (tag == null)
				throw ServiceException.INVALID_REQUEST;
			
			this.setDisplayValueOnly(false);
		} catch (Exception e) {
			logger.error("go to view", e);
		}
	}
	
	public void goToEdition() {
		logger.debug("go to edition ");
		try {
			if (tag == null)
				throw ServiceException.INVALID_REQUEST;
			
			this.setDisplayValueOnly(true);
		} catch (Exception e) {
			logger.error("go to edition failed", e);
		}
	}
	
	@Override
	public String update() {
		logger.debug("update tag ");
		try {
			if (tag == null)
				throw ServiceException.INVALID_REQUEST;
			
			if (!ValidatorHelper.isRequired(name))
				return "/jsp/tag/view";
			
			this.tag.setName(this.name);
			this.tag.setDescription(this.description);
			
			this.tagBO.update(tag);
			
			this.setDisplayValueOnly(false);
			return "/jsp/tag/view";
		} catch (Exception e) {
			logger.error("update failed", e);
		}
		return Redirect.redirect("/jsp/tag/view");
	}
	
	@Override
	public String remove(Integer tagId) {
		Log.debug("delete tag id");
		try {
			this.tagBO.remove(tagId);
		} catch (ServiceException e) {
			logger.error("delete failed", e);
		}
		return Redirect.redirect("/jsp/tag/list");
	}

	@Override
	////@Secured(Secure.ROLE_USER)
	public boolean getEditRole() {
		Account account = accountContext.getCurrentAccount();
		if (account == null || this.tag == null)
			return false;
		if (account.isSupervisor())
			return true;
		return (this.tag.getCreatedBy().equals(account));
	}
	
	@Override
	public String countByAccount(Integer accountId) {
		logger.debug("count account tags");
		try {
			Long count = this.tagBO.countByAccountId(accountId);
			return count.toString();
		} catch (ServiceException e) {
			logger.error("failed to get all tags for account", e);
		}
		return "0";
	}
	
	@Override
	public List<Tag> byTutorial(Integer tutorialId) {
		logger.debug("get all by tutorial");
		try {
			return this.tagBO.findByTutorialId(tutorialId);
		} catch (ServiceException e) {
			logger.error("find all for tutorial failed");
		}
		return null;
	}
	
	@Override
	public List<Tag> byThread(Integer threadId) {
		logger.debug("get all by thread");
		try {
			return this.tagBO.findByThreadId(threadId);
		} catch (ServiceException e) {
			logger.error("find all for thread failed");
		}
		return null;
	}
	
	
	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public Tag getTag() {return tag;}
	@Override
	public void setTag(Tag tag) {this.tag = tag;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}

	public boolean isDisplayValueOnly() {return displayValueOnly;}
	public void setDisplayValueOnly(boolean displayValueOnly) {this.displayValueOnly = displayValueOnly;}
}

