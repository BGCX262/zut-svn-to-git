package fr.dorian.web;

import java.util.List;

import fr.dorian.model.Tutorial;

public interface TutorialListBean {

	List<Tutorial> getTutorials();

	String redirectToNew();

}
