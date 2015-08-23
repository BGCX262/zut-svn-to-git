package fr.dorian.web.security.impl;

import java.io.Serializable;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;

public class AccessDecisionManagerImpl implements AccessDecisionManager, Serializable {

	private static final long serialVersionUID = -6808522355454132776L;
	
	private static final Log log = LogFactory.getLog(AccessDecisionManager.class);

	// OVERRIDES
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException,
			InsufficientAuthenticationException {
		log.info("decide");
		if (object instanceof ReflectiveMethodInvocation) {
			log.info("ReflectiveMethodInvocation");
			
			if (!authentication.isAuthenticated())
				throw new AccessDeniedException("Not authenticated");

			if (configAttributes.size() < 1)
				throw new InsufficientAuthenticationException("Configuration arguments missing.");

		}
	}

	@Override
	public boolean supports(ConfigAttribute arg0) {
		return true;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////

	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////


}
