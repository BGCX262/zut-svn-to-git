package fr.dorian.web.security.impl;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import fr.dorian.service.dao.AccountDAO;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.web.security.Adapter;
import fr.dorian.model.Account;
import fr.dorian.model.Role;
import fr.dorian.model.User;

@Service("adapter")
public class AdapterImpl implements Adapter, Serializable {

	private static final long serialVersionUID = 6653852355555343213L;

	private static final Logger logger = Logger.getLogger(Adapter.class);

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private AccountDAO accountDAO;
	
	@Override
	public UserDetails adapte(User user) {
		logger.debug("adapte user");

		try {			
			if (user == null)
				throw ServiceException.INVALID_REQUEST;

			Account account = this.accountDAO.findByEmail(user.getPrimaryEmail());
			Set<Role> roles = account.getRoles();

			Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
			for (Role role : roles)
				authorities.add(new SimpleGrantedAuthority(role.getName()));

			user.addDetails(account.isEnabled(), account.isAccountNonExpired(),
					account.isCredentialsNonExpired(), account.isAccountNonLocked(), authorities);
		} catch (ServiceException e) {
			logger.error("adapte failed", e);
		}
		return user;
	} 
}
