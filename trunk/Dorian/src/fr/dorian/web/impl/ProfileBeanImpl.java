package fr.dorian.web.impl;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;

import fr.dorian.business.ProfileBO;
import fr.dorian.model.Account;
import fr.dorian.model.Profile;
import fr.dorian.web.ProfileBean;
import fr.dorian.web.security.AccountContext;

@Controller("profileBean")
@Scope("session")
public class ProfileBeanImpl implements ProfileBean, Serializable {

	private static final long serialVersionUID = 4640432143070836845L;

	public static final Logger logger = Logger.getLogger(ProfileBean.class);
	
	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired(required = true)
	private ProfileBO profileBO;
	
	@Autowired(required = true)
	private AccountContext accountContext;
	
	private Profile profile;

	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	@PostConstruct
	public void postConstruct() throws AccessDeniedException {
		Account account = this.accountContext.getCurrentAccount();
		if (account == null)
			throw new AccessDeniedException("AccessDeniedException");
		this.setProfile(account.getProfile());
	}
	// ACCESSORS
	/////////////////////////////////////////////////////////////////////////////////////////////// 
	@Override
	public Profile getProfile() {
		return profile;
	}
	
	@Override
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
}
