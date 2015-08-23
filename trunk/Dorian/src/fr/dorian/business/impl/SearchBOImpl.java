package fr.dorian.business.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import fr.dorian.business.ThreadBO;
import fr.dorian.business.SearchBO;
import fr.dorian.model.util.searchengine.SearchObject;
import fr.dorian.model.util.searchengine.ThreadsSearchEngine;
import fr.dorian.service.exception.ServiceException;


@Scope("session")
@Service
public class SearchBOImpl implements SearchBO, Serializable {
	
	private static final long serialVersionUID = -3025988305293164468L;
	
	public static final Logger logger = Logger.getLogger(SearchBO.class);

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	private ThreadBO threadBO;
	
	// Transactional methods
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public List<SearchObject> searchThreads(String referer) throws ServiceException {
		try {
			if (referer == null)
				throw ServiceException.INVALID_REQUEST;
			
			ThreadsSearchEngine searchEngine = ThreadsSearchEngine.getInstance();
			
			searchEngine.setThreadBO(threadBO);
			searchEngine.setReferer(referer);
			searchEngine.evaluate(searchEngine.getThreadBO().findAll());
			return (searchEngine.getSortedSearchObjectsList());
		} catch (Exception e) {
			throw new ServiceException("find search threads failed", e);
		}
	}
}