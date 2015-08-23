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

import fr.dorian.model.Account;
import fr.dorian.model.Tag;
import fr.dorian.model.Thread;
import fr.dorian.model.Tutorial;
import fr.dorian.service.dao.TagDAO;
import fr.dorian.service.dao.util.EntityManagerUtil;

@Repository
@Scope("session")
public class TagDAOImpl extends AbstractDAO<Tag> implements TagDAO, Serializable {

	private static final long serialVersionUID = 4922584297894762589L;
	
	private static final Log log = LogFactory.getLog(TagDAO.class);
	
	@Override
	@Transactional(readOnly = true)
	public List<Tag> findAll() {
		log.info("find all");
		return this.findAll(Tag.class);
	}

	@Override
	@Transactional(readOnly = true)
	public Tag findById(Integer id) {
		log.info("find by id // " + id);
		return this.findById(Tag.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Tag> findForAccount(Account account) {
		log.info("find for account // " + account.getId());
		
		Map<String, Object> params = new TreeMap<String, Object>();
		params.put("id", account.getId());
		
		return (List<Tag>) EntityManagerUtil.executeNamedQueryInTransaction("Tag.findForAccount", params);
	}

	@Override
	@Transactional(readOnly = true)
	public Tag findByName(String name) {
		log.info("find tag by name // " + name);
		
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("name", name);
		return (Tag) EntityManagerUtil.executeSingleNamedQueryInTransaction("Tag.findByName", params);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Tag> findStartsWith(String query) {
		log.info("find starts with // " + query);
		
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("name", query);
		return  (List<Tag>)EntityManagerUtil.executeNamedQueryInTransaction("Tag.findStartsWith", params);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countByAccount(Account account) {
		log.info("count for account // " + account.getId());
		
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("accountId", account.getId());
		Object count = EntityManagerUtil.executeSingleNamedQueryInTransaction("Tag.countByAccount", params);
		System.out.println(count);
		if (count == null)
			return (long) 0;
		return (Long) count; 
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Tag> contains(String query) {
		log.info("contains // " + query);
		Map<String, Object> params = new TreeMap<String, Object>();

		params.put("param", '%' + query.toLowerCase() + '%');
			
		List<Tag> tags = (List<Tag>) EntityManagerUtil.executeNamedQueryInTransaction("Tag.contains", params);
		System.out.println(tags.size());
		return tags;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Tag> findByTutorial(Tutorial tutorial) {
		log.info("find for thread // " + tutorial.getId());
		
		Map<String, Object> params = new TreeMap<String, Object>();
		params.put("tutorialId", tutorial.getId());
		
		return (List<Tag>) EntityManagerUtil.executeNamedQueryInTransaction("Tag.findByTutorial", params);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Tag> findByThread(Thread thread) {
		log.info("find for thread // " + thread.getId());
		
		Map<String, Object> params = new TreeMap<String, Object>();
		params.put("threadId", thread.getId());
		
		return (List<Tag>) EntityManagerUtil.executeNamedQueryInTransaction("Tag.findByThread", params);
	}
	
}
