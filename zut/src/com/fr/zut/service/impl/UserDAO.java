package com.fr.zut.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fr.zut.model.User;
import com.fr.zut.service.def.IUserDAO;

@Repository
public class UserDAO extends AbstractDAO<User> implements IUserDAO {

	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return super.findAll(User.class);
	}

	@Override
	@Transactional(readOnly = true)
	public User findById(Integer id) {
		return super.findById(User.class, id);
	}

}
