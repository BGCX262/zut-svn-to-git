package fr.dorian.business.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import fr.dorian.business.ProfileBO;
import fr.dorian.model.Account;
import fr.dorian.model.Profile;
import fr.dorian.service.dao.AccountDAO;
import fr.dorian.service.dao.ProfileDAO;
import fr.dorian.service.exception.ServiceException;

@Service
@Scope("session")
public class ProfileBOImpl implements ProfileBO, Serializable {

	private static final long serialVersionUID = 8583739764793134740L;

	private static final Logger logger = Logger.getLogger(ProfileBO.class);

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	private ProfileDAO profileDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public List<Profile> findByAccountId(Integer accountId)throws ServiceException {
		try {
			if (accountId == null)
				throw ServiceException.INVALID_REQUEST;
			
			Account account = this.accountDAO.findById(accountId);
			if (account == null)
				throw ServiceException.INVALID_REQUEST;
			
			return this.profileDAO.findByAccount(account);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}

	@Override
	public List<Profile> findAll() throws ServiceException {
		logger.debug("find all");
		return this.profileDAO.findAll();
	}

}
