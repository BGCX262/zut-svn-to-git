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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.dorian.model.enums.RoleTypeEnum;
import fr.dorian.model.superclasses.EditableEntity;

@Entity
@Table(name = "role", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "description"})})
@NamedQueries({ 
	@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r "),
	@NamedQuery(name = "Role.findById",	query = "SELECT r FROM Role r WHERE r.id = :id"),
	@NamedQuery(name = "Role.findByName", query = "SELECT r FROM Role r WHERE r.name = :name"),
	@NamedQuery(name = "Role.findByAccount", query = "SELECT r FROM Role r JOIN r.accounts a WHERE a.id = :accountId"),
})
public class Role extends EditableEntity implements Serializable, Cloneable {

	private static final long serialVersionUID	= 8020336849559637544L;

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Column(nullable = false, unique = true)
	private String name;

	@Column(nullable = true, unique = true)
	private String description;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_account",
	joinColumns = {
			@JoinColumn(name = "role_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "account_id", referencedColumnName = "id")})
	private Set<Account> accounts;

	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	public Role() {
	}

	public Role(String name, String description) {
		this.setName(name);
		this.setDescription(description);
	}
	
	public Role(RoleTypeEnum roleTypeEnum) {
		this.name = roleTypeEnum.name();
		this.description = roleTypeEnum.getDescription();
	}

	public Role(String name, RoleTypeEnum roleTypeEnum) {
		this.name = name;
		this.description = roleTypeEnum.getDescription();
	}

	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
		
	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	// HELPER
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void addAccount(Account account) {
		if (this.accounts == null)
			this.accounts = new HashSet<Account>();
		this.accounts.add(account);
	}
	
	public void removeAccount(Account account) {
		if (this.accounts != null)
			this.accounts.remove(account);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Role clone() {
		Role role = new Role();

		//role.name			= this.name; // unique
		//role.description	= this.description; // unique
		role.createdAt		= this.createdAt;
		role.deleted		= this.deleted;
		role.accounts		= this.accounts;

		return role;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
		.append("id", this.id)
		.append("name", this.name)
		.append("description", this.description)
		.append("createdAt", this.createdAt)
		.append("deleted", this.deleted)
		.append("account", this.accounts)
		.toString();
	}
}
