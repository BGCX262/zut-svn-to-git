package fr.dorian.web;

import java.util.List;

import fr.dorian.model.Comment;

public interface CommentBean {

	void create(Integer tutorialId);

	List<Comment> getAll();

	List<Comment> getByTutorial(Integer tutorialId);

	List<Comment> getByAccount(Integer accountId);

	String getText();

	void setText(String text);

}
