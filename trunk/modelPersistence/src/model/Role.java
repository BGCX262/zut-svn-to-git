package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang.builder.ToStringBuilder;

import model.enums.RoleTypeEnum;
import model.superclasses.EditableEntity;

@Entity
@Table(name = "role", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "description"})})
@NamedQueries({ 
	@NamedQuery(name = "Role.findAll",      query = "SELECT r FROM Role r "),
	@NamedQuery(name = "Role.findById",     query = "SELECT r FROM Role r WHERE r.id = :id"),
	@NamedQuery(name = "Role.findByName",   query = "SELECT r FROM Role r WHERE r.name = :name")
})
public class Role extends EditableEntity implements Serializable, Cloneable {

	private static final long serialVersionUID	= 8020336849559637544L;

	public static final String ROLE_SUPERVISOR	= "Supervisor";

	public static final String ROLE_USER		= "User";

	public static final String ROLE_TELLER		= "Teller";

	@Transient
	private RoleTypeEnum type;

	@Column(nullable = false, unique = true)
	private String name;

	@Column(nullable = true, unique = true)
	private String description;

	@ManyToMany
	@JoinTable(name = "user_account",
	joinColumns = {
			@JoinColumn(name = "role_id", referencedColumnName = "id")},
			inverseJoinColumns = { @JoinColumn(name = "account_id", referencedColumnName = "id")})
	private Set<Account> accounts;
	
	public Role() {
	}

	public Role(String name, String description) {
		this.setName(name);
		this.setDescription(description);
	}
	
	public Role(RoleTypeEnum roleTypeEnum) {
		this.name = roleTypeEnum.name();
		this.type = roleTypeEnum;
		this.description = roleTypeEnum.getDescription();
	}

	public Role(String name, RoleTypeEnum roleTypeEnum) {
		this.name = name;
		this.type = roleTypeEnum;
		this.description = roleTypeEnum.getDescription();
	}

	// Methods
	public RoleTypeEnum getType() {
		return type;
	}

	public void setType(RoleTypeEnum type) {
		this.type = type;
	}

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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Role clone() {
		Role role = new Role();

		role.name			= this.name;
		role.description	= this.description;
		role.type			= this.type;
		role.createdAt		= this.createdAt;
		role.deleted		= this.deleted;

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
		.toString();
	}
}
