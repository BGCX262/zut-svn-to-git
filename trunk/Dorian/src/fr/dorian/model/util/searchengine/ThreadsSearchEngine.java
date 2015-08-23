package fr.dorian.model.util.searchengine;

import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import fr.dorian.business.ThreadBO;
import fr.dorian.model.Post;
import fr.dorian.model.Thread;
import fr.dorian.service.exception.ServiceException;

public class ThreadsSearchEngine extends SearchObjectsManager implements SearchEngine {
	public static Logger logger = Logger.getLogger(ThreadsSearchEngine.class);

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////

	private SortedMap<Integer, SearchObject> sortedList = null;
	private static ThreadsSearchEngine instance = null;
	private ThreadBO threadBO = null;
	private String referer = null;
	
	//Constructors

	/**
	 * Private constructor
	 */
	private ThreadsSearchEngine() {
		this.sortedList = new TreeMap<Integer, SearchObject>(java.util.Collections.reverseOrder());
	}
	
	//Singleton
	
	/**
	 *  Singleton method
	 * @return new ThreadSearchEngine instance
	 */
	public static ThreadsSearchEngine getInstance() {
		if (instance == null)
			return (new ThreadsSearchEngine());
		return (instance);
	}
	
	//Virtual

	/**
	 * Evaluation of the pertinence of thread towards the referer.
	 */
	@Override
	public boolean evaluate(Object object) {
		logger.debug("evaluate");
		try {
			List<Thread> threads = this.threadBO.findAll();
		
			for (Thread thread : threads) {
				List<Post> posts = this.threadBO.findAllPostsFromThread(thread.getId());
				SearchObject searchObject = new SearchObject(thread, posts);
				
				searchObject.calcPertinence(referer);			
				if (searchObject.getPertinence() > 0)	
					this.sortedList.put(searchObject.getPertinence(), searchObject);
			}
			Iterator<Integer> iterator = this.sortedList.keySet().iterator();
			while (iterator.hasNext()) {
				Object pertinence = iterator.next();
				this.insertSearchObject(this.sortedList.get(pertinence));
			}
			return (true);
		} catch (ServiceException e) {
			logger.error("evalute failed", e);
		}
		return (false);
	}
	
	//Accessors
	
	public List<SearchObject> getSearchObjects() {return searchObjects;}
	public void setSearchObjects(List<SearchObject> searchObjects) {this.searchObjects = searchObjects;}
	public ThreadBO getThreadBO() {return threadBO;}
	public void setThreadBO(ThreadBO threadBO) {this.threadBO = threadBO;}
	public String getReferer() {return referer;}
	public void setReferer(String referer) {this.referer = referer;}
	public SortedMap<Integer, SearchObject> getSortedList() {return sortedList;	}
	public void setSortedList(SortedMap<Integer, SearchObject> sortedList) {this.sortedList = sortedList;}
}