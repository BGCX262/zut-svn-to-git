package model.superclasses;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class EditableEntity extends BaseEntity {
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_at", insertable = false, updatable = true, nullable = true)
	private Date modifiedAt;

	public Date		getModifiedAt()				{return this.modifiedAt;}
	public void		setModifiedAt(Date date)	{this.modifiedAt = date;}

	@Override
	public void preUpdate() {
		super.preUpdate();
		this.modifiedAt = Calendar.getInstance().getTime();
	}
}
