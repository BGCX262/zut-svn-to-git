package fr.dorian.business;

import fr.dorian.model.AccountInfos;
import fr.dorian.service.exception.ServiceException;

public interface AccountInfosBO
{
	public abstract AccountInfos findByAccountId(Integer accountId) throws ServiceException;
	public abstract void update(Integer accountId, Integer value) throws ServiceException;
}
