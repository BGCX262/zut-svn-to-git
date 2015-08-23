package fr.dorian.service.dao;

import java.util.List;

import fr.dorian.model.Account;
import fr.dorian.model.Document;

public interface DocumentDAO extends IDAO<Document> {

	List<Document> findByAccount(Account account);
}
