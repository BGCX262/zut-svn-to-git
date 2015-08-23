package fr.dorian.business.impl;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import fr.dorian.business.AttachmentBO;
import fr.dorian.model.Account;
import fr.dorian.model.Attachment;
import fr.dorian.model.Post;
import fr.dorian.model.Tutorial;
import fr.dorian.service.dao.AccountDAO;
import fr.dorian.service.dao.AttachmentDAO;
import fr.dorian.service.dao.PostDAO;
import fr.dorian.service.dao.TutorialDAO;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.service.store.ObjectStore;
import fr.dorian.service.store.StoreException;

@Service
@Scope("session")
public class AttachmentBOImpl implements AttachmentBO, Serializable {

	private static final long serialVersionUID = -2829352434959524845L;

	private static final Logger logger = Logger.getLogger(AttachmentBO.class);
	
	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Autowired
	private AttachmentDAO attachmentDAO;
	
	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private ObjectStore objectStore;
	
	@Autowired
	private TutorialDAO tutorialDAO;
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void persist(Attachment attachment) throws ServiceException {
		logger.debug("persist");
		try {
			if (attachment == null)
				throw ServiceException.INVALID_REQUEST;
			
			this.attachmentDAO.persist(attachment);
		} catch (Exception e) {
			throw new ServiceException("persist failed", e);
		}
	}
	
	
	@Override
	public Attachment simpleAttach(UploadedFile file, Integer accountId, Integer postId, String description, boolean downloadable, boolean visible) throws ServiceException {
		logger.debug("simple attach");
		try {

			if (file == null || accountId == null || postId == null)
				throw ServiceException.INVALID_REQUEST;

			Account account = this.accountDAO.findById(accountId);
			if (account == null)
				throw ServiceException.INVALID_REQUEST;			
			
			Post post = this.postDAO.findById(postId);
			if (post == null)
				throw ServiceException.INVALID_REQUEST;
			
			if (post.getThread().isClosed())
				throw new ServiceException("Thread is closed");
			
			Attachment attachment = new Attachment();	
			attachment.setAccount(account);
			attachment.setVisible(visible);
			attachment.setDownloadable(downloadable);
			if (description == null || description.isEmpty())
				description = Attachment.NO_DESCRIPTION;
			attachment.setDescription(description);
			attachment.setFileName(file.getFileName());
			attachment.setContentType(file.getContentType());
			attachment.setPost(post);

			try {
				String uuid = this.objectStore.store(file.getContents());
				attachment.setFileUUID(uuid);
			} catch (StoreException storeException) {
				throw new ServiceException("Stored failed", storeException);
			}
			this.attachmentDAO.persist(attachment);
			return attachment;
		} catch (Exception e) {
			throw new ServiceException("Internal Error", e);
		}
	}
	
	@Override
	public List<Attachment> findByPostId(Integer postId) throws ServiceException {
		logger.debug("find by post id");
		try {
			if (postId == null)
				throw ServiceException.INVALID_REQUEST;
			
			Post post = this.postDAO.findById(postId);
			if (post == null)
				throw ServiceException.INVALID_REQUEST;
			
			return this.attachmentDAO.findByPost(post);
		} catch (Exception e) {
			throw new ServiceException("Internal Error", e);
		}
	}
	
	@Override
	public List<Attachment> findByAccountId(Integer accountId) throws ServiceException {
		logger.debug("find by account id");
		try {
			if (accountId == null)
				throw ServiceException.INVALID_REQUEST;
			
			Account account = this.accountDAO.findById(accountId); 
			if (account == null)
				throw ServiceException.INVALID_REQUEST;
				
			return this.attachmentDAO.findByAccount(account);
		} catch (Exception e) {
			throw new ServiceException("Internal Error", e);
		}
	}

	@Override
	public List<Attachment> findByTutorialId(Integer tutorialId) throws ServiceException {
		logger.debug("find by tutorial id");
		try {
			if (tutorialId == null)
				throw ServiceException.INVALID_REQUEST;
			
			Tutorial tutorial = this.tutorialDAO.findById(tutorialId); 
			if (tutorial == null)
				throw ServiceException.INVALID_REQUEST;
			
			return this.attachmentDAO.findByTutorial(tutorial);
		} catch (Exception e) {
			throw new ServiceException("Internal Error", e);
		}
	}

	@Override
	public StreamedContent download(Integer attachmentId)
			throws ServiceException {
		logger.debug("download");
		try {
			if (attachmentId == null)
				throw ServiceException.INVALID_REQUEST;

			Attachment attachment = this.attachmentDAO.findById(attachmentId);
			if (attachment == null)
				throw ServiceException.INVALID_REQUEST;
			
			InputStream stream = this.objectStore.getObjectAsInputStream(attachment.getFileUUID());
			StreamedContent content = new DefaultStreamedContent(stream, attachment.getContentType(), attachment.getFileName());
			return content;
		} catch (Exception e) {
			throw new ServiceException("Internal Error", e);
		}
	}
}
