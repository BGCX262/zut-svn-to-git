package com.fr.zut.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import com.fr.zut.model.enums.RoleTypeEnum;
import com.fr.zut.model.enums.StdWords;
import com.fr.zut.model.superclasses.BaseEntity;

@Entity
@Table(name="user")
public class User extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3791026664999760984L;

	@Column(name="name", unique = true, nullable = false)
	private String name;
	
	@Column(name="surname", unique = true, nullable = false)
	private String surname;
	
	@Type(type = "com.fr.zut.model.enums.type.RoleTypeEnumType")
	@Column(nullable = false)
	private RoleTypeEnum role;

	/**
	 * Get User Name
	 * @return String - User Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set User Name
	 * @param String - User Name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get User Surname
	 * @return String - User Surname
	 */
	
	public String getSurname() {
		return surname;
	}

	/**
	 * Set User Surname
	 * @param String - User Surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}   

	public RoleTypeEnum getRole() {
		return role;
	}

	public String getRoleName() {
		return this.role.getName();
	}
	
	public void setRole(RoleTypeEnum role) {
		this.role = role;
	}

	/**
	 * Converts this object to a jsonObject
	 * @return a jsonObject that describe object.
	 * @throws JSONException
	 */
	public JSONObject toJSON() throws JSONException {
		
		JSONObject json = new JSONObject();
		
		json.put(StdWords.ID.getWord(), this.getId());
		json.put(StdWords.USER_NAME.getWord(), this.getName());
		json.put(StdWords.SURNAME.getWord(), this.getSurname());
		if (this.createdAt != null)
			json.put(StdWords.CREATED_AT.getWord(), this.getCreatedAt());
		
		return json;
	}
	
	@Override
	public String toString() {
		try {
			return this.toJSON().toString();
		} catch (JSONException e) {
			return null;
		}
	}
}
