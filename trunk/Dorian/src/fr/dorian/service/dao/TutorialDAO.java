package fr.dorian.service.dao;

import java.util.List;

import fr.dorian.model.Account;
import fr.dorian.model.Tutorial;

public interface TutorialDAO extends IDAO<Tutorial> {

	List<Tutorial> findByAccount(Account account);

	Long countByAccount(Account account);

	Tutorial findByThreadId(Integer threadId);
}
