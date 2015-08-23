package fr.dorian.web;

import java.util.List;

import fr.dorian.model.Activity;

public interface ActivityBean {

	List<Activity> getActivitiesByAccount(Integer accountId);

	List<Activity> getActivities();

	String goToListView();

}
