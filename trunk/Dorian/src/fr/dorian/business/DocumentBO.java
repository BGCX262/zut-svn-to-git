package fr.dorian.business;

import java.util.List;

import fr.dorian.model.Document;
import fr.dorian.service.exception.ServiceException;

public interface DocumentBO {

	List<Document> findByAccountId(Integer accountId) throws ServiceException;

	List<Document> findAll() throws ServiceException;

}
