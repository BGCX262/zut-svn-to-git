package fr.dorian.web.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.dorian.business.AccountInfosBO;
import fr.dorian.model.AccountInfos;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.web.AccountInfosBean;


@Controller("accountInfosBean")
@Scope("session")
public class AccountInfosBeanImpl implements AccountInfosBean, Serializable
{
	//Controller utils
	
	private static final long serialVersionUID = -5275951772131740810L;
	public static Logger logger = Logger.getLogger(AccountBeanImpl.class);
	
	//Properties
	
	@Autowired
	private AccountInfosBO accountInfosBO;
	
	//Transactional methods
	
	@Override
	public AccountInfos findAccountInfosFromAccountId(Integer accountId) {
		logger.debug("CONTROLLER:findReputationFromAccountId - accountId=" + accountId);
		try {
			return (this.accountInfosBO.findByAccountId(accountId));
		} catch (ServiceException e) {
			logger.error("find by account id failed", e);
		}
		return null;
	}

	@Override
	public void updateAccountInfosByAccountId(Integer accountId) {
		logger.debug("CONTROLLER:increaseReputationByAccountId - accountId=" + accountId);
		try {
			this.accountInfosBO.update(accountId, 5);
		} catch (ServiceException e) {
			logger.error("update by account id failed", e);
		}
	}
}
