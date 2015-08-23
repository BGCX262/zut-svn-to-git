package fr.dorian.business;

import java.util.List;

import fr.dorian.model.Account;
import fr.dorian.model.Post;
import fr.dorian.model.Tag;
import fr.dorian.model.Thread;
import fr.dorian.service.exception.ServiceException;

public interface ThreadBO {
	
	/**
	 * Loads a object by Id
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	Thread findById(Integer id) throws ServiceException;
	void deleteById(Integer id) throws ServiceException;
	
	List<Thread> findAll() throws ServiceException;
	void attachPostToThread(Post post, Integer threadId) throws ServiceException;
	List<Post> findAllPostsFromThread(Integer thread_id) throws ServiceException;
	
	Thread create(String title, String content, Account account) throws ServiceException;
	public void closeThread(Account account, Thread thread) throws ServiceException;
	List<Thread> findByAccount(Integer accountId) throws ServiceException;
	
	List<Tag> findTagStartsWith(String query) throws ServiceException;
	void addTags(Account account, Thread thread, List<String> tagnames)	throws ServiceException;
	Long countByAccountId(Integer accountId) throws ServiceException;
	Thread validateThread(Integer postId) throws ServiceException;
	Thread unvalidateThread(Integer postId) throws ServiceException;
	void createTutorialByThreadId(Integer threadId) throws ServiceException;
	void destroyTutorialByThreadId(Integer threadId) throws ServiceException;
}
