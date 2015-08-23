package fr.dorian.business.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import fr.dorian.business.AccountInfosBO;
import fr.dorian.model.Account;
import fr.dorian.model.AccountInfos;
import fr.dorian.service.dao.AccountDAO;
import fr.dorian.service.dao.AccountInfosDAO;
import fr.dorian.service.exception.ServiceException;

@Service
@Scope("session")
public class AccountInfosBOImpl implements AccountInfosBO, Serializable {
	//Service utils
	
	private static final long serialVersionUID = 6619560069752889552L;
	
	private static final Logger logger = Logger.getLogger(AccountInfosBO.class);
	
	@Autowired
	private AccountInfosDAO accountInfosDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	//Transactional methods
	
	@Override
	public AccountInfos findByAccountId(Integer accountId) throws ServiceException {
		logger.debug("find by account id");
		try {
			if (accountId == null)
				throw ServiceException.INVALID_REQUEST;
			
			Account account = this.accountDAO.findById(accountId);
			if (account == null)
				throw ServiceException.INVALID_REQUEST;
			return (this.accountInfosDAO.findByAccount(account));
			
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}

	@Override
	public void update(Integer accountId, Integer value) throws ServiceException {
		logger.debug("update account infos by account id");
		try {
			if (accountId == null)
				throw ServiceException.INVALID_REQUEST;
			
			AccountInfos accountInfos = this.findByAccountId(accountId);
			if (accountInfos == null)
				throw ServiceException.INVALID_REQUEST;
			
			accountInfos.setReputation(accountInfos.getReputation() + value);
			this.accountInfosDAO.update(accountInfos);
		} catch (Exception e) {
			logger.error("Internal error", e);
		}
	}
}
