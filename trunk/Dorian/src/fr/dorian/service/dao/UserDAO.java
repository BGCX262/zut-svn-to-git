package fr.dorian.service.dao;

import fr.dorian.model.User;

public interface UserDAO extends IDAO<User> {

	User findByEmail(String username);

}
