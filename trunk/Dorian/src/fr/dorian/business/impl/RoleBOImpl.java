package fr.dorian.business.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import fr.dorian.business.RoleBO;
import fr.dorian.model.Account;
import fr.dorian.model.Role;
import fr.dorian.service.dao.AccountDAO;
import fr.dorian.service.dao.RoleDAO;
import fr.dorian.service.exception.ServiceException;

@Service
@Scope("session")
public class RoleBOImpl implements RoleBO, Serializable {

	private static final long serialVersionUID = -4833454140332384750L;
	
	private static final Logger logger = Logger.getLogger(RoleBO.class);

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	private RoleDAO roleDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public List<Role> findByAccountId(Integer accountId)
			throws ServiceException {
		try {
			if (accountId == null)
				throw ServiceException.INVALID_REQUEST;
			
			Account account = this.accountDAO.findById(accountId);
			if (account == null)
				throw ServiceException.INVALID_REQUEST;
			
			return this.roleDAO.findByAccount(account);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}

	@Override
	public List<Role> findAll() throws ServiceException {
		logger.debug("find all");
		return this.roleDAO.findAll();
	}

}
