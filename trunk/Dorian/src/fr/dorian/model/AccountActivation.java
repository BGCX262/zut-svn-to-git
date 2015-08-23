package fr.dorian.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "account_activation")
@NamedQueries({
	@NamedQuery(name = "AccountActivation.findAll",	query = "SELECT a FROM AccountActivation a "),
	@NamedQuery(name = "AccountActivation.findById",	query = "SELECT a FROM AccountActivation a WHERE a.id = :id"),
	@NamedQuery(name = "AccountActivation.findByCode",	query = "SELECT a FROM AccountActivation a WHERE a.code = :code"),
	@NamedQuery(name = "AccountActivation.findByUser",	query = "SELECT a FROM AccountActivation a JOIN a.user u WHERE u.id = :userId")	
})
public class AccountActivation implements Serializable {

	private static final long serialVersionUID = 4257328923356259776L;

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@Column(name = "code", nullable = false)
	private String code;

	@Column(name = "activated", nullable = false)
	private boolean activated;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", insertable = true, updatable = false, nullable = true)
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "activated_at", insertable = false, updatable = true, nullable = true)
	private Date activatedAt;
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	public AccountActivation() {
		super();
		this.activated = false;
	}
	
	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	public Integer getId() {return id;}
	public void setId(Integer id) {	this.id = id;}
	
	public User getUser() {return user;}
	public void setUser(User user) {this.user = user;}
	
	public String getCode() {return code;}
	public void setCode(String code) {this.code = code;}
	
	public boolean isActivated() {return activated;}
	public void setActivated(boolean activated) {this.activated = activated;}
	
	public Date getCreatedAt() {return createdAt;}
	public void setCreatedAt(Date createdAt) {this.createdAt = createdAt;}
	
	public Date getActivatedAt() {return activatedAt;}
	public void setActivatedAt(Date activatedAt) {this.activatedAt = activatedAt;}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
		.append("id", this.id)
		.append("code", this.code)
		.toString();
	}

}

