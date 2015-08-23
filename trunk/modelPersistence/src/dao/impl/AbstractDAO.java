package dao.impl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.EntityManager;

import model.superclasses.BaseEntity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

import dao.IDAO;
import dao.util.EntityManagerUtil;

public abstract class AbstractDAO<T> implements IDAO<T> {

	/**
	 * Logger
	 */
	protected final Log log = LogFactory.getLog(this.getClass());

	public static final String FIND_BY_ID	= "findById";
	
	public static final String FIND_ALL		= "findAll";
	
//	@SuppressWarnings("unchecked")
	@Override
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
//
//	@Override
//	public void remove(T persistent) {
//
//		if (persistent instanceof BaseEntity) {
//			((BaseEntity) persistent).preRemove();
//		}
//
//		this.sessionFactory.getCurrentSession().delete(persistent);
//
//		if (persistent instanceof BaseEntity) {
//			((BaseEntity) persistent).postRemove();
//		}
//	}
//
//	@Override
//	public void remove(Integer id) {
//		throw new UnsupportedOperationException();
//	}
//
	@Override
	public void update(T persistent) {

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

		String queryName = cls.getSimpleName() + ".findById"; // Model.findById
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("id", id);
		
		return (T) EntityManagerUtil.executeSingleNamedQueryInTransaction(queryName, params);
	}

	protected List<T> findAll(Class<T> cls, Session session) {
		return this.findAll(cls);
	}

	/**
	 * Checks all entities by class
	 * @param cls - Entity class
	 * @return an list of objects
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findAll(Class<T> cls) {
		return (List<T>) EntityManagerUtil.executeNamedQueryInTransaction(cls.getSimpleName() + ".findAll");
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
