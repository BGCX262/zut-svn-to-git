package fr.dorian.web.impl;

import java.io.Serializable;

import javax.faces.application.FacesMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.dorian.business.AccountActivationBO;
import fr.dorian.web.ActivationBean;
import fr.dorian.web.IKeyRepository;
import fr.dorian.web.util.WebHelper;

@Scope("session")
@Controller("activationBean")
public class ActivationBeanImpl implements ActivationBean, Serializable {

	private static final long serialVersionUID = 3665957106026278754L;
	
	private static final Logger logger = Logger.getLogger(ActivationBean.class);

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	private AccountActivationBO accountActivationBO;
	
	@Autowired(required = true)
	private IKeyRepository keyRepository;

	// Properties
	private String code;

	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public String activateAccount() {
		logger.debug("activate user account");
		try {
			
			if (this.code == null) {
				WebHelper.addMessageFromBundle(keyRepository.getResourceBundle(), "message.code.error.info", null, FacesMessage.SEVERITY_INFO);
				return null;
			}
			this.accountActivationBO.activateAccount(this.code);
			WebHelper.addMessageFromBundle(keyRepository.getResourceBundle(), "message.account.activation.ok", null, FacesMessage.SEVERITY_INFO);
			return Redirect.redirect("/login");
		} catch (Exception e) {
			logger.error("user account activation failed", e);
			WebHelper.addMessageFromBundle(keyRepository.getResourceBundle(), "message.account.activation.error", null, FacesMessage.SEVERITY_INFO);
		}
		return null;
	}

	@Override
	public String getCode() {return code;}
	@Override
	public void setCode(String code) {this.code = code;}
}
