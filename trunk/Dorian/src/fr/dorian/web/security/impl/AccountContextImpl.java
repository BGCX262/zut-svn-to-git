package fr.dorian.web.security.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dorian.model.Account;
import fr.dorian.model.User;
import fr.dorian.service.dao.AccountDAO;
import fr.dorian.web.security.AccountContext;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES, value = "request")
@Transactional(readOnly = true)
public class AccountContextImpl implements AccountContext, Serializable {

	private static final long serialVersionUID = 4572249434157535444L;

	private static final Logger logger = Logger.getLogger(AccountContext.class);
	
	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	private Account currentAccount;
	
	@Autowired
	private AccountDAO accountDAO;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public Account getCurrentAccount() {
		logger.trace("get current account");
		try {
			if (this.currentAccount == null) {
				Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
				if (!authentication.isAuthenticated())
					return this.currentAccount;
				
				if (authentication != null && authentication.getPrincipal() != null && authentication.getPrincipal() instanceof User)
					this.currentAccount = this.accountDAO.findByUser(((User) authentication.getPrincipal()));
			}

			return this.currentAccount; 
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void setCurrentAccount(Account currentAccount) {this.currentAccount = currentAccount;}

	@Override
	public User getCurrentUser() {
		return this.getCurrentAccount().getUser();
	}

	public AccountDAO getAccountDAO() {return accountDAO;}
	public void setAccountDAO(AccountDAO accountDAO) {this.accountDAO = accountDAO;}
}
