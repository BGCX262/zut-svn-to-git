package fr.dorian.web.security.impl;

import java.io.Serializable;

import javax.faces.application.FacesMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import fr.dorian.model.User;
import fr.dorian.service.dao.UserDAO;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.web.IKeyRepository;
import fr.dorian.web.security.IAuthenticationService;
import fr.dorian.web.util.WebHelper;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService, Serializable {

	private static final long serialVersionUID = 5574911434008090506L;

	private static Logger logger = Logger.getLogger(AuthenticationServiceImpl.class);
	
	@Autowired(required = true)
	private AuthenticationManager 	authenticationManager;
	
	@Autowired(required = true)
	private IKeyRepository 			keyRepository;
	
	@Autowired
	private UserDAO	userDAO;
	
	@Override
	public boolean login(String username, String password) throws ServiceException {
		logger.debug(String.format("login with login [%s] and password [%s]", username, password));
		try	{
			if (username == null || password == null) 
				throw ServiceException.INVALID_REQUEST;
			
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
			Authentication authenticate = authenticationManager.authenticate(token);
			if (authenticate.isAuthenticated())	{
				SecurityContextHolder.getContext().setAuthentication(authenticate);
				return true;			
			}
		} catch (AuthenticationException e) 	{
			WebHelper.addMessageFromBundle(keyRepository.getResourceBundle(), "message.login.error", e.getMessage(), FacesMessage.SEVERITY_ERROR);
			SecurityContextHolder.getContext().setAuthentication(null);
			logger.error(ServiceException.INTERNAL_ERROR, e);
		}
		return false;
	}

	@Override
	public void logout() {
		logger.debug("logout");
		SecurityContextHolder.getContext().setAuthentication(null);
		SecurityContextHolder.clearContext();
	}

	@Override
	public boolean isLogged() {
		boolean result = false;
		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated())
			result = false;
		
		if (authentication != null && authentication.getPrincipal() != null && authentication.getPrincipal() instanceof User)
			result = true;
		
		return result;
	}

    // ACCESSORS
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public AuthenticationManager getAuthenticationManager() 		{return authenticationManager;}
	public IKeyRepository getKeyRepository()						{return keyRepository;}

	public void setAuthenticationManager(AuthenticationManager am) 	{this.authenticationManager = am;}
	public void setKeyRepository(IKeyRepository keyRepository)		{this.keyRepository 		= keyRepository;}
}