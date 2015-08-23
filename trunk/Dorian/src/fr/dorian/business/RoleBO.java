package fr.dorian.business;

import java.util.List;

import fr.dorian.model.Role;
import fr.dorian.service.exception.ServiceException;

public interface RoleBO {

	List<Role> findByAccountId(Integer accountId) throws ServiceException;

	List<Role> findAll() throws ServiceException;

}
