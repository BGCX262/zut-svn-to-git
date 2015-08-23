package fr.dorian.business;

import fr.dorian.model.AccountActivation;
import fr.dorian.model.User;
import fr.dorian.service.exception.ServiceException;

public interface AccountActivationBO {

	AccountActivation findById(Integer accountActivationId)	throws ServiceException;
	
	AccountActivation findByCode(String activationCode) throws ServiceException;

	void registerActivationCodeForUser(User user, String code) throws ServiceException;

	void activateAccount(String code) throws ServiceException;

}
