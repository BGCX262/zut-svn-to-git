package fr.dorian.business;

import fr.dorian.model.AccountSettings;
import fr.dorian.service.exception.ServiceException;

public interface AccountSettingsBO {

	AccountSettings findByAccountId(Integer accountId) throws ServiceException;

	void update(AccountSettings settings) throws ServiceException;

}
