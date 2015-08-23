package fr.dorian.service.dao;

import java.util.List;

import fr.dorian.model.Account;
import fr.dorian.model.Comment;
import fr.dorian.model.Tutorial;

public interface CommentDAO extends IDAO<Comment> {

	List<Comment> findByAccount(Account account);

	List<Comment> findByTutorial(Tutorial tutorial);

	
}
