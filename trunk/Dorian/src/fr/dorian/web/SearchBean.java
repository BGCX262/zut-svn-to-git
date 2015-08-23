package fr.dorian.web;

import java.util.List;

import fr.dorian.model.util.searchengine.SearchObject;

public interface SearchBean {

	public abstract String getValue();
	public abstract void setValue(String value);
	public abstract List<SearchObject> findSearchedThreads();
	public abstract String redirectToSearchedThreads();

}
