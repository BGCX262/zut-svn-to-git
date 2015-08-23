package fr.dorian.web.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.dorian.business.ActivityBO;
import fr.dorian.model.Activity;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.web.ActivityBean;
import fr.dorian.web.security.AccountContext;

@Scope("session")
@Controller("activityBean")
public class ActivityBeanImpl implements ActivityBean, Serializable {

	private static final long serialVersionUID = -8215961309244382232L;

	private static Logger logger = Logger.getLogger(ActivityBean.class);
	
	@Autowired
	private ActivityBO activityBO;

	@Autowired
	private AccountContext accountContext;
	
	@Override
	public String goToListView() {
		logger.debug("go to view");
		return Redirect.redirect("/jsp/activity/list");
	}
	
	@Override
	public List<Activity> getActivitiesByAccount(Integer accountId) {
		logger.debug("get activities ");
		try {
			return this.activityBO.findByAccountId(accountId);
		} catch (ServiceException e) {
			logger.error("failed to load all activities for current account", e);
		}
		return null;
	}
	
	@Override
	public List<Activity> getActivities() {
		try {
			return this.activityBO.findByAccountId(accountContext.getCurrentAccount().getId());
		} catch (ServiceException e) {
			logger.error("failed to load all activities for current account", e);
		}
		return (null);
	}
	
}
