package fr.dorian.service.dao.jpa.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dorian.model.Activity;
import fr.dorian.service.dao.ActivityDAO;
import fr.dorian.service.dao.util.EntityManagerUtil;

@Repository
public class ActivityDAOImpl extends AbstractDAO<Activity> implements ActivityDAO, Serializable {

	private static final long serialVersionUID = 979385482116620190L;

	private static final Log log = LogFactory.getLog(ActivityDAO.class);
	
	@Override
	@Transactional(readOnly = true)
	public List<Activity> findAll() {
		log.info("find all");
		return this.findAll(Activity.class);
	}

	@Override
	@Transactional(readOnly = true)
	public Activity findById(Integer id) {
		log.info("find by id // " + id);
		return this.findById(Activity.class, id);
	}

	@Override
	public List<Activity> findByAccount(Integer accountId) {
		log.info("find by account with id // " + accountId);
		
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("accountId", accountId);
		@SuppressWarnings("unchecked")
		List<Activity> activities = (List<Activity>) EntityManagerUtil.executeNamedQueryInTransaction("Activity.findByAccount", params);
		return activities;
	}
}
