package fr.dorian.business;

import java.util.List;

import fr.dorian.model.util.searchengine.SearchObject;
import fr.dorian.service.exception.ServiceException;


public interface SearchBO
{
	public List<SearchObject> searchThreads(String referer) throws ServiceException;
}
