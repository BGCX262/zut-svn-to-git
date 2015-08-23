package fr.dorian.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.dorian.model.superclasses.EditableEntity;

@Entity
@Table(name = "address")
@NamedQueries({
	@NamedQuery(name = "Address.findAll",	query = "SELECT a FROM Address a"),
	@NamedQuery(name = "Address.findById",	query = "SELECT a FROM Address a WHERE a.id = :id"),
	@NamedQuery(name = "Address.findByAccount",query = "SELECT a FROM Address a WHERE a.account.id = :accountId")
})
public class Address extends EditableEntity implements Serializable {

	private static final long serialVersionUID = 4904164389118174899L;

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////

	@ManyToOne
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;
	
	@Column(name = "street_number", nullable = true)
	private String streetNumber;
	
	@Column(name = "street_name", nullable = true)
	private String streetName;
	
	@Column(name = "city", nullable = true)
	private String city;
	
	@Column(name = "zip_code", nullable = true)
	private String zipCode;
	
	@Column(name = "country", nullable = true)
	private String 	country;
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Address() {
	}
	
	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Account getAccount() {return account;}
	public void setAccount(Account account) {this.account = account;}

	public String getStreetNumber() {return streetNumber;}
	public void setStreetNumber(String streetNumber) {this.streetNumber = streetNumber;}

	public String getStreetName() {return streetName;}
	public void setStreetName(String streetName) {this.streetName = streetName;}

	public String getCity() {return city;}
	public void setCity(String city) {this.city = city;}

	public String getZipCode() {return zipCode;}
	public void setZipCode(String zipCode) {this.zipCode = zipCode;}

	public String getCountry() {return country;}
	public void setCountry(String country) {this.country = country;}
	
	// HELPER
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", this.id)
			.toString();
	}
}
