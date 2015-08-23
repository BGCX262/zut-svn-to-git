package com.fr.zut.business.def;

import java.util.List;

import com.fr.zut.business.exception.BusinessException;
import com.fr.zut.model.User;

/**
 * All Business will throw a {@link BusinessException} 
 */
public interface IUserBO {
	
	void addUser(User user) throws BusinessException ;
	
	void updateUser(User user);
	
	void deleteUser(User user);

	User getUserById(int id);
	
	List<User> getUsers();
}
