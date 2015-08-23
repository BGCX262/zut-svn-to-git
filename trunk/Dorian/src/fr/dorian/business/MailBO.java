package fr.dorian.business;

import java.util.List;

import fr.dorian.model.Mail;
import fr.dorian.model.enums.TemplateTypeEnum;
import fr.dorian.service.exception.ServiceException;

public interface MailBO {

	public static final String OBJECT_CONTACT_US 	= "Contact us";

	public static final String OBJECT_PASSWORD_RECOVERY = "Password recovery";
	
	public static final String DEFAULT_BODY			= "";  
	
	
	
	void sendTest() throws ServiceException;

	void sendAccountActivation(String username, String primaryEmail, String link, String code) throws ServiceException;
	
	List<Mail> findAll() throws ServiceException;

	void contactUs(Mail mail) throws ServiceException;

	List<Mail> findAll(TemplateTypeEnum typeEnum) throws ServiceException;

	void recoverPassword(Integer passwordRecoveryId) throws ServiceException;

}
