package fr.dorian.web;

import java.util.List;

import org.primefaces.event.SelectEvent;

import fr.dorian.model.Tutorial;

public interface TutorialBean {

	String createNew();

	String createdFromThread(Integer threadId);

	Tutorial getTutorial();

	String view(Integer tutorialId);

	List<String> onCompleteTag(String query);

	void onSelectTag(SelectEvent event);

	String update();

	String goToUpdate(Integer tutorialId);

	Integer getTutorialId();

	void setTutorialId(Integer tutorialId);

	void setTutorial(Tutorial tutorial);

	boolean isActived();

	void setActived(boolean actived);

	boolean isDisplayOnly();

	void setDisplayOnly(boolean displayOnly);

	String onCancelNew();

	String countByAccount(Integer accountId);

	String addTags();

	String goToTutorialList();

	List<String> getTags();

	void setTags(List<String> tags);

	void setCanEdit(boolean canEdit);

	boolean isCanEdit();
}
