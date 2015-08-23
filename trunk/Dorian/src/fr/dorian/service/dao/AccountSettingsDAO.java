package fr.dorian.service.dao;

import fr.dorian.model.Account;
import fr.dorian.model.AccountSettings;

public interface AccountSettingsDAO extends IDAO<AccountSettings> {

	AccountSettings findByAccount(Account account);

}
