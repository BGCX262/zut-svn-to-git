package fr.dorian.web;

import java.util.List;

import fr.dorian.model.Tag;

public interface TagBean {

	String create();

	String update();

	String remove(Integer tagId);

	String view(Integer tagId);

	boolean getEditRole();

	Tag getTag();

	void setTag(Tag tag);

	String countByAccount(Integer accountId);

	List<Tag> byTutorial(Integer tutorialId);

	List<Tag> byThread(Integer threadId);
}
