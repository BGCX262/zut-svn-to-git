package fr.dorian.web.security.impl;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component("dorianAuthenticationProvider")
public class DorianAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider implements Serializable {

	private static final long serialVersionUID = -8020783022697604960L;
	
	private static final Log log = LogFactory.getLog(DorianAuthenticationProvider.class);

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SaltSource saltSource;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	// OVERRIDES
	///////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected UserDetails retrieveUser(String username,
			UsernamePasswordAuthenticationToken authenticationToken)
					throws AuthenticationException {
		log.debug("retrieve user");

		UserDetails loadedUserDetails = null;

		try {
			loadedUserDetails = this.userDetailsService.loadUserByUsername(username);
		} catch (UsernameNotFoundException usernameNotFoundException) {
			throw usernameNotFoundException;
		} catch (Exception internalException) {
			throw new AuthenticationServiceException(internalException.getMessage(), internalException);
		}

		if (loadedUserDetails == null) {
			throw new AuthenticationServiceException("UserDetailsService returned null, which is an interface acces violation");
		}
		return loadedUserDetails;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken)
					throws AuthenticationException {
		log.info("additional authentication checks");

		Object salt = null;
		if (this.saltSource != null)
			salt = this.saltSource.getSalt(userDetails);

		if (usernamePasswordAuthenticationToken.getCredentials() == null) {
			log.debug("Authentication failed: no credentials provided");
			throw new BadCredentialsException("AbstractUserDetailsAuthenticationProvider : Bad credentials");
		}

		String presentedPassword = usernamePasswordAuthenticationToken.getCredentials().toString();

		if (!this.passwordEncoder.isPasswordValid(userDetails.getPassword(), presentedPassword, salt)) {
			log.debug("Authentication failed: password does not match stored value");
			throw new BadCredentialsException("AbstractUserDetailsAuthenticationProvider : Bad credentials");
		}

		if(!userDetails.isAccountNonLocked()) {
			log.debug("Authentication failed: user's account is locked");
			throw new LockedException("AbstractUserDetailsAuthenticationProvider : user's account is locked");
		}

		if (!userDetails.isEnabled()) {
			log.debug("Authentication failed: user's account is not verified");
			throw new LockedException("AbstractUserDetailsAuthenticationProvider : user's account is not verified");			
		}

	}
}
