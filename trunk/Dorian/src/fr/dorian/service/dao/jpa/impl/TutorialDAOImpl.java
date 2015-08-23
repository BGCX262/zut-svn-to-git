package fr.dorian.service.dao.jpa.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dorian.model.Account;
import fr.dorian.model.Tutorial;
import fr.dorian.service.dao.PostDAO;
import fr.dorian.service.dao.ThreadDAO;
import fr.dorian.service.dao.TutorialDAO;
import fr.dorian.service.dao.util.EntityManagerUtil;

@Repository
@Scope("session")
public class TutorialDAOImpl extends AbstractDAO<Tutorial> implements TutorialDAO, Serializable {

	private static final long serialVersionUID = 5733746359714964965L;

	private static final Log log = LogFactory.getLog(TutorialDAO.class);

	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private ThreadDAO threadDAO; 
	
	@Override
	@Transactional(readOnly = true)
	public Tutorial findById(Integer id) {
		log.info("find by id // " + id);
		return this.findById(Tutorial.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tutorial> findAll() {
		log.info("find all");
		return this.findAll(Tutorial.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tutorial> findByAccount(Account account) {
		log.info("find tutorial by account with id // " + account.getId());

		Map<String, Object> params = new TreeMap<String, Object>();

		params.put("accountId", account.getId());
		@SuppressWarnings("unchecked")
		List<Tutorial> tutorials = EntityManagerUtil.executeNamedQueryInTransaction("Tutotial.findByAccountId", params);
		return tutorials;
	}

	@Override
	public Long countByAccount(Account account) {
		log.debug("count by account");
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("accountId", account.getId());
		Object count = EntityManagerUtil.executeSingleNamedQueryInTransaction("Tutorial.countByAccount", params);
		if (count == null)
			return (long) 0;
		return (Long) count;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Tutorial findByThreadId(Integer threadId) {
		
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("threadId", threadId);
		Tutorial tutorial = (Tutorial)EntityManagerUtil.executeSingleNamedQueryInTransaction("Tutorial.findByThreadId", params);
		return (tutorial);
	}
}

