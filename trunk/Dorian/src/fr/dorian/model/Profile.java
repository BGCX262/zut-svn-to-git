package fr.dorian.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.dorian.model.superclasses.EditableEntity;

@Entity
@Table(name = "profile")
@NamedQueries({
	@NamedQuery(name = "Profile.findAll",	query = "SELECT p FROM Profile p"),
	@NamedQuery(name = "Profile.findById",	query = "SELECT p FROM Profile p WHERE p.id = :id"),
	@NamedQuery(name = "Profile.findByAccount",query = "SELECT p FROM Profile p WHERE p.account.id = :accountId")
})
public class Profile extends EditableEntity implements Serializable {

	private static final long serialVersionUID = -6187716969647503187L;

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////

	@OneToOne
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;
	
	@Column(name = "web_site", nullable = true)
	private String webSite;
	
	@Column(name = "company", nullable = true)
	private String company;
	
	@Column(name = "phone_number", nullable = true)
	private String phoneNumber;
	
	@Column(name = "birth_day", nullable = true)
	private Date birthDay;
	
	@Column(name = "job", nullable = true)
	private String job;
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Profile() {		
	}
	
	public Profile(Account account) {
		this.setAccount(account);
	}
	
	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	

	public Account getAccount() {return account;}
	public void setAccount(Account account) {this.account = account;}
	
	public String getWebSite() {return webSite;}
	public void setWebSite(String webSite) {this.webSite = webSite;}
	
	public String getCompany() {return company;}
	public void setCompany(String company) {this.company = company;}
	
	public String getPhoneNumber() {return this.phoneNumber;}
	public void setPhoneNumber(String number) {this.phoneNumber = number;}
	
	public Date getBirthDay() {return birthDay;}
	public void setBirthDay(Date birthDay) {this.birthDay = birthDay;}
	
	public String getJob() {return this.job;}
	public void setJob(String job) {this.job = job;}
	
	// HELPER
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", this.id)
			.toString();
	}
}
