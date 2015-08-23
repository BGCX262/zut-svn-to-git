package fr.dorian.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import fr.dorian.model.superclasses.EditableEntity;

@Entity
@Table(name = "password_recovery", uniqueConstraints = @UniqueConstraint(columnNames = {"token"}))
@NamedQueries({
	@NamedQuery(name = "PasswordRecovery.findAll",	query = "SELECT pr FROM PasswordRecovery pr"),
	@NamedQuery(name = "PasswordRecovery.findById",	query = "SELECT pr FROM PasswordRecovery pr WHERE pr.id = :id"),
	@NamedQuery(name = "PasswordRecovery.findByToken",	query = "SELECT pr FROM PasswordRecovery pr WHERE pr.token = :token"),
	@NamedQuery(name = "PasswordRecovery.findByAccountId",	query = "SELECT pr FROM PasswordRecovery pr JOIN pr.account a WHERE a.id = :accountId"),
	@NamedQuery(name = "PasswordRecovery.findByAccountIdAndActive",	query = "SELECT pr FROM PasswordRecovery pr WHERE pr.account.id = :accountId AND pr.activated = :active"),
	@NamedQuery(name = "PasswordRecovery.findByAccountIdAndToken",	query = "SELECT pr FROM PasswordRecovery pr WHERE pr.account.id = :accountId AND pr.token = :token")
})
public class PasswordRecovery extends EditableEntity implements Serializable {

	private static final long serialVersionUID = -969083250489686828L;

	// PROPERTIES
	//////////////////////////////////////////////////////////////////////////////////////////////

	@ManyToOne
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;

	/**
	 * Recovery token
	 */
	@Column(name = "token", nullable = false)
	private String token;

	@Column(name = "ip_address", nullable = false)
	private String ipAddress;

	@Column(name = "activated")
	private boolean activated;

	// CONSTRUCTORS
	//////////////////////////////////////////////////////////////////////////////////////////////
	public PasswordRecovery() {
		super();
		this.setActivated(false);
	}
	
	// ACCESSORS
	//////////////////////////////////////////////////////////////////////////////////////////////
	public Account getAccount() {return account;}
	public void setAccount(Account account) {this.account = account;}

	public String getToken() {return token;}
	public void setToken(String token) {this.token = token;}

	public String getIpAddress() {return ipAddress;}
	public void setIpAddress(String ipAddress) {this.ipAddress = ipAddress;}

	public boolean isActivated() {return activated;}
	public void setActivated(boolean active) {this.activated = active;}
}