package fr.dorian.business.impl;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import fr.dorian.business.AccountActivationBO;
import fr.dorian.model.Account;
import fr.dorian.model.AccountActivation;
import fr.dorian.model.AccountInfos;
import fr.dorian.model.AccountSettings;
import fr.dorian.model.Profile;
import fr.dorian.model.User;
import fr.dorian.model.enums.RoleTypeEnum;
import fr.dorian.service.dao.AccountActivationDAO;
import fr.dorian.service.dao.AccountDAO;
import fr.dorian.service.dao.AccountInfosDAO;
import fr.dorian.service.dao.AccountSettingsDAO;
import fr.dorian.service.dao.ProfileDAO;
import fr.dorian.service.dao.RoleDAO;
import fr.dorian.service.dao.UserDAO;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.service.util.ServiceUtil;


@Service
@Scope("session")
public class AccountActivationBOImpl implements AccountActivationBO, Serializable {

	private static final long serialVersionUID = 6697176766131915457L;

	private static final Logger logger = Logger.getLogger(AccountActivationBO.class);
	
	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Autowired
	private AccountActivationDAO accountActivationDAO;
	
	@Autowired
	private ServiceUtil serviceUtil;
	
	@Autowired
	private AccountInfosDAO accountInfosDAO;

	@Autowired
	private AccountSettingsDAO accountSettingsDAO;
	
	@Autowired
	private ProfileDAO profileDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private RoleDAO roleDAO;
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	// OVERRIDES
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public AccountActivation findById(Integer accountActivationId) throws ServiceException {
		logger.debug("find by id");
		try {
			if (accountActivationId == null)
				throw ServiceException.INVALID_REQUEST;
			return this.accountActivationDAO.findById(accountActivationId);
		} catch (Exception e) {
			throw new ServiceException("INTERNAL_ERROR", e);
		}
	}
	
	@Override
	public AccountActivation findByCode(String activationCode) throws ServiceException {
		logger.debug("find by code");
		try {
			if (activationCode == null)
				throw ServiceException.INVALID_REQUEST;
			return this.accountActivationDAO.findByCode(activationCode);
		} catch (Exception e) {
			throw new ServiceException("INTERNAL_ERROR", e);
		}
	}
	
	@Override
	public void registerActivationCodeForUser(User user, String code) throws ServiceException {
		logger.debug("before activation");
		try {
			if (user == null) 
				throw ServiceException.INVALID_REQUEST;
			
			AccountActivation accountActivation = new AccountActivation();
			accountActivation.setUser(user);
			accountActivation.setCreatedAt(Calendar.getInstance().getTime());
			accountActivation.setCode(code);
			
			this.accountActivationDAO.persist(accountActivation);
		} catch (Exception e) {
			throw new ServiceException("INTERNAL_ERROR", e);
		}
	}
	
	@Override
	public void activateAccount(String code) throws ServiceException {
		logger.debug("before activation");
		try {
			if (code == null)
				throw ServiceException.INVALID_REQUEST;
			
			Map<String, Object> details = this.serviceUtil.decodeUser(code);
			if (details == null || details.size() != 2)
				throw ServiceException.INVALID_REQUEST;
			
			Integer userId = (Integer) details.get(ServiceUtil.ID);
			User user = this.userDAO.findById(userId);
			if (user == null)
				throw ServiceException.INVALID_REQUEST;

			AccountActivation accountActivation = this.accountActivationDAO.findByCode(code);
			if (accountActivation == null || accountActivation.isActivated())
				throw ServiceException.INVALID_REQUEST;

			if (!accountActivation.getUser().getId().equals(userId))
				throw new ServiceException("invalide code or userId");
			
			accountActivation.setActivated(true);
			accountActivation.setActivatedAt(Calendar.getInstance().getTime());
			this.accountActivationDAO.update(accountActivation);
			
			Account account = new Account();
			account.setExpired(false);
			account.setDisabled(false);
			account.setExpired(false);
			account.setLocked(false);
			account.setUser(user);
			account.addRole(this.roleDAO.findByName(RoleTypeEnum.ROLE_USER.getAuthority()));
			
			this.accountDAO.persist(account);
			
			// Creates account settings
			AccountSettings accountSettings = new AccountSettings();
			accountSettings.setAccount(account);
			accountSettings.setNotifierComment(true);
			accountSettings.setNotifierPost(true);
			this.accountSettingsDAO.persist(accountSettings);
			
			// Creates profile
			Profile profile = new Profile(account);
			this.profileDAO.persist(profile);
			
			AccountInfos accountInfos = new AccountInfos();
			accountInfos.setAccount(account);
			accountInfos.setReputation(new Long(5));
			
			this.accountInfosDAO.persist(accountInfos);
		} catch (Exception e) {
			throw new ServiceException("INTERNAL_ERROR", e);
		}
		
	}
}
