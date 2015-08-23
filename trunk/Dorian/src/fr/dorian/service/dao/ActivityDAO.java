package fr.dorian.service.dao;

import java.util.List;

import fr.dorian.model.Activity;

public interface ActivityDAO extends IDAO<Activity> {

	List<Activity> findByAccount(Integer accountId);

}
