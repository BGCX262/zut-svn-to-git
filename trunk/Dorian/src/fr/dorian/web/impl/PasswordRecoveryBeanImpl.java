package fr.dorian.web.impl;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import fr.dorian.business.AccountBO;
import fr.dorian.business.PasswordRecoveryBO;
import fr.dorian.model.Account;
import fr.dorian.service.exception.NotFoundException;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.web.IKeyRepository;
import fr.dorian.web.PasswordRecoveryBean;
import fr.dorian.web.security.AccountContext;
import fr.dorian.web.security.Secure;
import fr.dorian.web.util.WebHelper;
import fr.dorian.web.util.validator.ValidatorHelper;

@Controller("passwordRecoveryBean")
@Scope("session")
public class PasswordRecoveryBeanImpl implements PasswordRecoveryBean, Serializable {

	private static final long serialVersionUID = -3774704521548192707L;

	private static final Logger logger = Logger.getLogger(PasswordRecoveryBean.class); 
	
	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired(required = true)
	private IKeyRepository keyRepository;
	
	@Autowired
	private AccountContext accountContext;
	
	@Autowired
	private AccountBO accountBO;
	
	@Autowired
	private PasswordRecoveryBO passwordRecoveryBO;
	
	/// View: editPassword
	/// is sometimes used as current password
	private String data;
	private String email;
	private String token;
	private String newPassword;
	private String newPasswordVerifier;
	private String captcha;
	
	private boolean rendered;
	
	// OVERRIDES
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	@Secured(Secure.ROLE_USER)
	public String edit() {
		logger.debug("go to edit");
		Account account = this.accountContext.getCurrentAccount();
		if (account == null)
			throw new AccessDeniedException("Null account or account not found");

		this.setRendered(true);
		this.data = account.getUser().getPassword();
		return Redirect.redirect("/jsp/user/editPassword");
	}
	
	/*
	 * (non-Javadoc)
	 * @see fr.dorian.web.PasswordRecoveryBean#save()
	 */
	@Override
	@Secured(Secure.ROLE_USER)
	public String save() {
		logger.debug("save");
		try {

			if (!ValidatorHelper.isRequired(this.data)) {
				WebHelper.addMessageFromBundle(keyRepository.getResourceBundle(), "message.token.invalid", null, FacesMessage.SEVERITY_ERROR);
				return null;
			}
			
			if (!ValidatorHelper.isSamePassword(this.newPassword, this.newPasswordVerifier)) {
				WebHelper.addMessageFromBundle(keyRepository.getResourceBundle(), "error.account.password.differents", null, FacesMessage.SEVERITY_ERROR);
				return null;
			}
		
			this.accountBO.changePassword(this.accountContext.getCurrentAccount().getId(), this.newPassword);
			WebHelper.addMessageFromBundle(keyRepository.getResourceBundle(), "message.save.ok", null, FacesMessage.SEVERITY_INFO);
			return Redirect.redirect("/jsp/user/account");
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			WebHelper.addMessageFromBundle(keyRepository.getResourceBundle(), "message.recovery.internal.error", null, FacesMessage.SEVERITY_ERROR);
			logger.error("Send password recovery token failed", e);			
		}
		return null;
	}
	
	@Override
	public String send() {
		logger.debug("send password recovery token");
		try {
			// data = email
			
			if (!ValidatorHelper.isEmail(this.email)) {
				WebHelper.addMessageFromBundle(keyRepository.getResourceBundle(), "message.email.error", null, FacesMessage.SEVERITY_FATAL);
				return null;
			}
			this.passwordRecoveryBO.generateAndSendUrl(this.email);
			
			WebHelper.addMessageFromBundle(keyRepository.getResourceBundle(), "message.send.email.token", null, FacesMessage.SEVERITY_INFO);
			return Redirect.redirect("/jsp/user/editPassword");
		} catch (ServiceException e) {
			WebHelper.addMessageFromBundle(keyRepository.getResourceBundle(), "message.recovery.internal.error", null, FacesMessage.SEVERITY_ERROR);
			logger.error("Send password recovery token failed", e);
		} catch (NotFoundException e) {
			WebHelper.addMessageFromBundle(keyRepository.getResourceBundle(), "message.account.not.found", null, FacesMessage.SEVERITY_ERROR);
			logger.error("Send password recovery token failed", e);			
		} catch (Exception e) {
			WebHelper.addMessageFromBundle(keyRepository.getResourceBundle(), "message.recovery.internal.error", null, FacesMessage.SEVERITY_ERROR);
			logger.error("Send password recovery token failed", e);			
		}
		return null;
	}
	
	/**
	 * After recover password
	 * @return
	 */
	@Override
	public String recover() {
		logger.debug("recover");
		try {
			if (!ValidatorHelper.isRequired(this.token)) {
				WebHelper.addMessageFromBundle(keyRepository.getResourceBundle(), "message.token.invalid", null, FacesMessage.SEVERITY_ERROR);
				return null;
			}
			
			if (!ValidatorHelper.isSamePassword(this.newPassword, this.newPasswordVerifier)) {
				WebHelper.addMessageFromBundle(keyRepository.getResourceBundle(), "error.account.password.differents", null, FacesMessage.SEVERITY_ERROR);
				return null;
			}
			
			this.passwordRecoveryBO.resetPassword(this.token, this.newPassword);
			return Redirect.redirect("/login");
		} catch (Exception e) {
			logger.error("revery failed", e);
		}
		return null;
	}
	

	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String getData() {return data;}
	@Override
	public void setData(String password) {this.data = password;}
	
	@Override
	public String getNewPassword() {return newPassword;}
	@Override
	public void setNewPassword(String newPassword) {this.newPassword = newPassword;}
	
	@Override
	public String getNewPasswordVerifier() {return newPasswordVerifier;}
	@Override
	public void setNewPasswordVerifier(String newPasswordVerifier) {this.newPasswordVerifier = newPasswordVerifier;}

	@Override
	public boolean isRendered() {return rendered;}
	@Override
	public void setRendered(boolean displayOnly) {this.rendered = displayOnly;}

	@Override
	public String getCaptcha() {return captcha;}
	@Override
	public void setCaptcha(String captcha) {this.captcha = captcha;}

	@Override
	public String getEmail() {return email;}
	@Override
	public void setEmail(String email) {this.email = email;}

	@Override
	public String getToken() {return token;}
	@Override
	public void setToken(String token) {this.token = token;}
}
