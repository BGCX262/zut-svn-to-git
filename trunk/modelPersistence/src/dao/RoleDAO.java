package dao;

import model.Role;

public interface RoleDAO extends IDAO<Role> {

	Role findByName(String name);

}
