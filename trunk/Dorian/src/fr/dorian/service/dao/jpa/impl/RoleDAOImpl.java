package fr.dorian.service.dao.jpa.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dorian.model.Account;
import fr.dorian.model.Role;
import fr.dorian.service.dao.RoleDAO;
import fr.dorian.service.dao.util.EntityManagerUtil;

@Repository
@Scope("session")
public class RoleDAOImpl extends AbstractDAO<Role> implements RoleDAO, Serializable {

	private static final long serialVersionUID = 6584717724010129534L;

	private static final Log log = LogFactory.getLog(RoleDAO.class);
	
	@Override
	@Transactional(readOnly = true)
	public Role findById(Integer id) {
		log.info("find by id // " + id);
		return this.findById(Role.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Role> findAll() {
		log.info("find all");
		return this.findAll(Role.class);
	}

	@Override
	@Transactional(readOnly = true)
	public Role findByName(String name) {
		log.info("find by name // " + name);
		
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("name", name);
		return (Role) EntityManagerUtil.executeSingleNamedQueryInTransaction("Role.findByName", params);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Role> findByAccount(Account account) {
		log.info("find by account // " + account.getId());
		
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("accountId", account.getId());
		return (List<Role>) EntityManagerUtil.executeNamedQueryInTransaction("Role.findByAccount", params);
	}
}
