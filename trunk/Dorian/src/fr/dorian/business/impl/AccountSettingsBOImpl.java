package fr.dorian.business.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import fr.dorian.business.AccountSettingsBO;
import fr.dorian.model.Account;
import fr.dorian.model.AccountSettings;
import fr.dorian.service.dao.AccountDAO;
import fr.dorian.service.dao.AccountSettingsDAO;
import fr.dorian.service.exception.ServiceException;

@Service
@Scope("session")
public class AccountSettingsBOImpl implements AccountSettingsBO, Serializable {
	
	private static final long serialVersionUID = 6818445545309518402L;

	private static final Logger logger = Logger.getLogger(AccountSettingsBO.class);
	
	@Autowired
	private AccountSettingsDAO accountSettingsDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	@Override
	public AccountSettings findByAccountId(Integer accountId) throws ServiceException {
		logger.debug("find by account id");
		try {
			if (accountId == null)
				throw ServiceException.INVALID_REQUEST;
			
			Account account = this.accountDAO.findById(accountId);
			if (account == null)
				throw ServiceException.INVALID_REQUEST;
			return (this.accountSettingsDAO.findByAccount(account));
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}

	@Override
	public void update(AccountSettings settings) throws ServiceException {
		logger.debug("update");
		try {
			if (settings == null)
				throw ServiceException.INVALID_REQUEST;
			this.accountSettingsDAO.update(settings);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}
}
