package fr.dorian.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.dorian.model.superclasses.BaseEntity;

@Entity
@Table(name = "comment")
@NamedQueries({
	@NamedQuery(name = "Comment.findAll",	query = "SELECT c FROM Comment c ORDER BY c.id DESC"),
	@NamedQuery(name = "Comment.findById",	query = "SELECT c FROM Comment c WHERE c.id = :id"),
	@NamedQuery(name = "Comment.findByAccountId",	query = "SELECT c FROM Comment c WHERE c.account.id = :accountId"),
	@NamedQuery(name = "Comment.findByTutorialId",query = "SELECT c FROM Comment c WHERE c.tutorial.id = :tutorialId")
})
public class Comment extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -7749828831723399198L;
	
	private String text;
	
	@ManyToOne
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;
	
	@ManyToOne
	@JoinColumn(name = "tutorial_id", nullable = false)
	private Tutorial tutorial;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Tutorial getTutorial() {
		return tutorial;
	}
	
	public void setTutorial(Tutorial tutorial) {
		this.tutorial = tutorial;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", this.id)
			.toString();
	}

}
