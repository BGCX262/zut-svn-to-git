package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

import model.superclasses.BaseEntity;

@Entity
@Table(name = "post")
@NamedQueries({
	@NamedQuery(name = "Post.findAll",	query = "SELECT p FROM Post p "),
	@NamedQuery(name = "Post.findById",	query = "SELECT p FROM Post p WHERE p.id = :id")
})
public class Post extends BaseEntity implements Serializable{

	private static final long serialVersionUID = -7066913043020965006L;

	// Properties
	@Column(name = "content", nullable = false)
	private String content;
	
	@Column(name = "actived")
	private boolean actived;
	
	@ManyToOne
	@JoinColumn(name = "owner", nullable = false)
	private Account owner;
	
	// Constructors
	public Post() {
		this.setActived(true);
	}

	public Post(Account account, String content) {
		this.setOwner(account);
		this.setContent(content);
		this.setActived(true);
	}
	
	// Accessors
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public boolean isActived() {
		return actived;
	}
	
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	
	public Account getOwner() {
		return owner;
	}
	
	public void setOwner(Account owner) {
		this.owner = owner;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", this.id)
			.append("createdAt", this.createdAt)
			.append("content", this.content)
			.append("owner", this.owner)
			.append("actived", this.actived)
			.toString();
	}
}
