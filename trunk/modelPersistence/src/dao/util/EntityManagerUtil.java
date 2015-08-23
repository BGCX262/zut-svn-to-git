package dao.util;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.superclasses.BaseEntity;

public class EntityManagerUtil 
{
	private final static String PERSISTENCE_UNIT_NAME	= "app";
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);


	public static EntityManager createEntityManager()   
	{
		return emf.createEntityManager();
	}

	public static EntityManager createEntityManagerAndOpenTransaction() 
	{
		EntityManager   em = emf.createEntityManager();

		em.getTransaction().begin();
		return em;
	}

	public static void commitTransactionAndCloseEntity(EntityManager em)
	{
		em.getTransaction().commit();
		//em.close();
	}

	public static List<?> executeNamedQueryInTransaction(String queryName)      
	{
		EntityManager   em              = createEntityManagerAndOpenTransaction();
		Query   queryProducts   = em.createNamedQuery(queryName);
		List<?> l                               = queryProducts.getResultList();
		commitTransactionAndCloseEntity(em);

		return l;
	}

	@SuppressWarnings("rawtypes")
	public static List executeNamedQueryInTransaction(String queryName, Map<String, Object> params) 
	{
		EntityManager   em              = createEntityManagerAndOpenTransaction();
		Query   queryProducts   = em.createNamedQuery(queryName);

		for (String key : params.keySet())
			queryProducts.setParameter(key, params.get(key)); 

		List l                                  = queryProducts.getResultList();
		commitTransactionAndCloseEntity(em);

		return l;
	}

	@SuppressWarnings("rawtypes")
	public static List executeQueryInTransaction(String queryName, Map<String, Object> params)      
	{
		EntityManager   em              = createEntityManagerAndOpenTransaction();
		Query   queryProducts   = em.createQuery(queryName);

		for (String key : params.keySet())
			queryProducts.setParameter(key, params.get(key)); 

		List l                                  = queryProducts.getResultList();
		commitTransactionAndCloseEntity(em);

		return l;
	}

	public static Object executeSingleNamedQueryInTransaction(String queryName, Map<String, Object> params)     
	{
		EntityManager   em              = createEntityManagerAndOpenTransaction();
		Query   queryProducts   = em.createNamedQuery(queryName);

		for (String key : params.keySet())
			queryProducts.setParameter(key, params.get(key)); 

		Object o                                        = queryProducts.getSingleResult();
		commitTransactionAndCloseEntity(em);

		return o;
	}

	public static Object executeSingleQueryInTransaction(String queryName, Map<String, Object> params)  
	{
		EntityManager   em              = createEntityManagerAndOpenTransaction();
		Query   queryProducts   = em.createQuery(queryName);

		for (String key : params.keySet())
			queryProducts.setParameter(key, params.get(key)); 

		Object o                                        = queryProducts.getSingleResult();
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