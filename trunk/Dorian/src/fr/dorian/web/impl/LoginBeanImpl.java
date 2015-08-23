package fr.dorian.web.impl;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.dorian.model.Account;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.service.util.ServiceUtil;
import fr.dorian.web.IKeyRepository;
import fr.dorian.web.LoginBean;
import fr.dorian.web.RedirectionKeys;
import fr.dorian.web.security.AccountContext;
import fr.dorian.web.security.IAuthenticationService;
import fr.dorian.web.util.WebHelper;

@Controller("loginBean")
@Scope("session")
public class LoginBeanImpl implements LoginBean, Serializable {
	
	private static final long serialVersionUID = 8466906251220034081L;

	private static final Logger log = Logger.getLogger(LoginBean.class);
	
	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Autowired(required = true)
	private IAuthenticationService authenticationService;
	
	@Autowired(required = true)
	private IKeyRepository keyRepository;

	@Autowired
	private AccountContext accountContext;
	
	@Autowired(required = true)
	private ServiceUtil serviceUtil;
	
	
	// View Properties
	private String username;
	private String password;
	private String email;
	private boolean rememberMe;

	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	// OVERRIDES
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public String doLogin()	{
		log.debug("do login");
		try {
			if (authenticationService.login(this.email, this.password))
				return RedirectionKeys.WELCOME + "?faces-redirect=true";
			else {
				WebHelper.addMessageFromBundle(keyRepository.getResourceBundle(), "message.login.error.info", null, FacesMessage.SEVERITY_INFO);
				return RedirectionKeys.LOGIN;
			}
		} catch (ServiceException e) {
			log.error("Do login failed", e);
		}
		return "login.xhtml";
	}

	@Override
	public boolean isLogged() {
		return this.authenticationService.isLogged();
	}

	@Override
	public String getDisplayName() {
		if (!this.isLogged())
			return WebHelper.getMessageFromBundle(this.keyRepository.getResourceBundle(), "common.unknown");
		Account account = this.accountContext.getCurrentAccount();
		if (account == null)
			return WebHelper.getMessageFromBundle(this.keyRepository.getResourceBundle(), "common.unknown");
		return account.getUsername();
	}
	
	@Override
	public String goToRegistrationPage() {
		log.debug("go to registration page");
		if (!authenticationService.isLogged())
			return RedirectionKeys.REGISTRATION;
		return RedirectionKeys.LOGIN;
	}

	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String getPassword() {return password;}
	@Override
	public String getUsername()	{return username;}
	@Override
	public boolean isRememberMe() {return rememberMe;}

	@Override
	public void setPassword(String password) {this.password = password;}
	@Override
	public void setUsername(String userId) {this.username = userId;}
	@Override
	public void setRememberMe(boolean rememberMe) {this.rememberMe = rememberMe;}
	
	@Override
	public String getEmail() {return email;}
	@Override
	public void setEmail(String email) {this.email = email;}

}