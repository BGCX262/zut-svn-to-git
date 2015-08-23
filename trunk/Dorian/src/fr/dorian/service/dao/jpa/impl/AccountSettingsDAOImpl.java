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
import fr.dorian.model.AccountSettings;
import fr.dorian.service.dao.AccountSettingsDAO;
import fr.dorian.service.dao.util.EntityManagerUtil;

@Repository
public class AccountSettingsDAOImpl extends AbstractDAO<AccountSettings> implements AccountSettingsDAO, Serializable {
	
	private static final long serialVersionUID = 4455486703063622378L;

	public static Log log = LogFactory.getLog(AccountSettingsDAO.class);
	
	@Override
	@Transactional(readOnly = true)
	public AccountSettings findByAccount(Account account) {
		log.info("find by account with id // " + account.getId());
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("accountId", account.getId());	
		AccountSettings accountInfos = (AccountSettings)EntityManagerUtil
				.executeSingleNamedQueryInTransaction("AccountSettings.findByAccountId", params);
		return (accountInfos);
	}

	@Override
	@Transactional(readOnly = true)
	public AccountSettings findById(Integer id) {
		log.info("find by id // " + id);
		return this.findById(AccountSettings.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AccountSettings> findAll() {
		log.info("find all");
		return this.findAll(AccountSettings.class);
	}
}
