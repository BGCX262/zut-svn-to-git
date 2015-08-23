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

import fr.dorian.model.AccountActivation;
import fr.dorian.model.User;
import fr.dorian.service.dao.AccountActivationDAO;
import fr.dorian.service.dao.util.EntityManagerUtil;

@Repository
@Scope("session")
public class AccountActivationDAOImpl extends AbstractDAO<AccountActivation> implements AccountActivationDAO, Serializable {

	private static final long serialVersionUID = -8044449376413690617L;

	private static final Log log = LogFactory.getLog(AccountActivationDAO.class);

	@Override
	@Transactional(readOnly = true)
	public AccountActivation findById(Integer id) {
		log.info("find by id // " + id);
		
		return this.findById(AccountActivation.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AccountActivation> findAll() {
		log.info("find all");
		return this.findAll(AccountActivation.class);
	}

	@Override
	public AccountActivation findByCode(String code) {
		log.info("find by code // " + code);
		
		Map<String, Object> params = new TreeMap<String, Object>();
		params.put("code", code);
		
		return (AccountActivation) EntityManagerUtil.executeSingleNamedQueryInTransaction("AccountActivation.findByCode", params);
	}

	@Override
	public AccountActivation findByUser(User user) {
		log.info("find by email // " + user);
		
		Map<String, Object> params = new TreeMap<String, Object>();
		params.put("userId", user.getId());
		
		return (AccountActivation) EntityManagerUtil.executeSingleNamedQueryInTransaction("AccountActivation.findByUser", params);
	}
}
