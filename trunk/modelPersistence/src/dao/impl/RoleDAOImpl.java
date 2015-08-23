package dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dao.RoleDAO;
import dao.util.EntityManagerUtil;

import model.Role;

public class RoleDAOImpl extends AbstractDAO<Role> implements RoleDAO, Serializable {

	private static final long serialVersionUID = 6584717724010129534L;

	private static final Log log = LogFactory.getLog(RoleDAO.class);
	
	@Override
	public Role findById(Integer id) {
		log.info("find by id // " + id);
		return this.findById(Role.class, id);
	}

	@Override
	public List<Role> findAll() {
		log.info("find all");
		return this.findAll(Role.class);
	}

	@Override
	public Role findByName(String name) {
		log.info("find by name // " + name);
		
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("name", name);
		return (Role) EntityManagerUtil.executeSingleNamedQueryInTransaction("Role.findByName", params);
	}
}
