package fr.dorian.web.security.impl;

import java.io.Serializable;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dorian.service.dao.UserDAO;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.web.security.Adapter;
import fr.dorian.model.User;

/**
 * Optionnal UserDetailsService Java implementation, providing hereby a DB users mock. 
 * The Spring Security context only allows one instance of UserDetailsService 
 * (reason why the "@Service("userDetailsService")" @nnotation is currently disabled/commented)
 * which is actually declared in the applicationContext-security, as authentication-provider.user-service node.  
 */

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService, Serializable
{
	private static final long serialVersionUID = -9054284316194761195L;

	private static final Logger logger = Logger.getLogger(UserDetailsService.class);
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private Adapter assembler;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
	{
		logger.debug(String.format("load user by username // %s", email));
		
		if (email == null)
			throw new UsernameNotFoundException("Null username", ServiceException.INVALID_REQUEST);
		
		User user = this.userDAO.findByEmail(email);
		if (user == null)
			throw new UsernameNotFoundException("UserAccount for email \"" + email + "\" not found.", ServiceException.INVALID_REQUEST);
		
		return assembler.adapte(user);
	}
}

