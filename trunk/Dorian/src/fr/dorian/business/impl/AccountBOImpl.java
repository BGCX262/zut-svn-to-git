package fr.dorian.business.impl;

import java.io.Serializable;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.dorian.business.AccountActivationBO;
import fr.dorian.business.AccountBO;
import fr.dorian.business.MailBO;
import fr.dorian.model.Account;
import fr.dorian.model.User;
import fr.dorian.service.dao.AccountDAO;
import fr.dorian.service.dao.RoleDAO;
import fr.dorian.service.dao.UserDAO;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.service.util.ServiceUtil;

@Service
@Scope("session")
public class AccountBOImpl implements AccountBO, Serializable {

	private static final long serialVersionUID = -8596920920919620944L;

	private static final Logger log = Logger.getLogger(AccountBO.class);

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Autowired
	private AccountActivationBO accountActivationBO;
	
	@Autowired
	private MailBO mailService;

	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RoleDAO roleDAO;
	
	@Autowired
	private SaltSource saltSource;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ServiceUtil serviceUtil;
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	// 
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void registerUser(String email, String password, String username) throws ServiceException {
		log.debug("register account");
		try {
			if (email == null || password == null) 
				throw ServiceException.INVALID_REQUEST;
			
			User user = new User();
			user.setPrimaryEmail(email);
			user.setUsername(username);

			Object salt = this.saltSource.getSalt(user);
			String passwordHash = this.passwordEncoder.encodePassword(password, salt);
			user.setPassword(passwordHash);
			
			this.userDAO.persist(user);
			String code = this.serviceUtil.encodeUser(user);
			this.accountActivationBO.registerActivationCodeForUser(user, code);
			
			String link = this.serviceUtil.buildLink("jsp/user/verify.jsf", code);
			this.mailService.sendAccountActivation(user.getUsername(), user.getPrimaryEmail(), link, code);
			
		} catch (Exception e) {
			throw new ServiceException("INTERNAL_ERROR", e);
		}
	}
	
	@Override
	public User buildPassword(User user, String newPassword) throws ServiceException {
		log.debug("changes password");
		try {
			if (user == null || newPassword == null)
				throw ServiceException.INVALID_REQUEST;
			
			Object salt = this.saltSource.getSalt(user);
			String passwordHash = this.passwordEncoder.encodePassword(newPassword, salt);
			user.setPassword(passwordHash);
			
			this.userDAO.update(user);
			return user;
		} catch (Exception e) {
			throw new ServiceException("INTERNAL_ERROR", e);
		}
	}

	@Override
	public Account findByEmail(String email) throws ServiceException {
		log.debug("find by id");
		try {
			if (email == null)
				throw ServiceException.INVALID_REQUEST;
			
			return this.accountDAO.findByEmail(email);
		} catch (Exception e) {
			log.error("An exception occured ", e);
			throw new ServiceException("INTERNAL_ERROR", e);
		}
	}

	@Override
	public void update(Account account) throws ServiceException {
		log.debug("udapte");
		try {
			if (account == null) 
				throw ServiceException.INVALID_REQUEST;
			
			this.accountDAO.update(account);
		} catch (Exception e) {
			throw new ServiceException("INTERNAL_ERROR", e);
		}
	}

	@Override
	public Account findById(Integer accountId) throws ServiceException {
		log.debug("find by Id");
		try {
			if (accountId == null)
				throw ServiceException.INVALID_REQUEST;
			
			return this.accountDAO.findById(accountId);
		} catch (Exception e) {
			throw new ServiceException("INTERNAL_ERROR", e);
		}
	}
	
	@Override
	public List<Account> findAll() throws ServiceException {
		log.debug("find all accounts");
		try {
			return this.accountDAO.findAll();
		} catch (Exception e) {
			throw new ServiceException("INTERNAL_ERROR", e);
		}
	}

	@Override
	public Account findByUserId(Integer principalId) throws ServiceException {
		log.debug("find by userId");
		try {
			if (principalId == null)
				throw ServiceException.INVALID_REQUEST;
			User user = this.userDAO.findById(principalId);
			if (user == null)
				throw ServiceException.INVALID_REQUEST;
			return this.accountDAO.findByUser(user);
		} catch (Exception e) {
			throw new ServiceException("INTERNAL_ERROR", e);
		}
	}

	@Override
	public List<Account> findByReputation() throws ServiceException {
		log.debug("find all by reputation");
		try {
			
			return this.accountDAO.findAll();
		} catch (Exception e) {
			throw new ServiceException("find by reputation failed", e);
		}
	}

	/**
	 * Close or open account
	 * <br> status = true for close
	 * <br> status = false for open
	 */
	@Override
	public void closeOrOpen(Integer accountId, boolean status) throws ServiceException {
		log.debug("close account");
		try {
			if (accountId == null)
				throw ServiceException.INVALID_REQUEST;
			
			Account account = this.accountDAO.findById(accountId);
			if (account == null)
				throw ServiceException.INVALID_REQUEST;
			
			account.setDisabled(status);
			this.accountDAO.update(account);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}

	@Override
	public void changePassword(Integer id, String newPassword) throws ServiceException {
		log.debug("change password");
		try {
			if (id == null || newPassword == null)
				throw ServiceException.INVALID_REQUEST;
			
			Account account = this.findById(id);
			if (account == null) 
				throw ServiceException.INVALID_REQUEST;
			
			User user = this.buildPassword(account.getUser(), newPassword);
			account.setUser(user);
			
			this.accountDAO.update(account);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}
}
