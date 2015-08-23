package com.fr.zut.service.def;

import java.io.Serializable;
import java.util.List;

public interface IDAO<T> {

	/**
	 * 
	 * @param _transient - object to persist
	 */
	public void persist(T _transient);

	public Serializable save(T _transient);

	/**
	 * Removes an entity 
	 * @param persistent - Entity to remove
	 */
	public void remove(T persistent);

	/**
	 * Removes an entity by id
	 * @param id - Id of entity to remove
	 */
	public void remove(Integer id);
	
	public void evict(T persistent);

	public T merge(T detached);

	public T findById(Integer id);

	/**
	 * Gets all entities
	 * @return entities
	 */
	public List<T> findAll();

	/**
	 * Update current entity
	 * @param persistent - Entity to update
	 */
	public void update(T persistent);
}
