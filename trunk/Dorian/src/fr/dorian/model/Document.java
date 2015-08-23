package fr.dorian.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.apache.commons.lang.builder.ToStringBuilder;

import fr.dorian.model.superclasses.StoreableEntity;

@Entity
@Table(name = "document")
@NamedQueries({
	@NamedQuery(name = "Document.findAll",	query = "SELECT d FROM Document d"),
	@NamedQuery(name = "Document.findById",	query = "SELECT d FROM Document d WHERE d.id = :id"),
	@NamedQuery(name = "Document.findByAccount",query = "SELECT d FROM Document d WHERE d.account.id = :accountId")
})
public class Document extends StoreableEntity implements Serializable {

	private static final long serialVersionUID = 1833386414101412418L;
	
	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	// Document type : cv or other portfolio file

	// CONSTRUCTOR
	///////////////////////////////////////////////////////////////////////////////////////////////
	public Document() {
	}
	
	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	// HELPER
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", this.id)
			.append("filename", this.fileName)
			.toString();
	}
	
}
