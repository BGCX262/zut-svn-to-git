package fr.dorian.web.impl;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import fr.dorian.business.AccountSettingsBO;
import fr.dorian.model.Account;
import fr.dorian.model.AccountSettings;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.web.AccountSettingsBean;
import fr.dorian.web.IKeyRepository;
import fr.dorian.web.security.AccountContext;
import fr.dorian.web.security.Secure;
import fr.dorian.web.util.WebHelper;

@Controller("accountSettingsBean")
@Scope("session")
public class AccountSettingsBeanImpl implements AccountSettingsBean, Serializable  {
	
	private static final long serialVersionUID = -7926280724205977075L;

	private static final Logger logger = Logger.getLogger(AccountSettingsBean.class);
	
	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	private AccountSettingsBO accountSettingsBO;
	
	@Autowired(required = true)
	private AccountContext accountContext;
	
	@Autowired(required = true)
	private IKeyRepository keyRepository;
	
	// View
	private AccountSettings settings;

	// CONSTRUCTOR
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@PostConstruct
	public void postConstruct() throws AccessDeniedException {
		Account account = this.accountContext.getCurrentAccount();
		if (account == null)
			throw new AccessDeniedException("AccessDeniedException");
		
		this.setSettings(account.getSettings());
	}

	// OVERRIDES
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	@Secured(Secure.ROLE_USER)
	public AccountSettings getSettings() {
		return settings;
	}

	@Override
	@Secured(Secure.ROLE_USER)
	public void setSettings(AccountSettings settings) {
		this.settings = settings;
	}
	
	@Override
	@Secured(Secure.ROLE_USER)
	public void save() {
		logger.debug("save settings");
		try {
			this.accountSettingsBO.update(this.settings);
			WebHelper.addMessageFromBundle(keyRepository.getResourceBundle(), "message.save.settings.ok", null, FacesMessage.SEVERITY_INFO);
		} catch (ServiceException e) {
			logger.error("save settings failed", e);
			WebHelper.addMessageFromBundle(keyRepository.getResourceBundle(), "message.save.settings.error", null, FacesMessage.SEVERITY_ERROR);
		}
	}
}
