package fr.dorian.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.dorian.model.Attachment;

import org.apache.commons.lang.builder.ToStringBuilder;
import fr.dorian.model.superclasses.EditableEntity;

@Entity
@Table(name = "post")
@NamedQueries({
	@NamedQuery(name = "Post.findAll",	query = "SELECT p FROM Post p WHERE p.actived = true"),
	@NamedQuery(name = "Post.findById",	query = "SELECT p FROM Post p WHERE p.id = :id"),
	@NamedQuery(name = "Post.findByThread",	query = "SELECT p FROM Post p WHERE p.thread.id = :threadId"),
	@NamedQuery(name = "Post.findByAccount",query = "SELECT p FROM Post p WHERE p.account.id = :accountId"),
	@NamedQuery(name = "Post.countByAccount", query = "SELECT COUNT(p) FROM Post p WHERE p.account.id = :accountId")
})
public class Post extends EditableEntity implements Serializable{

	private static final long serialVersionUID = -7066913043020965006L;

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Column(name = "content", nullable = false)
	private String content;
	
	@Column(name = "actived")
	private boolean actived;
	
	@Column(name = "is_question", nullable=false)
	private boolean question;
	
	@ManyToOne
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;
	
	@ManyToOne
	@JoinColumn(name = "thread_id", nullable = false)
	private Thread thread;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "post_id", referencedColumnName = "id")
	private Set<Attachment> attachments;
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Post() {
		super();
		this.setActived(true);
	}

	public Post(Account account, Thread thread, String content) {
		this.setAccount(account);
		this.setThread(thread);
		this.setContent(content);
		this.setActived(true);
	}
	
	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	
	public boolean isActived() {return actived;}
	public void setActived(boolean actived) {this.actived = actived;}
	
	public Account getAccount() {return account;}
	public void setAccount(Account owner) {this.account = owner;}
	
	public Thread getThread() {return thread;}
	public void setThread(Thread thread) {this.thread = thread;}
	
	public Set<Attachment> getAttachments() {return attachments;}
	public void setAttachments(Set<Attachment> attachments) {this.attachments = attachments;}

	// HELPER
	///////////////////////////////////////////////////////////////////////////////////////////////

	public void addAttachment(Attachment attachment) {
		if (this.attachments == null)
			this.attachments = new HashSet<Attachment>();
		this.attachments.add(attachment);
	}
	
	public void removeAttachment(Attachment attachment) {
		if (this.attachments != null)
			this.attachments.remove(attachment);
	}

	/**
	 * Check if the current post has been validated by a user.
	 */
	public boolean isValidate() {
		if (this.getThread().getPostValidate() == null)
			return (false);
		else {
			if (this.id == this.getThread().getPostValidate().getId())
				return (true);
		}
		return (false);
	}
	
	//public 
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", this.id)
			.append("createdAt", this.createdAt)
			.append("content", this.content)
			.append("owner", this.account)
			.append("actived", this.actived)
			.toString();
	}

	public boolean isQuestion() {return question;}
	public void setQuestion(boolean isQuestion) {this.question = isQuestion;}
}
