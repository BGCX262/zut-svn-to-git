package fr.dorian.service.dao.jpa.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dorian.model.Account;
import fr.dorian.model.Document;
import fr.dorian.service.dao.DocumentDAO;
import fr.dorian.service.dao.util.EntityManagerUtil;

@Repository
public class DocumentDAOImpl extends AbstractDAO<Document> implements DocumentDAO, Serializable {

	private static final long serialVersionUID = 6350447234652944923L;

	private static final Log log = LogFactory.getLog(DocumentDAO.class);
	
	@Override
	@Transactional(readOnly = true)
	public List<Document> findAll() {
		log.info("find all");
		return this.findAll(Document.class);
	}

	@Override
	@Transactional(readOnly = true)
	public Document findById(Integer id) {
		log.info("find by id // " + id);
		return this.findById(Document.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Document> findByAccount(Account account) {
		log.info("find by account id // " + account);
		
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("accountId", account.getId());
		return (List<Document>)EntityManagerUtil.executeNamedQueryInTransaction("Document.findByAccount", params);
	}
}
