package fr.dorian.service.dao.jpa.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dorian.model.User;
import fr.dorian.service.dao.UserDAO;
import fr.dorian.service.dao.util.EntityManagerUtil;

@Repository
public class UserDAOImpl extends AbstractDAO<User> implements UserDAO, Serializable {

	private static final long serialVersionUID = 8093186928190243594L;
	
	private static final Log log = LogFactory.getLog(UserDAO.class);
	
	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		log.info("find all");
		return this.findAll(User.class);
	}

	@Override
	@Transactional(readOnly = true)
	public User findById(Integer id) {
		log.info("find by id // " + id);
		return this.findById(User.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public User findByEmail(String email) {
		log.info("find by email // " + email);
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("param", email);
		return (User) EntityManagerUtil.executeSingleNamedQueryInTransaction("User.findByEmail", params);
	}
}
