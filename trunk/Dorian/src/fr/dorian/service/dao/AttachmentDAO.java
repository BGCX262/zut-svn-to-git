package fr.dorian.service.dao;

import java.util.List;

import fr.dorian.model.Account;
import fr.dorian.model.Attachment;
import fr.dorian.model.Post;
import fr.dorian.model.Tutorial;

public interface AttachmentDAO extends IDAO<Attachment> {

	List<Attachment> findByAccount(Account account);

	List<Attachment> findByPost(Post postId);

	List<Attachment> findByTutorial(Tutorial tutorial);

}
