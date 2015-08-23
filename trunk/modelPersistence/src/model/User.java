package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang.builder.ToStringBuilder;

import model.superclasses.BaseEntity;

@Entity
@Table(name = "user", uniqueConstraints = {
		@UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "primary_email")
})
@NamedQueries({
	@NamedQuery(name = "User.findAll",					query = "SELECT u FROM User u "),
	@NamedQuery(name = "User.findById",					query = "SELECT u FROM User u WHERE u.id = :id"),
	@NamedQuery(name = "User.findByUsernameOrEmail",	query = "SELECT u FROM User u WHERE u.username = :param OR u.primaryEmail = :param"),
})
public class User extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 752185865212478550L;

	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "primary_email", nullable = false, unique = true)
	private String primaryEmail;

	@Column(name = "password", nullable = false)
	private String password;

	// Methods
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
		.append("id", this.id)
		.append("createdAt", this.createdAt)
		.append("username", this.username)
		.append("primaryEmail", this.primaryEmail)
		.toString();
	}
}