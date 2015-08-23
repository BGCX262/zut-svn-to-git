package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import model.superclasses.BaseEntity;

@Entity
@Table(name = "activity")
public class Activity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -8579370025673161202L;
	
	// Properties
	@ManyToOne
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;
	
	@ManyToOne
	@JoinColumn(name = "thread_id", nullable = false)
	private Thread thread;

	// Accessors
	public Account getAccount() {
		return account;
	}

	public Thread getThread() {
		return thread;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}
	
	

}
