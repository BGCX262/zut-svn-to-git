package fr.dorian.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.dorian.model.superclasses.EditableEntity;


@Entity
@Table(name="account_infos")
@NamedQueries({
	@NamedQuery(name = "AccountInfos.findByAccountId", query = "SELECT a FROM AccountInfos a WHERE a.account.id = :accountId")
})
public class AccountInfos extends EditableEntity implements Serializable
{
	private static final long serialVersionUID = 3913406174774904650L;

	//properties
	
	@Column(name="reputation")
	private Long reputation;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="account_id")
	private Account account;

	//Virtual

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("reputation=" + reputation + ", account_id=" + account.getId());
		return (buffer.toString());
	}
	
	//Accessors
	
	public Long getReputation() {return reputation;}
	public void setReputation(Long reputation) {this.reputation = reputation;}
	public Account getAccount() {return account;}
	public void setAccount(Account account) {this.account = account;}
}
