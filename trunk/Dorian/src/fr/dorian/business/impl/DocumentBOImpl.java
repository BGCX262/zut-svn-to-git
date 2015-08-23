package fr.dorian.business.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import fr.dorian.business.DocumentBO;
import fr.dorian.model.Account;
import fr.dorian.model.Document;
import fr.dorian.service.dao.AccountDAO;
import fr.dorian.service.dao.DocumentDAO;
import fr.dorian.service.exception.ServiceException;

@Service
@Scope("session")
public class DocumentBOImpl implements DocumentBO, Serializable {

	private static final long serialVersionUID = -8433210629042328358L;

	private static final Logger logger = Logger.getLogger(DocumentBO.class);

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	private DocumentDAO documentDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public List<Document> findByAccountId(Integer accountId)
			throws ServiceException {
		try {
			if (accountId == null)
				throw ServiceException.INVALID_REQUEST;
			
			Account account = this.accountDAO.findById(accountId);
			if (account == null)
				throw ServiceException.INVALID_REQUEST;
			
			return this.documentDAO.findByAccount(account);
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}

	@Override
	public List<Document> findAll() throws ServiceException {
		logger.debug("find all");
		return this.documentDAO.findAll();
	}

}
