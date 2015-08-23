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
import fr.dorian.model.Post;
import fr.dorian.model.Thread;
import fr.dorian.service.dao.ThreadDAO;
import fr.dorian.service.dao.util.EntityManagerUtil;

@Repository
public class ThreadDAOImpl extends AbstractDAO<Thread> implements ThreadDAO, Serializable {

	private static final long serialVersionUID = -4689632426298773037L;

	private static final Log log = LogFactory.getLog(ThreadDAO.class);
	
	@Override
	@Transactional(readOnly = true)
	public List<Thread> findAll() {
		log.info("find all");
		return this.findAll(Thread.class);
	}

	@Override
	@Transactional(readOnly = true)
	public Thread findById(Integer id) {
		log.info("find Thread by id // " + id);
		return this.findById(Thread.class, id);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Integer id) {
		log.info("delete thread with id // " + id);
		this.deleteById(Thread.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Post> findPostsByThreadId(Integer threadId) {
		log.info("find posts by thread id // " + threadId);
		
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("id", threadId);
		@SuppressWarnings("unchecked")
		List<Post> posts = EntityManagerUtil.executeNamedQueryInTransaction("Thread.findPostsByThreadId", params);
		return posts;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Thread> findByAccountId(Integer accountId) {
		log.info("find thread by account with id // " + accountId);
		
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("accountId", accountId);
		@SuppressWarnings("unchecked")
		List<Thread> threads = EntityManagerUtil.executeNamedQueryInTransaction("Thread.findByAccountId", params);
		return threads;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByAccount(Account account) {
		log.info("count for account");
		
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("accountId", account.getId());
		Object count = EntityManagerUtil.executeSingleNamedQueryInTransaction("Thread.countByAccount", params);
		if (count == null)
			return (long) 0;
		return (Long) count; 
	}
	
}
