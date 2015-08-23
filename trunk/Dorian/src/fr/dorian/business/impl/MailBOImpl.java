package fr.dorian.business.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import fr.dorian.business.MailBO;
import fr.dorian.model.Mail;
import fr.dorian.model.PasswordRecovery;
import fr.dorian.model.enums.TemplateTypeEnum;
import fr.dorian.service.dao.MailDAO;
import fr.dorian.service.dao.PasswordRecoveryDAO;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.service.util.ServiceUtil;

@Service
@PropertySource(value = {"classpath:email.properties"})
public class MailBOImpl implements MailBO, Serializable {

	private static final long serialVersionUID = 4964592220263831727L;
	
	private static final Logger logger = Logger.getLogger(MailBOImpl.class);
			
	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private VelocityEngine velocityEngine;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private TaskExecutor taskExecutor;
	
	@Autowired
	private ServiceUtil serviceUtil;
	
	@Autowired
	private MailDAO mailDAO;
	
	@Autowired
	private PasswordRecoveryDAO passwordRecoveryDAO;

	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Sample Message preparation 
	 * @param fromEmail - The sender
	 * @param toEmail - Recipient
	 * @param subject - Message subject or object
	 * @param model - The model
	 * @param templateName - Template name
	 * @return a new {@link MimeMessagePreparator} 
	 */
	private MimeMessagePreparator prepareMessage(final String fromEmail, final String toEmail, final String subject,
			final Map<String, Object> model, final String templateName) {
		
		return new MimeMessagePreparator() {
			/**
			 *  {@inheritDoc}
			 */
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setFrom(fromEmail);
				message.setTo(toEmail);
				message.setSubject(subject);

				velocityEngine.setProperty("resource.loader", "class");
				velocityEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

				String location = environment.getProperty(templateName);

				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, location, model);
				message.setText(text, true);
			}
		};
	}

	/**
	 * Must be executed in a separated thread
	 * @param preparator
	 */
	private void execute(final MimeMessagePreparator preparator) {
		this.taskExecutor.execute(new Runnable() {
			
			@Override
			public void run() {
				javaMailSender.send(preparator);
				logger.info("mail send:");
			}
		});
	}
	
	/**
	 * Sample send test
	 */
	@Async
	@Override
	public void sendTest() throws ServiceException {
		try {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("username", "superuser");
			
			MimeMessagePreparator preparator = prepareMessage("knromeo@gmail.com", "knromeo@gmail.com",
					"Verification de compte", model, "tpl_verification");
			
			this.execute(preparator);			
		} catch (Exception e) {
			throw new ServiceException("MailService.Exception", e);
		}
	}

	private String getUniversalSender() {
		return this.environment.getRequiredProperty("email.username");
	}
	
	private String getDestination(String toEmail) {
		if (this.serviceUtil.isDevelopmentMode()) {
			String email = this.environment.getRequiredProperty("email.username");
			if (email != null)
				return email;
		}
		return toEmail;
	}
	
	@Async
	@Override
	public void sendAccountActivation(String username, String primaryEmail,
			String link, String code) throws ServiceException {
		logger.debug("send account activation code");
		try {
			if (username == null || link == null || code == null || primaryEmail == null)
				throw ServiceException.INVALID_REQUEST;
			
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("username", username);
			model.put("link", link);
			model.put("code", code);
			
			String sender = this.getUniversalSender();
			if (sender == null)
				throw new ServiceException("Default sender not found");
			
			String destination = this.getDestination(primaryEmail);
			MimeMessagePreparator preparator = prepareMessage(sender, destination,
					"Verification de compte", model, TemplateTypeEnum.REGISTRATION_VERIFICATION.getFile());
			
			this.execute(preparator);			
		} catch (Exception e) {
			logger.error("send account activation failed", e);
			throw new ServiceException("MailService Exception", e);
		}
	}

	@Override
	public List<Mail> findAll() throws ServiceException {
		logger.debug("find all mails");
		
		return this.mailDAO.findAll();
	}
	
	@Override
	public List<Mail> findAll(TemplateTypeEnum typeEnum) throws ServiceException {
		logger.debug("find all mails");
		if (typeEnum == null)
			return this.mailDAO.findAll();
		return this.mailDAO.findAll(typeEnum);
	}
	
	@Override
	public void contactUs(Mail mail) throws ServiceException {
		logger.debug("contact us");
		try {
			if (mail == null)
				throw ServiceException.INVALID_REQUEST;
			
			mail.setDestination(this.getUniversalSender());
			mail.setTemplateType(TemplateTypeEnum.CONTACT_US);
			this.mailDAO.persist(mail);
			this.sendContactUs(mail);
		} catch (Exception e) {
			logger.error("Contact us failed", e);
			throw new ServiceException("MailService Exception", e);
		}
	}
	
	@Async
	private void sendContactUs(final Mail mail) throws ServiceException {
		logger.info("send contact us");
		try {
			if (mail == null)
				throw ServiceException.INVALID_REQUEST;
			
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("from", mail.getSender());
			model.put("object", mail.getObject());
			model.put("body", mail.getBody());
		
			MimeMessagePreparator preparator = prepareMessage(mail.getSender(), this.getUniversalSender(),
					OBJECT_CONTACT_US, model, mail.getTemplateType().getFile());
			
			this.execute(preparator);			
		} catch (Exception e) {
			logger.error("send contact us failed", e);
			throw new ServiceException("MailService Exception", e);
		}
	}

	@Override
	public void recoverPassword(Integer passwordRecoveryId) throws ServiceException {
		logger.info("recover password");
		try {
			if (passwordRecoveryId == null)
				throw ServiceException.INVALID_REQUEST;
			
			PasswordRecovery passwordRecovery = this.passwordRecoveryDAO.findById(passwordRecoveryId);
			if (passwordRecovery == null)
				throw ServiceException.INVALID_REQUEST;
			
			Mail mail = new Mail();
			mail.setSender(this.getUniversalSender());
			mail.setDestination(passwordRecovery.getAccount().getUser().getPrimaryEmail());
			mail.setTemplateType(TemplateTypeEnum.PASSWORD_RECOVERY);
			mail.setObject(OBJECT_PASSWORD_RECOVERY);
			mail.setBody(DEFAULT_BODY);
			
			this.mailDAO.persist(mail);
			
			this.sendPasswordRecovery(mail, passwordRecovery.getAccount().getUser().getUsername(),
					this.serviceUtil.buildLink("jsp/user/editPassword.jsf", passwordRecovery.getToken()),
					passwordRecovery.getToken());
		} catch (Exception e) {
			logger.error("recover password failed", e);
			throw new ServiceException("MailService Exception", e);
		}
	}

	@Async
	private void sendPasswordRecovery(Mail mail, String username, String link, String token) throws ServiceException {
		logger.info("send password recovery");
		try {
			if (mail == null || username == null || link == null)
				throw ServiceException.INVALID_REQUEST;
			
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("token", token);
			model.put("username", username);
			model.put("link", link);

			MimeMessagePreparator preparator = prepareMessage(this.getUniversalSender(), this.getDestination(mail.getSender()),
					OBJECT_PASSWORD_RECOVERY, model, mail.getTemplateType().getFile());
			
			this.execute(preparator);			
		} catch (Exception e) {
			logger.error("send password reconvery failed", e);
			throw new ServiceException("MailService Exception", e);
		}
		
	}
}
