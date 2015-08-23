package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import model.User;
import dao.UserDAO;

public class UserDAOImpl extends AbstractDAO<User> implements UserDAO, Serializable {

	private static final long serialVersionUID = 8093186928190243594L;
	
	private static final Log log = LogFactory.getLog(UserDAO.class);
	
	@Override
	public List<User> findAll() {
		log.info("find all");
		return this.findAll(User.class);
	}

	@Override
	public User findById(Integer id) {
		log.info("find by id // " + id);
		return this.findById(User.class, id);
	}
}
