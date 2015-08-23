package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;

import model.superclasses.EditableEntity;

@Entity
@Table(name = "thread")
@NamedQueries({
	@NamedQuery(name = "Thread.findAll",	query = "SELECT t FROM Thread t "),
	@NamedQuery(name = "Thread.findById",	query = "SELECT t FROM Thread t WHERE t.id = :id")
})
//List<Thread> findForAccount(Integer accoundId);
public class Thread extends EditableEntity implements Serializable {

	private static final long serialVersionUID = -4369307514823247746L;
	
	// Properties
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "actived")
	private boolean actived;
	
	@ManyToOne
	@JoinColumn(name = "created_by")
	private Account createdBy;

	// TODO: table: thread_tag; columns: tag_id, thread_id, id
	@ManyToMany
	@JoinTable(name = "thread_tag",
		joinColumns = {@JoinColumn(name = "thread_id")},
		inverseJoinColumns = {@JoinColumn(name = "tag_id")})
	@Transient
	private Set<Tag> tags;
	
	// TODO:
	@OneToMany
	@JoinColumn(name = "thread_id", referencedColumnName = "id")
	@Transient
	private Set<Post> posts;

	// Constructor
	public Thread() {
	}
	
	// Accessors
	public String getTitle() {
		return title;
	}

	public boolean isActived() {
		return actived;
	}

	public Account getCreatedBy() {
		return createdBy;
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
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", this.id)
			.append("title", this.title)
			.append("createdBy", this.createdBy)
			.toString();
	}

}
