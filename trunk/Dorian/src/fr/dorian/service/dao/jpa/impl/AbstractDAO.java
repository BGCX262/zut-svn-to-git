package fr.dorian.service.dao.jpa.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.EntityManager;

import fr.dorian.model.superclasses.BaseEntity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dorian.service.dao.IDAO;
import fr.dorian.service.dao.util.EntityManagerUtil;

@Repository
@Transactional
public abstract class AbstractDAO<T> implements IDAO<T> {

	/**
	 * Logger
	 */
	protected final Log log = LogFactory.getLog(this.getClass());

	public static final String FIND_BY_ID	= "%s.findById";
	
	public static final String FIND_ALL	= "%s.findAll";
	
	@Override
	@Transactional(readOnly = false)
	public T merge(T object) {
		EntityManager entityManager = EntityManagerUtil.createEntityManager();
		
		object = entityManager.merge(object);
		
		EntityManagerUtil.commitTransactionAndCloseEntity(entityManager);
		return object;
	}

//	@Override
//	public void evict(T persistent) {
//		this.sessionFactory.getCurrentSession().evict(persistent);
//	}

//	@Override
//	public Serializable save(T object) {
//		return this.sessionFactory.getCurrentSession().save(object);
//	}
//
	@Override
	public void persist(T object) {

		EntityManager entityManager = EntityManagerUtil.createEntityManagerAndOpenTransaction();
		
		if (object instanceof BaseEntity) {
			((BaseEntity) object).prePersist();
		}

		entityManager.persist(object);

		if (object instanceof BaseEntity) {
			((BaseEntity) object).postPersist();
		}
		EntityManagerUtil.commitTransactionAndCloseEntity(entityManager);
	}

	public void persist(T object, Session session) {

		if (object instanceof BaseEntity) {
			((BaseEntity) object).prePersist();
		}

		session.persist(object);

		if (object instanceof BaseEntity) {
			((BaseEntity) object).postPersist();
		}
	}

	@Override
	public void remove(T persistent) {
		log.info("remove ");
		
		EntityManager entityManager = EntityManagerUtil.createEntityManagerAndOpenTransaction();
		
		if (persistent instanceof BaseEntity) {
			((BaseEntity) persistent).preRemove();
		}
		
		persistent = entityManager.merge(persistent);      //re-include object in Persistence Context
		entityManager.flush();
		
		if (persistent instanceof BaseEntity) {
			((BaseEntity) persistent).postRemove();
		}
		
		EntityManagerUtil.commitTransactionAndCloseEntity(entityManager);
	}

	@Override
	public void delete(T persistent) {
		log.info("delete " + persistent);
		
		EntityManager entityManager = EntityManagerUtil.createEntityManagerAndOpenTransaction();
		
		entityManager.remove(persistent);
		
		EntityManagerUtil.commitTransactionAndCloseEntity(entityManager);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void deleteById(Integer id) {
		EntityManager entityManager = EntityManagerUtil.createEntityManagerAndOpenTransaction();
		try {
			T item = (T) entityManager.find(this.getClass(), id);
			entityManager.remove(item);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void deleteById(Class<?> klass, Integer id) {
		EntityManager entityManager = EntityManagerUtil.createEntityManagerAndOpenTransaction();
		try {
			T item = (T) entityManager.find(klass, id);
			entityManager.remove(item);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}
	
//
//	@Override
//	public void remove(Integer id) {
//		throw new UnsupportedOperationException();
//	}
//
	@Override
	public void update(T persistent) {
		log.info("udpate " + persistent);
		
		EntityManager entityManager = EntityManagerUtil.createEntityManagerAndOpenTransaction();
		
		if (persistent instanceof BaseEntity) {
			((BaseEntity) persistent).preUpdate();
		}
		
		persistent = entityManager.merge(persistent);      //re-include object in Persistence Context
		entityManager.flush();                     //flush required for Persistence Context updates
		
		if (persistent instanceof BaseEntity) {
			((BaseEntity) persistent).postUpdate();
		}
		
		EntityManagerUtil.commitTransactionAndCloseEntity(entityManager);
	}

	/**
	 * Checks an entity by Id
	 * @param cls - Entity class
	 * @param id - Id of object to find
	 * @return the find object or null if not exists.
	 */
	@SuppressWarnings("unchecked")
	protected T findById(Class<T> cls, Integer id) {

		Map<String, Object> params = new TreeMap<String, Object>();		
		params.put("id", id);
		
		return (T) EntityManagerUtil.executeSingleNamedQueryInTransaction(String.format(FIND_BY_ID, cls.getSimpleName()), params);
	}

	protected List<T> findAll(Class<T> cls, Session session) {
		return this.findAll(cls);
	}

	protected List<T> findAll(Class<T> cls, Comparator<T> comparator) {
		List<T> list = this.findAll(cls);
		Collections.sort(list, comparator);
		return list;
	}

	
	/**
	 * Checks all entities by class
	 * @param cls - Entity class
	 * @return an list of objects
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findAll(Class<T> cls) {
		return (List<T>) EntityManagerUtil.executeNamedQueryInTransaction(String.format(FIND_ALL, cls.getSimpleName()));
	}

	/**
	 * Log Exceptions from the DAO like HibernateException
	 * @param message - The message to log
	 * @param e - the exception to log
	 */
	protected void logException(final String message, Throwable e) {

		assert e != null : "Throwable is mandatory";

		log.error(message + " - failed with exception!");
		log.error("caused by -> " + e.getMessage());

		while (e.getCause() != null) {
			e = e.getCause();
			log.error("caused by -> " + e.getMessage());
		}
	}
}
