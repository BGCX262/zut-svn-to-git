package fr.dorian.service.dao.util;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.dorian.model.superclasses.BaseEntity;

public class EntityManagerUtil {
	
	private static Log log = LogFactory.getLog(EntityManagerUtil.class);
	
	private final static String PERSISTENCE_UNIT_NAME = "DORIAN";
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

	public static EntityManager createEntityManager() {
		return emf.createEntityManager();
	}

	public static EntityManager createEntityManagerAndOpenTransaction()	{
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		return em;
	}

	public static void commitTransactionAndCloseEntity(EntityManager em) {
		em.getTransaction().commit();
		em.close();			
	}

	public static List<?> executeNamedQueryInTransaction(String queryName) {
		EntityManager em = createEntityManagerAndOpenTransaction();
		Query query = em.createNamedQuery(queryName);
		List<?> l = query.getResultList();
		commitTransactionAndCloseEntity(em);

		return l;
	}

	@SuppressWarnings("rawtypes")
	public static List executeNamedQueryInTransaction(String queryName, Map<String, Object> params) {
		EntityManager em = createEntityManagerAndOpenTransaction();
		Query query = em.createNamedQuery(queryName);

		for (String key : params.keySet())
			query.setParameter(key, params.get(key));

		List l = query.getResultList();
		commitTransactionAndCloseEntity(em);

		return l;
	}

	@SuppressWarnings("rawtypes")
	public static List executeQueryInTransaction(String queryName, Map<String, Object> params) {
		EntityManager em = createEntityManagerAndOpenTransaction();
		Query query = em.createQuery(queryName);

		for (String key : params.keySet())
			query.setParameter(key, params.get(key)); 

		List l = query.getResultList();
		commitTransactionAndCloseEntity(em);

		return l;
	}

	public static Object executeSingleNamedQueryInTransaction(String queryName, Map<String, Object> params) {
		EntityManager em = createEntityManagerAndOpenTransaction();
		Query query = em.createNamedQuery(queryName);

		for (String key : params.keySet())
			query.setParameter(key, params.get(key)); 

		Object result = null;
		try {
			result = query.getSingleResult();
		} catch (NoResultException nre) {
			log.info("NoResultException  // no entity found");
		}
		commitTransactionAndCloseEntity(em);

		return result;
	}

	public static Object executeSingleQueryInTransaction(String queryName, Map<String, Object> params) {
		EntityManager em = createEntityManagerAndOpenTransaction();
		Query query = em.createQuery(queryName);

		for (String key : params.keySet())
			query.setParameter(key, params.get(key)); 

		Object o = query.getSingleResult();
		commitTransactionAndCloseEntity(em);

		return o;
	}

	@Deprecated
	public static void persist(Object object) {
		EntityManager   em              = createEntityManagerAndOpenTransaction();

		if (!em.contains(object)) {
			System.out.println("EntityManagerUtil: persist: EntityManager does NOT contain object " + object.toString());
			object = em.merge(object);      //re-include object in Persistence Context
			em.flush();                     //flush required for Persistence Context updates
			System.out.println("EntityManagerUtil: persist: object merged, em.contains(o)=" + em.contains(object));
		}

		if (object instanceof BaseEntity)
			((BaseEntity) object).prePersist();

		em.persist(object);

		if (object instanceof BaseEntity)
			((BaseEntity) object).postPersist();

		commitTransactionAndCloseEntity(em);
	}

}