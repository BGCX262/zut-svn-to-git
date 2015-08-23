package fr.dorian.service.dao.jpa.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dorian.model.Account;
import fr.dorian.model.User;
import fr.dorian.service.dao.AccountDAO;
import fr.dorian.service.dao.util.EntityManagerUtil;

@Repository
public class AccountDAOImpl extends AbstractDAO<Account> implements AccountDAO, Serializable {

	private static final long serialVersionUID = -1526467105153042475L;
	
	private static final Log log = LogFactory.getLog(AccountDAO.class);

	@Override
	@Transactional(readOnly = true)
	public Account findById(Integer id) {
		log.info("find by id // " + id);
		
		return this.findById(Account.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Account> findAll() {
		log.info("find all");
		return this.findAll(Account.class);
	}

	@Override
	public Account findByEmail(String email) {
		log.info("find by email // " + email);
		
		Map<String, Object> params = new TreeMap<String, Object>();
		params.put("email", email);
		
		return (Account) EntityManagerUtil.executeSingleNamedQueryInTransaction("Account.findByEmail", params);
	}

	@Override
	public Account findByUser(User user) {
		log.info("find by email // " + user);
		
		Map<String, Object> params = new TreeMap<String, Object>();
		params.put("userId", user.getId());
		
		return (Account) EntityManagerUtil.executeSingleNamedQueryInTransaction("Account.findByUser", params);
	}
}
