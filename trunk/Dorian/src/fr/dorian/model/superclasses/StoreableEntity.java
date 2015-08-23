package fr.dorian.model.superclasses;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import fr.dorian.model.Account;

@MappedSuperclass
public abstract class StoreableEntity extends EditableEntity {
	
	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Column(name = "file_name", nullable = false)
	protected String fileName;
	
	@Column(name = "file_uuid", nullable = false, unique = true)
	protected String fileUUID;
	
	@Column(name = "content_type", nullable = false)
	protected String contentType;
	
	@Column(name = "description", nullable = true)
	protected String description;
	
	@ManyToOne
	@JoinColumn(name = "account_id", nullable = false)
	protected Account account;
	
	@Column(name = "downloadable")
	protected boolean downloadable;
	
	@Column(name = "visible")
	private boolean visible;
	
	@Transient
	protected byte[] data;
	
	// CONSTRUCTOR
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public StoreableEntity() {
	}
	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getFileName() {return fileName;}
	public void setFileName(String fileName) {this.fileName = fileName;}

	public String getFileUUID() {return fileUUID;}
	public void setFileUUID(String fileUUID) {this.fileUUID = fileUUID;}

	public String getContentType() {return contentType;}
	public void setContentType(String contentType) {this.contentType = contentType;}

	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}

	public Account getAccount() {return account;}
	public void setAccount(Account account) {this.account = account;}

	public boolean isDownloadable() {return downloadable;}
	public void setDownloadable(boolean downloadable) {this.downloadable = downloadable;}

	public boolean isVisible() {return visible;}
	public void setVisible(boolean visible) {this.visible = visible;}
	
	public byte[] getData() {return data;}
	public void setData(byte[] data) {this.data = data;}
}
