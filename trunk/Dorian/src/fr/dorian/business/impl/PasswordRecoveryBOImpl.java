package fr.dorian.business.impl;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.stereotype.Service;

import fr.dorian.business.AccountBO;
import fr.dorian.business.MailBO;
import fr.dorian.business.PasswordRecoveryBO;
import fr.dorian.model.Account;
import fr.dorian.model.PasswordRecovery;
import fr.dorian.model.User;
import fr.dorian.service.dao.AccountDAO;
import fr.dorian.service.dao.PasswordRecoveryDAO;
import fr.dorian.service.exception.NotFoundException;
import fr.dorian.service.exception.ServiceException;

@Service
@Scope("session")
public class PasswordRecoveryBOImpl implements PasswordRecoveryBO, Serializable {

	private static final long serialVersionUID = -721131464245591653L;

	private static final Logger logger = Logger.getLogger(PasswordRecoveryBO.class);
	
	// PROPERTIES
	//////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private PasswordRecoveryDAO passwordRecoveryDAO;
	
	@Autowired
	private MailBO mailBO;
	
	@Autowired
	private AccountBO accountBO;
	
	@Autowired
	private SaltSource saltSource;
	
	@Autowired(required = false)
	private HttpServletRequest request;
	
	
	// PROPERTIES
	//////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void generateAndSendUrl(String email) throws ServiceException, NotFoundException {
		logger.debug("generate and send password recovery url");
		if (email == null)
			throw ServiceException.INVALID_REQUEST;

		Account account = this.accountDAO.findByEmail(email);
		if (account == null)
			throw new NotFoundException("account not found");

		List<PasswordRecovery> recoveries = this.passwordRecoveryDAO.findByAccount(account);
		for (PasswordRecovery recovery : recoveries) {
			if (!recovery.isActivated()) {
				recovery.setActivated(true);
				//recovery.setDeleted(true); // Set as deleted == will not be used
				this.passwordRecoveryDAO.update(recovery);
			}
		}

		String token = null;
		do {
			token = UUID.randomUUID().toString().replace("-", "");
		} while (!this.isTokenExists(token));

		PasswordRecovery passwordRecovery = new PasswordRecovery();
		passwordRecovery.setAccount(account);
		passwordRecovery.setActivated(false);
		passwordRecovery.setIpAddress(this.request.getRemoteAddr());
		passwordRecovery.setToken(token);

		this.passwordRecoveryDAO.persist(passwordRecovery);

		this.mailBO.recoverPassword(passwordRecovery.getId());
	}
	
	private boolean isTokenExists(String token) {
		logger.info("is token exist // " + token);
		PasswordRecovery recovery = this.passwordRecoveryDAO.findByToken(token);
		return recovery == null;
	}

	@Override
	public void validate(String email, String token) throws ServiceException {
		logger.debug("validate password recovery from email");
		try {
			if (email == null || token == null)
				throw ServiceException.INVALID_REQUEST;
			
			Account account = this.accountDAO.findByEmail(email);
			if (account == null || account.isDisabled())
				throw ServiceException.INVALID_REQUEST;
			
			PasswordRecovery recovery = this.passwordRecoveryDAO.findByAccountAndToken(account, token);
			if (recovery == null || recovery.isDeleted() || recovery.isActivated())
				throw ServiceException.INVALID_REQUEST;
			
			recovery.setActivated(true);
			this.passwordRecoveryDAO.update(recovery);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	} 
	
	@Override
	public void resetPassword(String token, String newPassword) throws ServiceException {
		logger.debug("reset password from email");
		try {
			if (token == null || newPassword == null)
				throw ServiceException.INVALID_REQUEST;
			
			PasswordRecovery recovery = this.passwordRecoveryDAO.findByToken(token);
			if (recovery == null || recovery.isDeleted() || recovery.isActivated())
				throw ServiceException.INVALID_REQUEST;

			Account account = recovery.getAccount();
			if (account == null || account.isDisabled())
				throw ServiceException.INVALID_REQUEST;
			
			User user = this.accountBO.buildPassword(account.getUser(), newPassword);
			if (user == null)
				throw ServiceException.INTERNAL_ERROR;
				
			account.setUser(user);
			this.accountDAO.update(account);

			recovery.setActivated(true);
			this.passwordRecoveryDAO.update(recovery);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);			
		}
	}
	
}
