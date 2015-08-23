package fr.dorian.service.dao;

import java.util.List;

import fr.dorian.model.Account;
import fr.dorian.model.Post;
import fr.dorian.model.Thread;

public interface ThreadDAO extends IDAO<Thread> {

	void delete(Integer id);

	List<Post> findPostsByThreadId(Integer thread_id);

	List<Thread> findByAccountId(Integer accountId);

	Long countByAccount(Account account);
	
	//List<Thread> findAllWithReferer(String referer);
}
