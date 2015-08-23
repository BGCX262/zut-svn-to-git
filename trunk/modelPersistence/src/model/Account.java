package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang.builder.ToStringBuilder;

import model.Role;
import model.User;

import model.superclasses.EditableEntity;

@Entity
@Table(name = "account", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id"}))
@NamedQueries({
	@NamedQuery(name = "Account.findAll",	query = "SELECT a FROM Account a "),
	@NamedQuery(name = "Account.findById",	query = "SELECT a FROM Account a WHERE a.id = :id")
})
public class Account extends EditableEntity implements Serializable {

	private static final long serialVersionUID = 966765818705470424L;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User owner;
	
	@ManyToMany
	@JoinTable(name = "user_account",
	joinColumns = {
			@JoinColumn(name = "account_id", referencedColumnName = "id")},
			inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id")})
	private Set<Role> roles;
	
	@Column
	private boolean disabled;
	
	@Column
	private boolean locked;
	
	@Column
	private boolean expired;

	public Account() {
	}
	
	// Methods
	public User getOwner() {
		return owner;
	}

	public void setOwner(User user) {
		this.owner = user;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public boolean isAccountNonExpired() {
		return !this.expired;
	}

	public boolean isCredentialsNonExpired() {
		return !this.expired;
	}
	
	public void addRole(Role role) {
		if (this.roles == null)
			this.roles = new HashSet<Role>();
		this.roles.add(role);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
		.append("id", this.id)
		.append("deleted", this.deleted)
		.append("user", this.owner)
		.toString();
	}
}
