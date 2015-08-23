package fr.dorian.model.util.searchengine;

import java.util.List;

public class SearchObjectsHandler
{
	//Properties
	
	protected List<SearchObject> searchObjects;

	//Virtual

	public List<SearchObject> getSortedSearchObjectsList() {
		return (this.searchObjects);
	}	
}
