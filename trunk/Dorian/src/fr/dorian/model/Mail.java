package fr.dorian.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.dorian.model.enums.TemplateTypeEnum;
import fr.dorian.model.superclasses.BaseEntity;

@Entity
@Table(name = "mail")
@NamedQueries({
	@NamedQuery(name = "Mail.findAll",	query = "SELECT m FROM Mail m"),
	@NamedQuery(name = "Mail.findById",	query = "SELECT m FROM Mail m WHERE m.id = :id"),
	@NamedQuery(name = "Mail.findByType", query = "SELECT m FROM Mail m WHERE m.templateType = :type")
})
public class Mail extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -6660032042334640090L;
	
	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Column(name = "destination", nullable = false)
	private String destination;
	
	@Column(name = "sender", nullable = true)
	private String sender;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "template_type", nullable = false)
	private TemplateTypeEnum templateType;

	@Column(name = "object", nullable = true)
	private String object;
	
	@Column(name = "body", nullable = true)
	private String body;
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Mail() {
		super();
	}
	
	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	public String getDestination() {return destination;}
	public void setDestination(String destination) {this.destination = destination;}

	public String getSender() {return sender;}
	public void setSender(String sender) {this.sender = sender;}

	public TemplateTypeEnum getTemplateType() {return templateType;}
	public void setTemplateType(TemplateTypeEnum templateType) {this.templateType = templateType;}
	
	public String getBody() {return body;}
	public void setBody(String body) {this.body = body;}
	
	public String getObject() {return object;}
	public void setObject(String object) {this.object = object;}

	// HELPER
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", this.id)
			.append("from", this.sender)
			.append("to", this.destination)
			.append("type", this.templateType)
			.toString();
	}

}
