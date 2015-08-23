package fr.dorian.service.dao;

import java.util.List;

import fr.dorian.model.Account;
import fr.dorian.model.Post;
import fr.dorian.model.Thread;

public interface PostDAO extends IDAO<Post> {

	List<Post> findByThread(Thread thread);

	void delete(Integer id);

	Long countByAccount(Account account);

	List<Post> findByAccount(Account account);
	
}
