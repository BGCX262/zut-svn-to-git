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
import fr.dorian.model.PasswordRecovery;
import fr.dorian.service.dao.PasswordRecoveryDAO;
import fr.dorian.service.dao.util.EntityManagerUtil;

@Repository
public class PasswordRecoveryDAOImpl extends AbstractDAO<PasswordRecovery> implements PasswordRecoveryDAO, Serializable {
	
	private static final long serialVersionUID = 4834571263027188843L;
	
	private static Log log = LogFactory.getLog(PasswordRecoveryDAO.class);
	
	// TRANSACTIONAL
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	@Transactional(readOnly = true)
	public PasswordRecovery findById(Integer id) {
		log.info("find by id // " + id);
		return this.findById(PasswordRecovery.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PasswordRecovery> findAll() {
		log.info("find all");
		return this.findAll(PasswordRecovery.class);
	}


	@Override
	@Transactional(readOnly = true)
	public List<PasswordRecovery> findByAccount(Account account) {
		log.info("find all by account with id // " + account.getId());
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("accountId", account.getId());
		@SuppressWarnings("unchecked")
		List<PasswordRecovery> recoveries = (List<PasswordRecovery>) EntityManagerUtil
		.executeNamedQueryInTransaction("PasswordRecovery.findByAccountId", params);
		return recoveries;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<PasswordRecovery> findByAccountIdAndActive(Account account, boolean active) {
		log.info("find all active by account with id // " + account.getId());
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("accountId", account.getId());
		params.put("active", active);
		@SuppressWarnings("unchecked")
		List<PasswordRecovery> recoveries = (List<PasswordRecovery>) EntityManagerUtil
			.executeNamedQueryInTransaction("PasswordRecovery.findByAccountIdAndActive", params);
		return recoveries;
	}
	
	@Override
	@Transactional(readOnly = true)
	public PasswordRecovery findByAccountAndToken(Account account, String token) {
		log.info(String.format("find by account [%s] and token [%s]", account.getId(), token));
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("accountId", account.getId());
		params.put("token", token);
		PasswordRecovery accountInfos = (PasswordRecovery)EntityManagerUtil
				.executeSingleNamedQueryInTransaction("PasswordRecovery.findByAccountIdAndToken", params);
		return accountInfos;
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public PasswordRecovery findByToken(String token) {
		log.info("find all by token // " + token);
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("token", token);
		
		PasswordRecovery recoveries = (PasswordRecovery) EntityManagerUtil
			.executeSingleNamedQueryInTransaction("PasswordRecovery.findByToken", params);
		return recoveries;
	}
	
	
}
