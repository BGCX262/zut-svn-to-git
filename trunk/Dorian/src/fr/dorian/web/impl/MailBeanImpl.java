package fr.dorian.web.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import fr.dorian.business.AccountBO;
import fr.dorian.business.MailBO;
import fr.dorian.model.Mail;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.web.MailBean;
import fr.dorian.web.security.Secure;
import fr.dorian.web.util.validator.ValidatorHelper;

@Controller("mailBean")
@Scope("session")
public class MailBeanImpl implements MailBean, Serializable {

	private static final long serialVersionUID = 6122853498573182923L;
	
	private static final Logger logger = Logger.getLogger(MailBean.class);

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Autowired(required = true)
	private MailBO mailBO;
	
	private Mail mail;
	
	
	// Test variable
	@Autowired
	private AccountBO accountBO;
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	@PostConstruct
	public void postConstruct() {
		this.mail = new Mail();
	}
	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	@Secured(Secure.ROLE_SUPERVISOR)
	public String send() {
		logger.debug("send mail");
		try {
			this.accountBO.registerUser("knromeo@gmail.com", "toto", "knromeo");
			//this.mailService.sendAccountActivation("knromeo", "knromeo@gmail.com", "http://localhost:8080/Dorian/jsp/user/verify.jsf", "sdsd5sd45sd45s4d5sdd");
			return Redirect.redirect("/welcome");
		} catch (ServiceException e) {
			logger.error("send mail failed", e);
		}
		return null;
	}
	
	@Override
	@Secured(Secure.ROLE_SUPERVISOR)
	public List<Mail> getAllMails() {
		logger.debug("get all mails");
		try {
			return this.mailBO.findAll();
		} catch (ServiceException e) {
			logger.error("failed to load mails");
		}
		return null;
	}
	
	@Override
	public String contactUs() {
		logger.debug("contact us");
		try {
			/*this.mail.setBody("ccoc");
			this.mail.setSender("inconnu@dorian.fr");
			this.mail.setObject("ceci est un test");
			*/
			if (!ValidatorHelper.isEmail(mail.getSender()))
				return null; // error message
			this.mailBO.contactUs(mail);
			return Redirect.redirect("/welcome");
		} catch (ServiceException e) {
			logger.error("send mail failed", e);
			return null;
		}
	}
	

	@Override
	public Mail getMail() {
		return mail;
	}

	@Override
	public void setMail(Mail mail) {
		this.mail = mail;
	}

}
