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
import fr.dorian.model.AccountInfos;
import fr.dorian.service.dao.AccountInfosDAO;
import fr.dorian.service.dao.util.EntityManagerUtil;

@Repository("accountInfosDAO")
public class AccountInfosDAOImpl extends AbstractDAO<AccountInfos> implements AccountInfosDAO, Serializable {
	//DAO utils
	private static final long serialVersionUID = -4496056492274095417L;
	
	public static Log log = LogFactory.getLog(AccountInfosDAO.class);
	
	//Transactional methods
	
	@Override
	@Transactional(readOnly = true)
	public AccountInfos findByAccount(Account account) {
		log.info("find by account with id // " + account.getId());
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("accountId", account.getId());	
		AccountInfos accountInfos = (AccountInfos)EntityManagerUtil
				.executeSingleNamedQueryInTransaction("AccountInfos.findByAccountId", params);
		return (accountInfos);
	}

	@Override
	@Transactional(readOnly = true)
	public AccountInfos findById(Integer id) {
		log.info("find by id // " + id);
		return this.findById(AccountInfos.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AccountInfos> findAll() {
		log.info("find all");
		return this.findAll(AccountInfos.class);
	}
}
