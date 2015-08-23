package fr.dorian.business.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import fr.dorian.business.AddressBO;
import fr.dorian.model.Account;
import fr.dorian.model.Address;
import fr.dorian.service.dao.AccountDAO;
import fr.dorian.service.dao.AddressDAO;
import fr.dorian.service.exception.ServiceException;

@Service
@Scope("session")
public class AddressBOImpl implements AddressBO, Serializable {

	private static final long serialVersionUID = 5348454741415475032L;

	private static final Logger logger = Logger.getLogger(AddressBO.class);

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	private AddressDAO addressDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public List<Address> findByAccountId(Integer accountId)
			throws ServiceException {
		try {
			if (accountId == null)
				throw ServiceException.INVALID_REQUEST;
			
			Account account = this.accountDAO.findById(accountId);
			if (account == null)
				throw ServiceException.INVALID_REQUEST;
			
			return this.addressDAO.findByAccount(account);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}

	@Override
	public List<Address> findAll() throws ServiceException {
		logger.debug("find all");
		return this.addressDAO.findAll();
	}

}
