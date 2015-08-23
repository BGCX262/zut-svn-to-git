package fr.dorian.business;

import java.util.List;

import fr.dorian.model.Account;
import fr.dorian.model.Tag;
import fr.dorian.service.exception.ServiceException;

public interface TagBO {

	List<Tag> findAll(Account account) throws ServiceException;

	void persist(Tag tag) throws ServiceException;

	void update(Tag tag) throws ServiceException;

	void remove(Integer tagId) throws ServiceException;

	Tag findById(Integer tagId) throws ServiceException;

	Tag findByName(String label) throws ServiceException;

	List<Tag> findAll() throws ServiceException;

	List<Tag> findStartsWith(String query) throws ServiceException;

	void createTags(Integer accountId, String tagNames) throws ServiceException;

	List<Tag> findAllByAccountId(Integer accountId) throws ServiceException;

	Long countByAccountId(Integer accountId) throws ServiceException;

	List<Tag> findTagContains(String query) throws ServiceException;

	List<Tag> findByTutorialId(Integer tutorialId) throws ServiceException;

	List<Tag> findByThreadId(Integer threadId) throws ServiceException;
}
