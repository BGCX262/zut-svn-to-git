package fr.dorian.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.dorian.model.superclasses.EditableEntity;

@Entity
@Table(name = "thread")
@NamedQueries({
	@NamedQuery(name = "Thread.findAll", query = "SELECT t FROM Thread t ORDER BY t.id DESC"),
	@NamedQuery(name = "Thread.findById", query = "SELECT t FROM Thread t WHERE t.id = :id"),
	@NamedQuery(name = "Thread.countByAccount", query = "SELECT COUNT(t) FROM Thread t WHERE t.createdBy.id = :accountId"),
	@NamedQuery(name = "Thread.findByAccountId", query = "SELECT t FROM Thread t WHERE t.createdBy.id = :accountId ORDER BY t.id DESC"),
	@NamedQuery(name = "Thread.findPostsByThreadId", query = "SELECT p FROM Post p JOIN p.thread t WHERE t.id = :id ORDER BY p.id ASC"),
	@NamedQuery(name = "Thread.findAllWithReferer",	query = "SELECT t FROM Thread t WHERE LOWER(t.title) LIKE :referer ORDER BY t.id DESC")
//	@NamedQuery(name = "Thread.findRelated", query = "SELECT t FROM Thread t INNER JOIN t.tags tt ON t.id = tt.threaid" + 
//"WHERE tt.tag_id " + 
//"	IN(SELECT itt.tag_id FROM thread_tag itt WHERE itt.thread_id = 1)" + 
//"	AND t.id != 1 GROUP BY t.id"+
//"HAVING COUNT(*) "+
//"LIMIT 3;")
})
	
	/*"INNER JOIN thread_tag tt ON t.id = tt.thread_id" + 
	"WHERE tt.tag_id " + 
	"	IN(SELECT itt.tag_id FROM thread_tag itt WHERE itt.thread_id = 1)" + 
	"	AND t.id != 1 GROUP BY t.id"+
	"HAVING COUNT(*) "+
	"LIMIT 3;"*/
	//@NamedQuery(name = "Thread.findRelated", query = "SELECT t FROM Thread t INNER JOIN () MATCHE")
public class Thread extends EditableEntity implements Serializable {

	private static final long serialVersionUID = 4943712512985988844L;

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "actived")
	private boolean actived;
	
	// thread closed by owner after best response
	@Column(name = "closed")
	private boolean closed;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "post_valid_id", nullable = true)
	private Post postValidate;
	
	@ManyToOne
	@JoinColumn(name = "created_by", nullable = false)
	private Account createdBy;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "thread_tag",
		joinColumns = {@JoinColumn(name = "thread_id")},
		inverseJoinColumns = {@JoinColumn(name = "tag_id")})
	private Set<Tag> tags;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "thread_id", referencedColumnName = "id")
	private Set<Post> posts;

	/**
	 * Returns the number of posts
	 */
	@Transient
	private Integer postCounter;
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Thread() {
		super();
		this.setActived(true);
	}
	
	public Thread(Account account, String title) {
		this.setCreatedBy(account);
		this.setTitle(title);
		this.setActived(true);
	}
	
	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getTitle() {
		return title;
	}

	public boolean isActived() {
		return actived;
	}

	public Account getCreatedBy() {
		return createdBy;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public void setCreatedBy(Account createdBy) {
		this.createdBy = createdBy;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	
	// HELPER
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void addTag(Tag tag) {
		if (this.tags == null)
			this.tags = new HashSet<Tag>();
		this.tags.add(tag);
	}

	public void removeTag(Tag tag) {
		if (this.tags != null)
			this.tags.remove(tag);
	}
	
	public void addPost(Post post) {
		if (this.posts == null)
			this.posts = new HashSet<Post>();
		this.posts.add(post);
	}

	public void removePost(Post post) {
		if (this.posts != null)
			this.posts.remove(post);
	}

	public Integer getPostCounter() {
		if (this.posts != null)
			this.postCounter = this.posts.size();
		return postCounter;
	}
	
	public void setPostCounter(Integer cpt) {
		this.postCounter = cpt;
	}
	
	public Post getPostValidate() {
		return postValidate;
	}
	
	public void setPostValidate(Post postValidate) {
		this.postValidate = postValidate;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", this.id)
			.append("title", this.title)
			.append("createdBy", this.createdBy)
			.toString();
	}
}
