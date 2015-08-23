package fr.dorian.web.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface Adapter {

	UserDetails adapte(fr.dorian.model.User user);

}
