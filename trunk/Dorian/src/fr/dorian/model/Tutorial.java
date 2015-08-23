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

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.dorian.model.superclasses.EditableEntity;

@Entity
@Table(name = "tutorial")
@NamedQueries({
	@NamedQuery(name = "Tutorial.findAll", query = "SELECT t FROM Tutorial t ORDER BY t.id DESC"),
	@NamedQuery(name = "Tutorial.findById", query = "SELECT t FROM Tutorial t WHERE t.id = :id"),
	@NamedQuery(name = "Tutorial.countByAccount", query = "SELECT COUNT(t) FROM Tutorial t WHERE t.account.id = :accountId"),
	@NamedQuery(name = "Tutorial.findByAccountId", query = "SELECT t FROM Tutorial t WHERE t.account.id = :accountId ORDER BY t.id DESC"),
	@NamedQuery(name = "Tutorial.findByThreadId", query = "SELECT t FROM Tutorial t WHERE t.thread.id = :threadId")
})
public class Tutorial extends EditableEntity implements Serializable {

	private static final long serialVersionUID = -3811480556563713464L;

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "content", nullable = false)
	private String content;
	
	@Column(name = "description", nullable = true)
	private String description;
	
	@Column(name = "question", nullable = true)
	private String question;
	
	@ManyToOne
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;
	
	@ManyToOne
	@JoinColumn(name = "second_account_id", nullable = true)
	private Account secondAccount;
	
	@ManyToOne
	@JoinColumn(name = "thread_id", nullable = true) 
	private Thread thread;
	
	@Column
	private boolean actived;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tutorial_tag",
		joinColumns = {@JoinColumn(name = "tutorial_id")},
		inverseJoinColumns = {@JoinColumn(name = "tag_id")})
	private Set<Tag> tags;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "tutorial_id", referencedColumnName = "id")
	private Set<Attachment> attachments;
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	public Tutorial() {
		this.actived = false;
	}

	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}

	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}

	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}

	public Account getAccount() {return account;}
	public void setAccount(Account account) {this.account = account;}

	public Account getSecondAccount() {return secondAccount;}
	public void setSecondAccount(Account secondAccount) {this.secondAccount = secondAccount;}

	public Thread getThread() {return thread;}
	public void setThread(Thread thread) {this.thread = thread;}
	
	public boolean isActived() {return actived;}
	public void setActived(boolean actived) {this.actived = actived;}

	public Set<Tag> getTags() {return tags;}
	public void setTags(Set<Tag> tags) {this.tags = tags;}
	
	public String getQuestion() {return question;}
	public void setQuestion(String question) {this.question = question;}
	
	// HELPER
	///////////////////////////////////////////////////////////////////////////////////////////////

	public boolean isFromThread() {
		if (this.thread == null && this.secondAccount == null)
			return false;
		return true;
	}
	
	public void addTag(Tag tag) {
		if (this.tags == null)
			this.tags = new HashSet<Tag>();
		this.tags.add(tag);
	}

	public void removeTag(Tag tag) {
		if (this.tags != null)
			this.tags.remove(tag);
	}
	
	public void addAttachment(Attachment attachment) {
		if (this.attachments == null)
			this.attachments = new HashSet<Attachment>();
		this.attachments.add(attachment);
	}
	
	public void removeAttachment(Attachment attachment) {
		if (this.attachments != null)
			this.attachments.remove(attachment);
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", this.id)
			.append("title", this.title)
			.append("account", this.account)
			.toString();
	}
}
