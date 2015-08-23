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
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang.builder.ToStringBuilder;

import model.superclasses.EditableEntity;

// TODO: Refactor title by name and Tag.findByTitle by Tag.findByName
// Same operation in database
@Entity
@Table(name = "tag", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
@NamedQueries({
	@NamedQuery(name = "Tag.findAll",		query = "SELECT t FROM Tag t "),
	@NamedQuery(name = "Tag.findById",		query = "SELECT t FROM Tag t WHERE t.id = :id"),
	@NamedQuery(name = "Tag.findByName",	query = "SELECT t FROM Tag t WHERE t.name = :name")
})
// List<Tag> findForAccount(Integer accoundId);
public class Tag extends EditableEntity implements Serializable {

	private static final long serialVersionUID = 3430529772963736249L;

	// Properties
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "created_by")
	private Account createdBy;
	
	// TODO: table: tag_parent; columns: tag_id, parent_id, id
	@OneToMany
	@JoinTable(name = "tag_parent",
		joinColumns = {@JoinColumn(name = "tag_id")},
		inverseJoinColumns = {@JoinColumn(name = "parent_id")})
	@Transient 
	private Set<Tag> parents;
	
	// TODO: table: tag_parent; columns: tag_id, parent_id, id
	@OneToMany
	@JoinTable(name = "tag_parent",
		joinColumns = {@JoinColumn(name = "parent_id")},
		inverseJoinColumns = {@JoinColumn(name = "tag_id")})
	@Transient
	private Set<Tag> children;
	
	// TODO: table: thread_tag; columns: tag_id, thread_id, id
	//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	@ManyToMany
	@JoinTable(name = "thread_tag",
		joinColumns = {@JoinColumn(name = "tag_id")},
		inverseJoinColumns = {@JoinColumn(name = "thread_id")})
	private Set<Thread> threads;
	
	// Constructors
	public Tag() {
	}

	public Tag(String title, Account account) {
		this.setCreatedBy(account);
		this.setName(title);
	}
	
	public Tag(String title, Account account, String description) {
		this.setCreatedBy(account);
		this.setName(title);
		this.setDescription(description);
	}
	
	// Accessors
	public String getName() {
		return name;
	}

	public void setName(String title) {
		this.name = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Account getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Account createdBy) {
		this.createdBy = createdBy;
	}

	public Set<Tag> getParents() {
		return parents;
	}

	public void setParents(Set<Tag> parents) {
		this.parents = parents;
	}

	public Set<Tag> getChildren() {
		return children;
	}

	public Set<Thread> getThreads() {
		return threads;
	}

	public void setThreads(Set<Thread> threads) {
		this.threads = threads;
	}

	public void setChildren(Set<Tag> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", this.id)
			.append("createdAt", this.createdAt)
			.append("title", this.name)
			.toString();
	}

}
