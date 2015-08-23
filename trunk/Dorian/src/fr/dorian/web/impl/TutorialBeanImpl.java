package fr.dorian.web.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import fr.dorian.business.TutorialBO;
import fr.dorian.model.Account;
import fr.dorian.model.Tag;
import fr.dorian.model.Tutorial;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.web.TutorialBean;
import fr.dorian.web.security.AccountContext;
import fr.dorian.web.security.Secure;

@Controller("tutorialBean")
@Scope("session")
public class TutorialBeanImpl implements TutorialBean, Serializable {

	private static final long serialVersionUID = 4338044331798593525L;
	
	private static Logger logger = Logger.getLogger(TutorialBean.class);
	
	@Autowired
	private TutorialBO tutorialBO;
	
	@Autowired
	private AccountContext accountContext;
	
	// view
    private boolean actived;
	private Integer tutorialId;
	private Tutorial tutorial;
	private boolean displayOnly;
	private List<String> tags;
	private boolean canEdit;
	
	@PostConstruct
	public void onConstruct() {
		this.tutorial = new Tutorial();
		this.tutorialId = null;
	}
	
	@Override
	@Secured(Secure.ROLE_USER)
	public String createNew() {
		logger.debug("create new");
		try {
			if (this.tutorial == null && this.tutorialId == null)
				this.tutorial= new Tutorial();
			
			this.tutorial.setActived(this.actived);
			this.tutorial.setAccount(this.accountContext.getCurrentAccount());
			if (this.tags == null)
				this.tags = new ArrayList<String>();
			this.tutorialBO.createOrSave(this.tutorial, this.tags);
			return Redirect.redirectTutorial("/jsp/tutorial/view", this.tutorial.getTitle());
		} catch (ServiceException e) {
			logger.error("create tutorial failed", e);
		}
		return Redirect.redirect("/jsp/tutorial/list");
	}
	
	@Override
	public String countByAccount(Integer accountId) {
		try {
			Long count = this.tutorialBO.countByAccount(accountId);
			return count.toString();
		} catch (ServiceException e) {
			logger.error("get counter failed", e);
		}
		return "0";
	}
	
	@Override
	public String view(Integer tutorialId) {
		logger.debug("view");
		try {
			this.tutorial = this.tutorialBO.findById(tutorialId);
			this.setActived(this.tutorial.isActived());
			this.tutorialId = this.tutorial.getId();
			this.canEdit = this.whoCanEdit();
			return Redirect.redirectTutorial("/jsp/tutorial/view", this.tutorial.getTitle());
		} catch (Exception e) {
			logger.error("failed to load cuurent account", e);
		}
		return null;
	}
	
	@Override
	@Secured(Secure.ROLE_USER)
	public String onCancelNew() {
		return Redirect.redirect("/jsp/tutorial/list");
	}
	
	@Override
	@Secured(Secure.ROLE_USER)
	public String goToUpdate(Integer tutorialId) {
		logger.debug("got to update");
		try {
			this.tutorial = this.tutorialBO.findById(tutorialId);
			this.tutorialId = this.tutorial.getId();
			this.setDisplayOnly(false);
			return Redirect.redirect("/jsp/tutorial/new");
		} catch (ServiceException e) {
			logger.error("go to update failed", e);
		}
		return null;
	}
	
	@Override
	public String goToTutorialList() {
		return (Redirect.redirect("/jsp/tutorial/list"));
	}
	
	private boolean whoCanEdit() {
		Account account = this.accountContext.getCurrentAccount();
		if (this.tutorial == null || account == null)
			return false;
		if (account.isSupervisor())
			return true;
		if (this.tutorial.getAccount().equals(account))
			return true;
		return false;
	}
	
	@Override
	@Secured(Secure.ROLE_USER)
	public String update() {
		logger.debug("update");
		try {
		} catch (Exception e) {
			logger.error("Update failed", e);
		}
		return null;
	}
	
	@Override
	public List<String> onCompleteTag(String query) {
		logger.debug("complete");
		try {
			if (query == null)
				return null;
			
			List<String> suggestions = new ArrayList<String>();
			List<Tag> list = this.tutorialBO.findTagStartsWith(query);
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
		if (this.tags == null)
			this.tags = new ArrayList<String>();
		
		this.tags.add(event.getObject().toString());
		System.out.println(this.tags);
	}
	
	@Override
	public String addTags() {
		logger.debug("add tags");
		try {
			this.tutorialBO.addTags(this.tutorial, this.tags);
			this.tutorial = this.tutorialBO.findById(tutorialId);
		} catch (ServiceException e) {
			logger.debug("add tags failed");
		}
		return Redirect.redirectTutorial("/jsp/tutorial/view", this.tutorial.getTitle());
	}
	
	@Override
	@Secured(Secure.ROLE_USER)
	public String createdFromThread(Integer threadId) {
		logger.debug("create from thread");
		return null;
	}
	
	@Override
	public Tutorial getTutorial() {
		return this.tutorial;
	}

	@Override
	public void setTutorial(Tutorial tutorial) {
		this.tutorial = tutorial;
	}
	
	
	@Override
	public Integer getTutorialId() {
		return tutorialId;
	}

	@Override
	public void setTutorialId(Integer tutorialId) {
		this.tutorialId = tutorialId;
	}

	@Override
	public boolean isActived() {
		return actived;
	}

	@Override
	public void setActived(boolean actived) {
		this.actived = actived;
	}

	@Override
	public boolean isDisplayOnly() {
		return displayOnly;
	}

	@Override
	public void setDisplayOnly(boolean displayOnly) {
		this.displayOnly = displayOnly;
	}
	
	@Override
	public List<String> getTags() {
		return tags;
	}

	@Override
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	@Override
	public boolean isCanEdit() {
		return canEdit;
	}

	@Override
	public void setCanEdit(boolean canEdit) {
		this.canEdit = canEdit;
	}

}
