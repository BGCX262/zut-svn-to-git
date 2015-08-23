package fr.dorian.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import fr.dorian.model.superclasses.BaseEntity;

@Entity
@Table(name = "user", uniqueConstraints = {
		@UniqueConstraint(columnNames = "primary_email")
})
@NamedQueries({
	@NamedQuery(name = "User.findAll",		query = "SELECT u FROM User u "),
	@NamedQuery(name = "User.findById",		query = "SELECT u FROM User u WHERE u.id = :id"),
	@NamedQuery(name = "User.findByEmail",	query = "SELECT u FROM User u WHERE u.primaryEmail = :param")
})
public class User extends BaseEntity implements UserDetails, Serializable {

	private static final long serialVersionUID 	= 752185865212478550L;

	public static final String UNKNOW_USER		= "UNKNOW";
	
	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * For spring security
	 */
	@Column(insertable = false, updatable = false)
	private Integer id;
	
	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "primary_email", nullable = false, unique = true)
	private String primaryEmail;

	@Column(name = "password", nullable = false)
	private String password;

	// For spring Security
	@Transient
	private boolean enabled;
	@Transient
	private boolean accountNonExpired;
	@Transient
	private boolean credentialsNonExpired;
	@Transient
	private boolean accountNonLocked;
	@Transient
	private Set<GrantedAuthority> authorities;

	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	public User() {
	}

	public User(String email, String password) {
		this.setUsername(UNKNOW_USER);
		this.setPrimaryEmail(email);
		this.setPassword(password);
	}

	public User(String username, String email, String password) {
		this.setUsername(username);
		this.setPrimaryEmail(email);
		this.setPassword(password);
	}
	
	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Get the identifier
	 * Override Base Entity getter
	 * This is necessary for Spring Security
	 * @see BaseEntity
	 */
	@Override
	public Integer	getId() {return id;}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// HELPER
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
		.append("id", this.id)
		.append("createdAt", this.createdAt)
		.append("username", this.username)
		.append("primaryEmail", this.primaryEmail)
		.toString();
	}

	// Used for salt source
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public void addDetails(boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Set<GrantedAuthority> authorities) {
		this.enabled = enabled;
		this.accountNonExpired = accountNonExpired;
		this.credentialsNonExpired = credentialsNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.authorities = authorities;
	}
}