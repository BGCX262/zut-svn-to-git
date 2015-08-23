package fr.dorian.model.util.searchengine;

public class SearchEngineFactory {

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	private static SearchEngineFactory searchEngineFactory = null;
	
	//Singleton
	
	public static SearchEngineFactory getInstance() {
		if (searchEngineFactory == null)
			return (new SearchEngineFactory());
		return (searchEngineFactory);
	}
	
	//Factory
	
	public SearchEngine createSearchEngine(String className) {
		try {
			SearchEngine searchEngine = SearchEngine.class.newInstance();
			return (searchEngine);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return (null);
	}
}
