package fr.dorian.service.dao;

import java.util.List;

import fr.dorian.model.Account;
import fr.dorian.model.Address;

public interface AddressDAO extends IDAO<Address> {

	List<Address> findByAccount(Account account);
}
