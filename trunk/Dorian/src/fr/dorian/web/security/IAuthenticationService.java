package fr.dorian.web.security;

import fr.dorian.service.exception.ServiceException;

public interface IAuthenticationService 
{
	public boolean login(String username, String password) throws ServiceException;

	public void logout();

	boolean isLogged();

	//public User getLoggedUser();
	//public AuthenticationUserDetails getLoggedUserDetails();

}