package fr.dorian.business;

import java.util.List;

import fr.dorian.model.Comment;
import fr.dorian.service.exception.ServiceException;

public interface CommentBO {

	List<Comment> findAll() throws ServiceException;

	List<Comment> findByTutorialId(Integer tutorialId) throws ServiceException;

	List<Comment> findByAccountId(Integer accountId) throws ServiceException;

	void create(Comment comment) throws ServiceException;

}
