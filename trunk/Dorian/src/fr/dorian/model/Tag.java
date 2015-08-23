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
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.dorian.model.superclasses.EditableEntity;

@Entity
@Table(name = "tag", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
@NamedQueries({
	@NamedQuery(name = "Tag.findAll", query = "SELECT t FROM Tag t WHERE t.deleted = false"),
	@NamedQuery(name = "Tag.findById", query = "SELECT t FROM Tag t WHERE t.id = :id"),
	@NamedQuery(name = "Tag.contains", query = "SELECT t FROM Tag t WHERE LOWER(t.name) LIKE :param OR LOWER(t.description) LIKE :param"),
	@NamedQuery(name = "Tag.findByName", query = "SELECT t FROM Tag t WHERE t.name = :name AND t.deleted = false"),
	@NamedQuery(name = "Tag.findByThread", query = "SELECT t FROM Tag t JOIN t.threads th WHERE th.id = :threadId AND t.deleted = false"),
	@NamedQuery(name = "Tag.findByTutorial", query = "SELECT t FROM Tag t JOIN t.tutorials tu WHERE tu.id = :tutorialId AND t.deleted = false"),
	@NamedQuery(name = "Tag.countByAccount", query = "SELECT COUNT(t) FROM Tag t JOIN t.createdBy a WHERE a.id = :accountId AND t.deleted = false"),
	@NamedQuery(name = "Tag.findForAccount", query = "SELECT t FROM Tag t JOIN t.createdBy a WHERE a.id = :id AND t.deleted = false"),
	@NamedQuery(name = "Tag.findStartsWith", query = "SELECT t FROM Tag t WHERE t.name LIKE :name")
	//@NamedQuery(name = "Tag.countAllThreads",query = "SELECT t FROM Tag t JOIN t.createdBy a, t.threads tt WHERE a.id = :id AND tt.createdBy.id = a.id AND t. ")
})
// List<Tag> findForAccount(Integer accoundId);
public class Tag extends EditableEntity implements Serializable {

	private static final long serialVersionUID = 3430529772963736249L;

	public static final CharSequence SEPARATOR = ",";
	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "created_by")
	private Account createdBy;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tag_parent",
		joinColumns = {@JoinColumn(name = "tag_id")},
		inverseJoinColumns = {@JoinColumn(name = "parent_id")})
	private Set<Tag> parents;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tag_parent",
		joinColumns = {@JoinColumn(name = "parent_id")},
		inverseJoinColumns = {@JoinColumn(name = "tag_id")})
	private Set<Tag> children;
	
	//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "thread_tag",
		joinColumns = {@JoinColumn(name = "tag_id")},
		inverseJoinColumns = {@JoinColumn(name = "thread_id")})
	private Set<Thread> threads;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "account_tag",
		joinColumns = {@JoinColumn(name = "tag_id")},
		inverseJoinColumns = {@JoinColumn(name = "account_id")})
	private Set<Account> accounts;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tutorial_tag",
		joinColumns = {@JoinColumn(name = "tag_id")},
		inverseJoinColumns = {@JoinColumn(name = "tutorial_id")})
	private Set<Tutorial> tutorials;
	
	@Transient
	private Integer threadsCounter;
	@Transient
	private Integer tutorialsCounter;
	@Transient
	private Integer accountsCounter;
	@Transient
	private Integer all;
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////

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
	
	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	public String getName() {return name;}
	public void setName(String title) {this.name = title;}

	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	
	public Account getCreatedBy() {return createdBy;}
	public void setCreatedBy(Account createdBy) {this.createdBy = createdBy;}

	public Set<Tag> getParents() {return parents;}
	public void setParents(Set<Tag> parents) {this.parents = parents;}

	public Set<Tag> getChildren() {return children;}
	public Set<Thread> getThreads() {return threads;}

	public void setThreads(Set<Thread> threads) {this.threads = threads;}
	public void setChildren(Set<Tag> children) {this.children = children;}
	
	public Set<Account> getAccounts() {return accounts;}
	public void setAccounts(Set<Account> accounts) {this.accounts = accounts;}

	public Set<Tutorial> getTutorials() {return tutorials;}
	public void setTutorials(Set<Tutorial> tutorials) {this.tutorials = tutorials;}
	
	public Integer getThreadsCounter() {
		if (this.threads != null)
			this.threadsCounter = this.threads.size();
		return threadsCounter;
	}
	
	public void setThreadsCounter(Integer threadsCounter) {
		this.threadsCounter = threadsCounter;
	}

	public Integer getTutorialsCounter() {
		if (this.tutorials != null)
			this.tutorialsCounter = this.tutorials.size();
		return tutorialsCounter;
	}

	public void setTutorialsCounter(Integer tutorialCounter) {
		this.tutorialsCounter = tutorialCounter;
	}

	public Integer getAccountsCounter() {
		if (this.accounts != null)
			this.accountsCounter = this.accounts.size();
		return accountsCounter;
	}

	public void setAccountsCounter(Integer accountCounter) {
		this.accountsCounter = accountCounter;
	}

	public Integer getAll() {
		this.all = this.getThreadsCounter() + this.getTutorialsCounter() + this.getAccountsCounter();
		return all;
	}

	public void setAll(Integer all) {
		this.all = all;
	}
	
	// HELPER
	///////////////////////////////////////////////////////////////////////////////////////////////

	public void addParentTag(Tag tag) {
		if (this.parents == null)
			this.parents = new HashSet<Tag>();
		this.parents.add(tag);
	}
	
	public void removeParentTag(Tag tag) {
		if (this.parents != null)
			this.parents.remove(tag);
	}
	
	public void addChildTag(Tag tag) {
		if (this.children == null)
			this.children = new HashSet<Tag>();
		this.children.add(tag);
	}
	
	public void removeChildTag(Tag tag) {
		if (this.children != null)
			this.children.remove(tag);
	}
	
	public void addThread(Thread thread) {
		if (this.threads == null)
			this.threads = new HashSet<Thread>();
		this.threads.add(thread);
	}
	
	public void removeThread(Thread thread) {
		if (this.threads != null)
			this.threads.remove(thread);
	}
	
	public void addAccount(Account account) {
		if (this.accounts == null)
			this.accounts = new HashSet<Account>();
		this.accounts.add(account);
	}
	
	public void removeAccount(Account account) {
		if (this.accounts != null)
			this.accounts.remove(account);
	}
	
	public void addTutorial(Tutorial tutorial) {
		if (this.tutorials == null)
			this.tutorials = new HashSet<Tutorial>();
		this.tutorials.add(tutorial);
	}
	
	public void removeTutorial(Tutorial tutorial) {
		if (this.tutorials != null)
			this.tutorials.remove(tutorial);
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", this.id)
			.append("createdBy", this.createdBy)
			.append("title", this.name)
			.append("createdAt", this.createdAt)
			.toString();
	}
}
