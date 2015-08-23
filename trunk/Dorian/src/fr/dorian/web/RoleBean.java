package fr.dorian.web;

import java.util.List;

import fr.dorian.model.Role;

public interface RoleBean {

	List<Role> getForAccount(Integer accountId);

	void addRole();

	List<Role> getAllRoles();

}
