package fr.dorian.business;

import java.util.List;

import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import fr.dorian.model.Attachment;
import fr.dorian.service.exception.ServiceException;

public interface AttachmentBO {

	Attachment simpleAttach(UploadedFile file, Integer accountId, Integer postId,
			String description, boolean downloadable, boolean visible) throws ServiceException;

	List<Attachment> findByPostId(Integer postId) throws ServiceException;

	List<Attachment> findByAccountId(Integer accountId) throws ServiceException;

	StreamedContent download(Integer attachmentId) throws ServiceException;

	void persist(Attachment attachment) throws ServiceException;

	List<Attachment> findByTutorialId(Integer tutorialId) throws ServiceException;

}
