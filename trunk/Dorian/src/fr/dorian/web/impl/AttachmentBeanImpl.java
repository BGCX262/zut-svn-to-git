package fr.dorian.web.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import fr.dorian.business.AttachmentBO;
import fr.dorian.model.Attachment;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.web.AttachmentBean;
import fr.dorian.web.security.AccountContext;
import fr.dorian.web.security.Secure;

@Scope("session")
@Controller("attachmentBean")
public class AttachmentBeanImpl implements AttachmentBean, Serializable {

	private static final long serialVersionUID = -3219749149358840428L;

	private static final Logger logger = Logger.getLogger(AttachmentBean.class);
	
	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	private AttachmentBO attachmentBO;
	
	@Autowired
	private AccountContext accountContext;

	private String filename; // image or other
	private String description;
	private boolean visible;
	private boolean downloadable;
	private UploadedFile file;
	private List<Attachment> attachments;
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	// OVERRIDES
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	@Secured(Secure.ROLE_USER)
	public Attachment upload() {
		logger.debug("handle file upload");
		try {
			Integer accountId = 1;
			Integer postId = 1;
			System.out.println("descr=" + description + ", down=" + this.downloadable + ", visbility=" + visible);
			Attachment attachment = this.attachmentBO.simpleAttach(this.file, accountId, postId, this.description, this.downloadable, this.visible);
			return attachment;
		} catch (ServiceException e) {
			logger.error("failed to attach file", e);
		}
		return null;
	}
	
	@Override
	@Secured(Secure.ROLE_USER)
	public void attachTemp() {
		logger.debug("attach");
		try {
			if (this.file == null)
				return; // Display error
			
			Attachment attachment = new Attachment();
			attachment.setDownloadable(downloadable);
			attachment.setDescription(description);
			attachment.setVisible(visible);
			attachment.setFile(file);
			attachment.setFileName(this.file.getFileName());
			attachment.setContentType(this.file.getContentType());
			// set post, account after
			
			if (this.attachments == null)
				this.attachments = new ArrayList<Attachment>();
			this.attachments.add(attachment);
		} catch (Exception e) {
			logger.debug("attach failed", e);
		}
	}
	
	@Override
	public boolean hasAttachment() {
		if (this.attachments == null || attachments.isEmpty())
			return false;
		return true;
	}
	
	@Override
	public List<Attachment> getAttachments(Integer postId) {
		logger.debug("get post attachments");
		try {
			return this.attachmentBO.findByPostId(postId);
		} catch (ServiceException e) {
			logger.error("get post attachments failed", e);
		}
		return null;
	}
	
	@Override
	@Secured(Secure.ROLE_USER)
	public StreamedContent download(Integer attachmentId) {
		logger.debug("download");
		try {
			return this.attachmentBO.download(attachmentId);
		} catch (Exception e) {
			logger.error("download failed", e);
		}
		return null;
	}
	
	// ACCESSORS AND OVERRIDES
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String getFilename() {return filename;}
	@Override
	public void setFilename(String filename) {this.filename = filename;}
	@Override
	public String getDescription() {return description;}
	@Override
	public void setDescription(String description) {this.description = description;}

	@Override
	public boolean isVisible() {return visible;}
	@Override
	public void setVisible(boolean visible) {this.visible = visible;}
	
	@Override
	public boolean isDownloadable() {return downloadable;}
	@Override
	public void setDownloadable(boolean downloadable) {this.downloadable = downloadable;}

	@Override
	public UploadedFile getFile() {return file;}
	@Override
	public void setFile(UploadedFile file) {this.file = file;}

	@Override
	public List<Attachment> getAttachments() {return attachments;}
	@Override
	public void setAttachments(List<Attachment> attachments) {this.attachments = attachments;}

}
