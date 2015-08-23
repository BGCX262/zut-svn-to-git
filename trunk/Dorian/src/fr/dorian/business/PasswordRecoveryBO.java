package fr.dorian.business;

import fr.dorian.service.exception.NotFoundException;
import fr.dorian.service.exception.ServiceException;

public interface PasswordRecoveryBO {

	void generateAndSendUrl(String email) throws ServiceException, NotFoundException;

	void validate(String email, String token) throws ServiceException;

	void resetPassword(String email, String token) throws ServiceException;


}
