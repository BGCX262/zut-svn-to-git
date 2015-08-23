package fr.dorian.service.dao;

import java.util.List;

public interface IDAO<T> {

	/**
	 * Save a new entity in database
	 * @param _transient - object to persist
	 */
	public void persist(T _transient);

	//public Serializable save(T _transient);

	/**
	 * Removes an entity by setting deleted flag to true. 
	 * <br><strong>Entity will be present in database</strong>
	 * @param persistent - Entity to remove
	 */
	public void remove(T persistent);

	/**
	 * Removes an entity by id by setting deleted flag to true.
	 * <br><strong>Entity will be present in database</strong>
	 * @param id - Id of entity to remove
	 */
	//public void remove(Integer id);
	
	//public void evict(T persistent);

	public T merge(T detached);

	public T findById(Integer id);

	/**
	 * Gets all entities
	 * @return entities
	 */
	public List<T> findAll();

	/**
	 * Updates current entity
	 * @param persistent - Entity to update
	 */
	public void update(T persistent);

	/**
	 * Deletes <strong>definitively</strong> an entity
	 * @param persistent - Entity to delete
	 */
	void delete(T persistent);

	void deleteById(Integer id);

	void deleteById(Class<?> persistent, Integer id);
}
