package com.fr.zut.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fr.zut.model.superclasses.BaseEntity;
import com.fr.zut.service.def.IDAO;

@Repository
public abstract class AbstractDAO<T> implements IDAO<T> {

	/**
	 * Logger
	 */
	protected final Log log = LogFactory.getLog(this.getClass());
	
	/**
	 * @see SessionFactory
	 */
	@Autowired
	protected SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public T merge(T object) {
		return (T) this.sessionFactory.getCurrentSession().merge(object);
	}

	@Override
	public void evict(T persistent) {
		this.sessionFactory.getCurrentSession().evict(persistent);
	}

	@Override
	public Serializable save(T object) {
		return this.sessionFactory.getCurrentSession().save(object);
	}

	@Override
	public void persist(T object) {
		
		if (object instanceof BaseEntity) {
			((BaseEntity) object).prePersist();
		}

		this.sessionFactory.getCurrentSession().persist(object);

		if (object instanceof BaseEntity) {
			((BaseEntity) object).postPersist();
		}
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

		if (persistent instanceof BaseEntity) {
			((BaseEntity) persistent).preRemove();
		}

		this.sessionFactory.getCurrentSession().delete(persistent);

		if (persistent instanceof BaseEntity) {
			((BaseEntity) persistent).postRemove();
		}
	}

	@Override
	public void remove(Integer id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(T persistent) {

		if (persistent instanceof BaseEntity) {
			((BaseEntity) persistent).preUpdate();
		}

		this.sessionFactory.getCurrentSession().update(persistent);
		this.sessionFactory.getCurrentSession().flush();

		if (persistent instanceof BaseEntity) {
			((BaseEntity) persistent).postUpdate();
		}
	}

	/**
	 * Checks an entity by Id
	 * @param cls - Entity class
	 * @param id - Id of object to find
	 * @return the find object or null if not exists.
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	protected T findById(Class<T> cls, Integer id) {

		T object = (T) this.sessionFactory.getCurrentSession().get(cls, id);
		return object;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	protected List<T> findAll(Class<T> cls, Session session) {

		List<T> objects = new Vector<T>();
		Query query = this.sessionFactory.getCurrentSession().createQuery("from " + cls.getSimpleName() + " u");
		objects = query.list();
		return objects;
	}

	/**
	 * Checks all entities by class
	 * @param cls - Entity class
	 * @return an list of objects
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	protected List<T> findAll(Class<T> cls) {

		List<T> objects = new Vector<T>();
		Query query = this.sessionFactory.getCurrentSession().createQuery("from " + cls.getSimpleName() + " u");
		objects = query.list();
		return objects;
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
