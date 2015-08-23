package fr.dorian.web.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.dorian.business.AccountBO;
import fr.dorian.model.Account;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.web.AccountListBean;

@Controller("accountListBean")
@Scope("session")
public class AccountListBeanImpl implements AccountListBean, Serializable {

	private static final long serialVersionUID = -4111493208218878722L;

	private static final Logger logger = Logger.getLogger(AccountListBean.class);
	
	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private AccountBO accountBO;
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public String goToListView() {
		return Redirect.redirect("/jsp/user/list");
	}
	
	@Override
	public List<Account> getAll() {
		try {
			return this.accountBO.findAll();
		} catch (ServiceException e) {
			logger.error("get all failed", e);
		}
		return null;
	}

	@Override
	public List<Account> getReputations() {
		try {
			return this.accountBO.findByReputation();
		} catch (ServiceException e) {
			logger.error("get all failed", e);
		}
		return null;
	}
	

}
