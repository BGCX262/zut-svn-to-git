package fr.dorian.business;

import java.util.List;

import fr.dorian.model.Profile;
import fr.dorian.service.exception.ServiceException;

public interface ProfileBO {

	List<Profile> findByAccountId(Integer accountId) throws ServiceException;

	List<Profile> findAll() throws ServiceException;

}
