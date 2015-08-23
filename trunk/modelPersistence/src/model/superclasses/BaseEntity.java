package model.superclasses;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * This is the base of all model object to persist in database.
 * <br>Model object would extend BaseEntity if model object contains the following properties:
 * <br>-<strong> Id </strong> - Object id
 * <br>-<strong> createdAt </strong> - Creation date
 * <br>-<strong> deleted </strong> - Don't remove entity, just change stage.
 * @author KONE
 */
@MappedSuperclass
public abstract class BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	protected Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", insertable = true, updatable = false, nullable = true)
	protected Date createdAt;
	
	@Column(name = "deleted", insertable = true, updatable = true, nullable = false)
	protected boolean deleted;
	
	public Integer	getId()					{return this.id;}
	public void		setId(Integer id)		{this.id = id;}

	public Date		getCreatedAt()			{return this.createdAt;}
	public void		setCreatedAt(Date date)	{this.createdAt = date;}
	
	public boolean	isDeleted()				{return this.deleted;}
	public void		setDeleted(boolean del)	{this.deleted = del;}

	public void prePersist() {
		this.createdAt = Calendar.getInstance().getTime();
		this.deleted = false;
	}

	public void postPersist()	{}
	public void preUpdate()		{}
	public void postUpdate()	{}
	public void preRemove()		{}
	public void postRemove()	{}
	
	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if(!this.getClass().isInstance(obj))
			return false;

		Integer objId = ((BaseEntity) obj).getId();

		if (this.id == null || objId == null)
			return false;

		return this.id.equals(objId);
	}
}
