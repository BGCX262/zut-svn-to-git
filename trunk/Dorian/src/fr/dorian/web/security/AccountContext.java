package fr.dorian.web.security;

import fr.dorian.model.Account;
import fr.dorian.model.User;

public interface AccountContext {

	Account getCurrentAccount();

	User getCurrentUser();

}
