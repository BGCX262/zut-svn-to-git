package fr.dorian.model.util.searchengine;

import java.util.ArrayList;
import java.util.List;

public class SearchObjectsManager
{
	//Properties
	
	protected List<SearchObject> searchObjects = new ArrayList<SearchObject>();

	//Virtual
	
	public void insertSearchObject(SearchObject searchObject) {
		this.searchObjects.add(searchObject);
	}

	public List<SearchObject> getSortedSearchObjectsList() {
		return (this.searchObjects);
	}
}
