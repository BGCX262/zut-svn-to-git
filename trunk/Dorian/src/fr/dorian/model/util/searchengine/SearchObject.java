package fr.dorian.model.util.searchengine;

import java.util.List;

import org.springframework.util.StringUtils;

import fr.dorian.model.Post;
import fr.dorian.model.Tag;
import fr.dorian.model.Thread;

public class SearchObject {	
	
	//Properties
	
	private Integer pertinence = 0;
	private Thread thread = null;
	private List<Post> posts = null;
	private List<Tag> tags = null;
	
	//Constructor
	
	public SearchObject(Thread thread, List<Post> posts) {
		this.setThread(thread);
		this.setPosts(posts);
	}
	
	//Public members
	
	public void calcPertinence(String referer) {
		String copyReferer = referer;
		this.calcThreadTitlePertinence(copyReferer.toLowerCase());
		this.calcThreadPostContentPertinence(copyReferer.toLowerCase());
	}
	
	//Private members
	
	private void calcThreadTitlePertinence(String referer) {
		String copyTitle = this.thread.getTitle();
		this.pertinence += StringUtils.countOccurrencesOf(copyTitle.toLowerCase(), referer);
	}
	
	private void calcThreadPostContentPertinence(String referer) {
		for (Post post : this.posts) {
			String copyContent = post.getContent();
			this.pertinence += StringUtils.countOccurrencesOf(copyContent.toLowerCase(), referer);
		}
	}
	
	//Accessors
	
	public Integer getPertinence() {return pertinence;}
	public void setPertinence(Integer pertinence) {this.pertinence = pertinence;}
	public Thread getThread() {return thread;}
	public void setThread(Thread thread) {this.thread = thread;}
	public List<Post> getPosts() {return posts;}
	public void setPosts(List<Post> posts) {this.posts = posts;}
	public List<Tag> getTags() {return tags;}
	public void setTags(List<Tag> tags) {this.tags = tags;}
}
