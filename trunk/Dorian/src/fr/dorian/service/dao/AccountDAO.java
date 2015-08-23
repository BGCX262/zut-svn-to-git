package fr.dorian.service.dao;

import fr.dorian.model.Account;
import fr.dorian.model.User;

public interface AccountDAO extends IDAO<Account> {

	Account findByEmail(String email);

	Account findByUser(User user);

}
