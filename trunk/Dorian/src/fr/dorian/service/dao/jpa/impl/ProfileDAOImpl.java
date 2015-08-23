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
import fr.dorian.model.Profile;
import fr.dorian.service.dao.ProfileDAO;
import fr.dorian.service.dao.util.EntityManagerUtil;

@Repository
public class ProfileDAOImpl extends AbstractDAO<Profile> implements ProfileDAO, Serializable {

	private static final long serialVersionUID = 2631285146397999300L;

	private static final Log log = LogFactory.getLog(ProfileDAO.class);
	
	@Override
	@Transactional(readOnly = true)
	public List<Profile> findAll() {
		log.info("find all");
		return this.findAll(Profile.class);
	}

	@Override
	@Transactional(readOnly = true)
	public Profile findById(Integer id) {
		log.info("find by id // " + id);
		return this.findById(Profile.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Profile> findByAccount(Account account) {
		log.info("find by account id // " + account);
		
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("accountId", account.getId());
		return (List<Profile>)EntityManagerUtil.executeNamedQueryInTransaction("Profile.findByAccount", params);
	}
}
