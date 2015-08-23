package fr.dorian.business.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import fr.dorian.business.ActivityBO;
import fr.dorian.model.Activity;
import fr.dorian.service.dao.AccountDAO;
import fr.dorian.service.dao.ActivityDAO;
import fr.dorian.service.exception.ServiceException;

@Service
@Scope("session")
public class ActivityBOImpl implements ActivityBO, Serializable {

	private static final long serialVersionUID = -7824039746893804180L;
	
	private static final Logger logger = Logger.getLogger(ActivityBO.class);

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	private ActivityDAO activityDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	// HELPER
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void addCommandActivity(Activity activity) throws ServiceException {
		
		if (activity == null)
			throw ServiceException.INVALID_REQUEST;
		
		this.activityDAO.persist(activity);
	}
	
	@Override
	public List<Activity> findByAccountId(Integer accountId) throws ServiceException {
		logger.info("find activities for account");
		try {
			if (accountId == null) 
				throw ServiceException.INVALID_REQUEST;
			
			return this.activityDAO.findByAccount(accountId);			
		} catch (Exception e) {
			throw new ServiceException("Internal_Error", e);
		}
	}

	@Override
	public List<Activity> findByThreadId(Integer threadId) throws ServiceException {
		throw new UnsupportedOperationException();
	}
}
