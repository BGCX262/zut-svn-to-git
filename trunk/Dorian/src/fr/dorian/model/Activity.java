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

import fr.dorian.model.enums.ActivityCommandEnum;
import fr.dorian.model.superclasses.BaseEntity;

@Entity
@Table(name = "activity")
@NamedQueries({
	@NamedQuery(name = "Activity.findAll",	query = "SELECT a FROM Activity a ORDER BY a.id DESC"),
	@NamedQuery(name = "Activity.findById",	query = "SELECT a FROM Activity a WHERE a.id = :id"),
	@NamedQuery(name = "Activity.findByAccount",	query = "SELECT a FROM Activity a WHERE a.account.id = :accountId ORDER BY a.id DESC")
})
// findLastForThread(Thread t)
// findLastForAccount(Account a)
// findLast (10 last activity)
public class Activity extends BaseEntity implements Serializable, Comparable<Activity> {

	private static final long serialVersionUID = -8579370025673161202L;
	
	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@ManyToOne
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;
	
	@ManyToOne
	@JoinColumn(name = "thread_id", nullable = false)
	private Thread thread;
	
	@Column(nullable = false)
	private String command;
	
	@Column(nullable = true)
	private String param;

	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Activity() {
		super();
	}
	
	public Activity(Account account, Thread thread, ActivityCommandEnum command, String param) {
		this.setAccount(account);
		this.setThread(thread);
		this.setCommand(command.getCommand());
		this.setParam(param);
	}
	
	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	public Account getAccount() {return account;}
	public Thread getThread() {return thread;}

	public void setAccount(Account account) {this.account = account;}
	public void setThread(Thread thread) {this.thread = thread;}
	
	public String getCommand() {return command;}
	public void setCommand(String command) {this.command = command;}
	
	public String getParam() {return param;}
	public void setParam(String param) {this.param = param;}
	
	// HELPER
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", this.id)
			.append("command", this.command)
			.toString();
	}

	@Override
	public int compareTo(Activity o) {
		return o.getId().compareTo(this.id);
	}
}
