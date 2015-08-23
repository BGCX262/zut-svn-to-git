package fr.dorian.service.dao;

import java.util.List;

import fr.dorian.model.Account;
import fr.dorian.model.Tag;
import fr.dorian.model.Thread;
import fr.dorian.model.Tutorial;

public interface TagDAO extends IDAO<Tag> {

	List<Tag> findForAccount(Account account);

	Tag findByName(String name);

	List<Tag> findStartsWith(String query);

	Long countByAccount(Account account);

	List<Tag> contains(String query);

	List<Tag> findByTutorial(Tutorial tutorial);

	List<Tag> findByThread(Thread thread);

}
