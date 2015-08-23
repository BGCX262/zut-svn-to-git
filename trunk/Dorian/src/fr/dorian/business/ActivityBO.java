package fr.dorian.business;

import java.util.List;

import fr.dorian.model.Activity;
import fr.dorian.service.exception.ServiceException;

public interface ActivityBO {

	void addCommandActivity(Activity activity) throws ServiceException;

	List<Activity> findByAccountId(Integer accountId) throws ServiceException;

	List<Activity> findByThreadId(Integer threadId) throws ServiceException;

}
