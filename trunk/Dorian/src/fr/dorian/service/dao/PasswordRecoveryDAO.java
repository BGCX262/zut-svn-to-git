package fr.dorian.service.dao;

import java.util.List;

import fr.dorian.model.Account;
import fr.dorian.model.PasswordRecovery;

public interface PasswordRecoveryDAO extends IDAO<PasswordRecovery> {

	PasswordRecovery findByAccountAndToken(Account account, String token);

	List<PasswordRecovery> findByAccount(Account account);

	List<PasswordRecovery> findByAccountIdAndActive(Account account,
			boolean active);

	PasswordRecovery findByToken(String token);

}
