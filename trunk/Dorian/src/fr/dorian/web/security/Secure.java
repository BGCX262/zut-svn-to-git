package fr.dorian.web.security;

/**
 * A utiliser pour les {@link org.springframework.security.access.annotation.Secured}
 * @author kone_a
 *
 */

public interface Secure {

	public static final String ROLE_SUPERVISOR	= "ROLE_SUPERVISOR"; 

	public static final String ROLE_TELLER		= "ROLE_TELLER"; 
	
	public static final String ROLE_USER		= "ROLE_USER"; 
}
