package fr.dorian.service.dao;

import java.util.List;

import fr.dorian.model.Account;
import fr.dorian.model.Role;

public interface RoleDAO extends IDAO<Role> {

	Role findByName(String name);

	List<Role> findByAccount(Account account);

}
