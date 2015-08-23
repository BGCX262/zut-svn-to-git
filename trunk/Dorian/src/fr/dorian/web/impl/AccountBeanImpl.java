package fr.dorian.web.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import fr.dorian.business.AccountBO;
import fr.dorian.model.Account;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.web.AccountBean;
import fr.dorian.web.IKeyRepository;
import fr.dorian.web.RedirectionKeys;
import fr.dorian.web.security.AccountContext;
import fr.dorian.web.security.Secure;
import fr.dorian.web.util.WebHelper;
import fr.dorian.web.util.validator.ValidatorHelper;

@Controller("accountBean")
@Scope("session")
public class AccountBeanImpl implements AccountBean, Serializable {

	private static final long serialVersionUID = -5102706407909772093L;

	private static final Logger logger = Logger.getLogger(AccountBean.class);
	
	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private AccountBO accountBO;
	
	@Autowired(required = true)
	private AccountContext accountContext;
	
	@Autowired(required = true)
	private IKeyRepository keyRepository;

	// View
	private String email;
	private String password;
	private String username;
	private String passwordVerifier;
	private Account account;
	private Integer accountId;
	
	private boolean displayValueOnly;
	private boolean editModeActived;
	
	private String imageFilename;
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	// OVERRIDES AND HELPER
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String registerUser() {
		logger.debug("register user");
		try {
			if (!this.validateRegistrationForm())
				return RedirectionKeys.REGISTRATION;
			
			this.accountBO.registerUser(this.email, this.password, this.username);
			return Redirect.redirect("/welcome");		
		} catch (Exception e) {
			logger.error("user registration failed", e);
		}
		return null;
	}
	
	@Override
	public String viewCurrent(Integer principalId) {
		logger.debug("view by username");
		try {
			this.account = this.accountBO.findByUserId(principalId);
			if (this.account == null)
				throw ServiceException.AUTHENTICATION_ERROR;
			
			this.accountId = this.account.getId();
			this.password = this.account.getUser().getPassword();
			this.passwordVerifier = password;
			this.email = this.account.getUser().getPrimaryEmail();
			this.username = this.account.getUser().getUsername();
			
			return "/jsp/user/account?faces-redirect=true";
		} catch (ServiceException e) {
			logger.error(e);
		}
		return "welcome";
	}
	
	@Override
	public boolean getEditRole() {
		Account current = this.accountContext.getCurrentAccount();
		if (current == null || this.account == null)
			return false;
		
		if (current.isDisabled())
			return false;
		return current.equals(account);
	}
	
	@Override
	@Secured(Secure.ROLE_SUPERVISOR)
	public String close(Integer accountId) {
		try {
			this.accountBO.closeOrOpen(accountId, true);
		} catch (ServiceException e) {
			logger.error("Can not close account", e);
		}
		return Redirect.redirect("/jsp/admin/admin");
	}
	
	
	@Override
	@Secured(Secure.ROLE_SUPERVISOR)
	public String open(Integer accountId) {
		try {
			this.accountBO.closeOrOpen(accountId, false);
		} catch (ServiceException e) {
			logger.error("Can not open account", e);
		}
		return Redirect.redirect("/jsp/admin/admin");
	}
	
	@Override
	public String view(Integer accountId) {
		logger.debug("view // ");
		try {
			this.account = this.accountBO.findById(accountId);
			if (this.account == null)
				throw ServiceException.AUTHENTICATION_ERROR;
			
			this.accountId = this.account.getId();
			this.password = this.account.getUser().getPassword();
			this.passwordVerifier = password;
			this.email = this.account.getUser().getPrimaryEmail();
			this.username = this.account.getUser().getUsername();
			
			return Redirect.redirect("/jsp/user/account");
		} catch (ServiceException e) {
			logger.error(e);
		}
		return "welcome";
	}

	@Override
	public void goToView() {
		logger.debug("go to view");
		
		this.setDisplayValueOnly(false);
		this.setEditModeActived(false);
	}
	
	@Override
	public void goToEdition() {
		logger.debug("go to edition");
		
		if (this.account == null)
			throw new NullPointerException("current account is null");
		
		this.setDisplayValueOnly(true);
		this.setEditModeActived(true);
	}
	
	@Override
	public void update() {
		logger.debug("update");
		try {

			if (!this.displayValueOnly) {
				logger.error("not edition mode");
				return;
			}

			if (this.account == null)
				throw new NullPointerException("current account is null");

			if (!ValidatorHelper.isRequired(username)) {
				WebHelper.addMessageFromBundle(this.keyRepository.getResourceBundle(), "message.login.error", null, FacesMessage.SEVERITY_WARN);
				return;
			}

			this.accountBO.update(this.account);
			this.setDisplayValueOnly(false);
			this.setEditModeActived(false);
		} catch (ServiceException e) {
			logger.error("Update failed", e);
		}
	}
	
	private boolean validateRegistrationForm() {
		logger.debug("validate registration form");

		boolean result = ValidatorHelper.isEmail(email) &&
				ValidatorHelper.isSamePassword(password, passwordVerifier);
		
		return result;
	}
		
	@Override
	public List<Account> getNewUsers() {
		// select all account and ordered by date desc
		return new ArrayList<Account>();
	}
	
	public void handleImageUpload(FileUploadEvent event) {
		this.setImageFilename(event.getFile().getFileName());
		// imageBO.saveTemp(event.getFile());
	}
	
	public void cropImage() {
		logger.debug("crop image");
		
		if (this.imageFilename == null)
			return;
			
	}

	public String saveAvatar(Integer userId) {
		logger.debug("save image for user");
		// imageBO.saveAvatar();
		return Redirect.redirect("/jsp/account/view");
	}
	
	
	// ACCESSORS 
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String getEmail() {return email;}
	@Override
	public void setEmail(String email) {this.email = email;}

	@Override
	public String getPassword() {return password;}
	@Override
	public void setPassword(String password) {this.password = password;}

	@Override
	public String getUsername() {return username;}
	@Override
	public void setUsername(String username) {this.username = username;}

	@Override
	public String getPasswordVerifier() {return passwordVerifier;}
	@Override
	public void setPasswordVerifier(String passwordVerifier) {this.passwordVerifier = passwordVerifier;}

	@Override
	public Account getAccount() {return account;}
	@Override
	public void setAccount(Account account) {this.account = account;}

	@Override
	public boolean isDisplayValueOnly() {return displayValueOnly;}
	@Override
	public void setDisplayValueOnly(boolean displayValueOnly) {	this.displayValueOnly = displayValueOnly;}

	@Override
	public boolean isEditModeActived() {return editModeActived;}
	@Override
	public void setEditModeActived(boolean editModeActived) {this.editModeActived = editModeActived;}

	@Override
	public String getImageFilename() {return imageFilename;}
	@Override
	public void setImageFilename(String imageFilename) {this.imageFilename = imageFilename;}

	@Override
	public Integer getAccountId() {return accountId;}
	@Override
	public void setAccountId(Integer accountId) {this.accountId = accountId;}
}
