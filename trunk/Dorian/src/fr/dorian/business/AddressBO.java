package fr.dorian.business;

import java.util.List;

import fr.dorian.model.Address;
import fr.dorian.service.exception.ServiceException;

public interface AddressBO {

	List<Address> findByAccountId(Integer accountId) throws ServiceException;

	List<Address> findAll() throws ServiceException;

}
