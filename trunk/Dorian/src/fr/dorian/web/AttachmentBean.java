package fr.dorian.web;

import java.util.List;

import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import fr.dorian.model.Attachment;

public interface AttachmentBean {

	String getFilename();

	void setFilename(String filename);

	String getDescription();

	void setDescription(String description);

	boolean isVisible();

	void setVisible(boolean visible);

	boolean isDownloadable();

	void setDownloadable(boolean downloadable);

	Attachment upload();

	UploadedFile getFile();

	void setFile(UploadedFile file);

	List<Attachment> getAttachments(Integer postId);

	StreamedContent download(Integer attachmentId);

	List<Attachment> getAttachments();

	void setAttachments(List<Attachment> attachments);

	void attachTemp();

	boolean hasAttachment();

}
