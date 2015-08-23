package com.fr.zut.business.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fr.zut.business.def.IUserBO;
import com.fr.zut.business.exception.BusinessException;
import com.fr.zut.model.User;
import com.fr.zut.model.enums.RoleTypeEnum;
import com.fr.zut.service.def.IUserDAO;

@Transactional(readOnly = false)
public class UserBO implements IUserBO {

	private IUserDAO userDAO;
	
	public IUserDAO getUserDAO() {
		return this.userDAO;
	}
	
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public void addUser(User user) throws BusinessException {
		if (user == null)
			throw BusinessException.INVALID_REQUEST;
		
		// Sets default role when user.role == null
		if (user.getRole() == null)
			user.setRole(RoleTypeEnum.COSTUM);
		
		this.userDAO.persist(user);
	}

	@Override
	public void updateUser(User user) {
		this.userDAO.update(user);
	}

	@Override
	public void deleteUser(User user) {
		this.userDAO.remove(user);
	}

	@Override
	public User getUserById(int id) {
		return this.userDAO.findById(id);
	}

	@Override
	public List<User> getUsers() {
		return this.userDAO.findAll();
	}
}
