package fr.dorian.service.dao;

import fr.dorian.model.Account;
import fr.dorian.model.AccountInfos;


public interface AccountInfosDAO extends IDAO<AccountInfos>
{
	public abstract AccountInfos findByAccount(Account account);
}
