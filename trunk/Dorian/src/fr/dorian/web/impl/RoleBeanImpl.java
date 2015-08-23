package fr.dorian.web.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import fr.dorian.business.RoleBO;
import fr.dorian.model.Role;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.web.RoleBean;
import fr.dorian.web.security.Secure;

@Controller("roleBean")
@Scope("session")
public class RoleBeanImpl implements RoleBean, Serializable {

	private static final long serialVersionUID = -8896139229165239743L;

	private static final Logger logger = Logger.getLogger(RoleBean.class);
	
	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired(required = true)
	private RoleBO roleBO;
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public List<Role> getForAccount(Integer accountId) {
		logger.debug("get role for account");
		try {
			return this.roleBO.findByAccountId(accountId);
		} catch (ServiceException e) {
			logger.error("find for account failed", e);
		}
		return null;
	}
	
	@Override
	@Secured(Secure.ROLE_SUPERVISOR)
	public List<Role> getAllRoles() {
		try {
			return this.roleBO.findAll();
		} catch (ServiceException e) {
			logger.error("find all failed", e);
		}
		return null;
	}
	
	@Override
	@Secured(Secure.ROLE_SUPERVISOR)
	public void addRole() {
		logger.debug("add role");
	}
}
