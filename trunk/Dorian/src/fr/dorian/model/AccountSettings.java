package fr.dorian.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.apache.commons.lang.builder.ToStringBuilder;

import fr.dorian.model.superclasses.EditableEntity;

@Entity
@Table(name = "account_settings")
@NamedQueries({
	@NamedQuery(name = "AccountSettings.findAll", query = "SELECT a FROM AccountSettings a"),
	@NamedQuery(name = "AccountSettings.findById", query = "SELECT a FROM AccountSettings a WHERE a.id = :id"),
	@NamedQuery(name = "AccountSettings.findByAccountId", query = "SELECT a FROM AccountSettings a JOIN a.account aa WHERE aa.id = :accountId")	
})
public class AccountSettings extends EditableEntity implements Serializable {

	private static final long serialVersionUID = -1068596329157238567L;

	// PROPERTIES
	//////////////////////////////////////////////////////////////////////////////////////////////

	@OneToOne
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;
	
	@Column(name = "notifier_post")
	private boolean notifierPost;
	
	@Column(name = "notifier_comment")
	private boolean notifierComment;
	
	// For language
	//private Locale locale;

	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public AccountSettings() {
	}
	
	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public boolean isNotifierPost() {
		return notifierPost;
	}

	public void setNotifierPost(boolean notifierPost) {
		this.notifierPost = notifierPost;
	}

	public boolean isNotifierComment() {
		return notifierComment;
	}

	public void setNotifierComment(boolean notifierComment) {
		this.notifierComment = notifierComment;
	}
	
	// HELPER
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
		.append("id", this.id)
		.toString();
	}

}
