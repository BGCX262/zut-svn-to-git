package fr.dorian.web;

import fr.dorian.model.AccountInfos;

public interface AccountInfosBean
{
	public abstract AccountInfos findAccountInfosFromAccountId(Integer accountId);
	public abstract void updateAccountInfosByAccountId(Integer accountId);
}
