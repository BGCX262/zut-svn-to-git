package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;

import model.superclasses.BaseEntity;

@Entity
@Table(name = "attachment")
@NamedQueries({
	@NamedQuery(name = "Attachment.findAll",	query = "SELECT a FROM Attachment a "),
	@NamedQuery(name = "Attachment.findById",	query = "SELECT a FROM Attachment a WHERE a.id = :id")
})
public class Attachment extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 3861512482576048497L;

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Column(name = "file_name", nullable = false)
	private String fileName;
	
	@Column
	private String description;
	
	@Column(name = "file_uuid", nullable = false, unique = true)
	private String fileUUID;
	
	@Column(name = "content_type", nullable = false)
	private String contentType;

	@ManyToOne
	@JoinColumn(name = "post_id", nullable = false)
	private Post post;
	
	@Column
	private boolean visible;
	
	@Transient
	private byte[] data;
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	public Attachment() {
		super();
	}

	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	public Post getPost() {
		return post;
	}
	
	public void setPost(Post post) {
		this.post = post;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getFileUUID() {
		return fileUUID;
	}

	public void setFileUUID(String fileUUID) {
		this.fileUUID = fileUUID;
	}

	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
	
	public String getContentType() {return contentType;}
	public void setContentType(String contentType) {this.contentType = contentType;}

	// HELPER
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", this.id)
			.append("filename", this.fileName)
			.append("post", this.post)
			.toString();
	}
}
