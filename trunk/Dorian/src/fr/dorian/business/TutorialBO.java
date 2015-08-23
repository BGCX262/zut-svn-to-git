package fr.dorian.business;

import java.util.List;

import fr.dorian.model.Tag;
import fr.dorian.model.Tutorial;
import fr.dorian.service.exception.ServiceException;

public interface TutorialBO {

	List<Tutorial> findAll() throws ServiceException;

	void createFromThreadId(Integer threadId) throws ServiceException;

	List<Tutorial> findByAccountId(Integer accountId) throws ServiceException;

	void createOrSave(Tutorial tutorial, List<String> selectedTagsText) throws ServiceException;

	Tutorial findById(Integer tutorialId) throws ServiceException;

	List<Tag> findTagStartsWith(String query) throws ServiceException;

	Long countByAccount(Integer accountId) throws ServiceException;

	void addTags(Tutorial tutorial, List<String> tags) throws ServiceException;

	void destroyFromThreadId(Integer threadId) throws ServiceException;

}
