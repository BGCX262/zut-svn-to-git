package fr.dorian.web.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import fr.dorian.business.TutorialBO;
import fr.dorian.model.Tutorial;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.web.TutorialBean;
import fr.dorian.web.TutorialListBean;
import fr.dorian.web.security.Secure;

@Controller("tutorialListBean")
@Scope("session")
public class TutorialListBeanImpl implements TutorialListBean, Serializable {

	private static final long serialVersionUID = 8109719889884809001L;

	private static Logger logger = Logger.getLogger(TutorialListBean.class);
	
	@Qualifier("tutorialBean")
	@Autowired(required = true)
	private TutorialBean tutorialBean;
	
	@Autowired
	private TutorialBO tutorialBO;
	
	@Override
	public List<Tutorial> getTutorials() {
		logger.debug("get tutorials");
		try {
			return this.tutorialBO.findAll();
		} catch (ServiceException e) {
			logger.error("find all failed", e);
		}
		return null;
	}
	
	@Override
	@Secured(Secure.ROLE_USER)
	public String redirectToNew() {
		logger.debug("redirect to new");
		this.tutorialBean.setTutorial(new Tutorial());
		this.tutorialBean.setDisplayOnly(false);
		this.tutorialBean.setTutorialId(null);
		return Redirect.redirect("/jsp/tutorial/new");
	}
	
/*	@Override
	@Secured(Secure.ROLE_USER)
	public String goToNew() {
		this.tutorial = new Tutorial();
		this.tutorialId = -1;
		return Redirect.redirect("/jsp/tutorial/new");
	}
	
	@Override
	@Secured(Secure.ROLE_USER)
	public String createNew() {
		logger.debug("create new");
		try {
			if (this.tutorial == null)
				this.tutorial= new Tutorial();
			
			this.tutorial.setAccount(this.accountContext.getCurrentAccount());
			this.tutorialBO.create(this.tutorial, this.tags);
			return Redirect.redirect("/jsp/tutorial/view");
		} catch (ServiceException e) {
			logger.error("create tutorial failed", e);
		}
		return Redirect.redirect("/jsp/tutorial/list");
	}
	
	@Override
	public String view(Integer tutorialId) {
		logger.debug("view");
		try {
			this.tutorial = this.tutorialBO.findById(tutorialId);
			this.tutorialId = this.tutorial.getId();
			return Redirect.redirect("/jsp/tutorial/view");
		} catch (Exception e) {
			logger.error("failed to load cuurent account", e);
		}
		return null;
	}
	
	@Override
	@Secured(Secure.ROLE_USER)
	public String goToUpdate(Integer tutorialId) {
		logger.debug("got to update");
		try {
			this.tutorial = this.tutorialBO.findById(tutorialId);
			this.tutorialId = this.tutorial.getId();
			return Redirect.redirect("/jsp/tutorial/new");
		} catch (ServiceException e) {
			logger.error("go to update failed", e);
		}
		return null;
	}
	
	@Override
	public boolean canEdit() {
		if (this.tutorial == null || this.accountContext == null || this.accountContext.getCurrentAccount() == null)
			return false;
		if (this.tutorial.getAccount().equals(this.accountContext.getCurrentAccount()))
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
	@Secured(Secure.ROLE_USER)
	public String createdFromThread(Integer threadId) {
		logger.debug("create from thread");
		return null;
	}
	
	@Override
	public boolean displayOnly() {
		if (this.tutorialId.intValue() == -1)
			return true;
		return false;
	}

	@Override
	public Tutorial getTutorial() {
		return this.tutorial;
	}

	@Override
	public Integer getTutorialId() {
		return tutorialId;
	}

	@Override
	public void setTutorialId(Integer tutorialId) {
		this.tutorialId = tutorialId;
	}
*/	
}
