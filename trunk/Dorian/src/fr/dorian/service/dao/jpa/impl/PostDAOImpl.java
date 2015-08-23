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
import fr.dorian.service.dao.PostDAO;
import fr.dorian.service.dao.util.EntityManagerUtil;

@Repository
public class PostDAOImpl extends AbstractDAO<Post> implements PostDAO, Serializable {

	private static final long serialVersionUID = -1065996733767950602L;

	private static final Log log = LogFactory.getLog(PostDAO.class);
	
	@Override
	@Transactional(readOnly = true)
	public List<Post> findAll() {
		log.info("find all");
		return this.findAll(Post.class);
	}

	@Override
	@Transactional(readOnly = true)
	public Post findById(Integer id) {
		log.info("find by id // " + id);
		return this.findById(Post.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Post> findByThread(Thread thread) {
		log.info("find by thread // " + thread.getId());
		
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("threadId", thread.getId());
		
		return (List<Post>) EntityManagerUtil.executeNamedQueryInTransaction("Post.findByThread", params);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Post> findByAccount(Account account) {
		log.info("find by account // " + account.getId());
		
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("accountId", account.getId());
		
		return (List<Post>) EntityManagerUtil.executeNamedQueryInTransaction("Post.findByAccount", params);
	}

	@Override
	public void delete(Integer id) {
		log.info("delete Post with id // " + id);
		this.deleteById(Post.class, id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByAccount(Account account) {
		log.info("count for account // " + account.getId());
		
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("accountId", account.getId());
		Object count = EntityManagerUtil.executeSingleNamedQueryInTransaction("Post.countByAccount", params);
		if (count == null)
			return (long) 0;
		return (Long) count; 
	}
}
