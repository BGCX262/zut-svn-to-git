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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import fr.dorian.model.Role;
import fr.dorian.model.User;

import fr.dorian.model.superclasses.EditableEntity;

@Entity
@Table(name = "account", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id"}))
@NamedQueries({
	@NamedQuery(name = "Account.findAll",	query = "SELECT a FROM Account a"),	
	@NamedQuery(name = "Account.findById",	query = "SELECT a FROM Account a WHERE a.id = :id"),	
	@NamedQuery(name = "Account.findByEmail",	query = "SELECT a FROM Account a JOIN a.user u WHERE u.primaryEmail = :email"),	
	@NamedQuery(name = "Account.findByUser",	query = "SELECT a FROM Account a JOIN a.user u WHERE u.id = :userId")	
})
public class Account extends EditableEntity implements Serializable, Comparable<Account> {

	private static final long serialVersionUID = 966765818705470424L;

	// PROPERTIES
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_account",
		joinColumns = {@JoinColumn(name = "account_id", referencedColumnName = "id")},
		inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
	private Set<Role> roles;
	
	@OneToOne(mappedBy = "account")
	private AccountInfos accountInfos;
	
	@OneToOne(mappedBy = "account")
	private Profile profile;
	
	@OneToOne(mappedBy = "account")
	private AccountSettings settings;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private Set<Address> addresses;
	
	@Column
	private boolean avatar;
	
	@Column
	private boolean disabled;
	
	@Column
	private boolean locked;
	
	@Column
	private boolean expired;
	
	@Transient
	private String username;

	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Account() {
		super();
	}
	
	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public User getUser() {return user;}
	public void setUser(User user) {this.user = user;}

	public Set<Role> getRoles() {return roles;}
	public void setRoles(Set<Role> roles) {this.roles = roles;}

	public boolean isDisabled() {return disabled;}
	public void setDisabled(boolean disabled) {this.disabled = disabled;}

	public boolean isLocked() {return locked;}
	public void setLocked(boolean locked) {this.locked = locked;}

	public boolean isExpired() {return expired;}
	public void setExpired(boolean expired) {this.expired = expired;}

	public boolean isAvatar() {return avatar;}
	public void setAvatar(boolean avatar) {this.avatar = avatar;}
	
	public AccountInfos getAccountInfos() {return accountInfos;}
	public void setAccountInfos(AccountInfos accountInfos) {this.accountInfos = accountInfos;}
	
	public AccountSettings getSettings() {return settings;}
	public void setSettings(AccountSettings accountSettings) {this.settings = accountSettings;}
	
	public Profile getProfile() {return profile;}
	public void setProfile(Profile profile) {this.profile = profile;}

	public Set<Address> getAddresses() {return addresses;}
	public void setAddresses(Set<Address> addresses) {this.addresses = addresses;}
	
	// HELPER
	///////////////////////////////////////////////////////////////////////////////////////////////

	public boolean isEnabled() {
		return !this.disabled;
	}
	
	public boolean isAccountNonExpired() {
		return !this.expired;
	}
	
	public boolean isCredentialsNonExpired() {
		return !this.expired;
	}

	public boolean isAccountNonLocked() {
		return !this.locked;
	}
	
	public void addRole(Role role) {
		if (this.roles == null)
			this.roles = new HashSet<Role>();
		this.roles.add(role);
	}

	public void removeRole(Role role) {
		if (this.roles != null)
			this.roles.remove(role);
	}
	
	public String getUsername() {
		if (this.user != null)
			this.username = this.user.getPrimaryEmail();
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public boolean isSupervisor() {
		for (Role role : this.roles) {
			if (role.getName().compareTo("ROLE_SUPERVISOR") == 0)
				return (true);
		}
		return (false);
	}
	
	public void addAddress(Address address) {
		if (this.addresses == null)
			this.addresses = new HashSet<Address>();
		this.addresses.add(address);
	}

	public void removeAddress(Address address) {
		if (this.addresses != null)
			this.addresses.remove(address);
	}
	
	public boolean hasProfile() {
		return this.profile == null;
	}
	
	public boolean hasAddress() {
		return this.addresses == null;
	}
	
	@Override
	public int compareTo(Account other) {
		return this.getId().compareTo(other.getId());
	}
	
	public boolean equals(Account other) {
		return this.getId().equals(other.getId());
	}

}
