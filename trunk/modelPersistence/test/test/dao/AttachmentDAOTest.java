package test.dao;

import java.util.List;

import store.FileStore;
import test.util.ComponentException;

import junit.framework.Assert;
import model.Attachment;
import model.Post;
import dao.AttachmentDAO;
import dao.PostDAO;
import dao.impl.AttachmentDAOImpl;
import dao.impl.PostDAOImpl;

public class AttachmentDAOTest {

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	private AttachmentDAO attachmentDAO = new AttachmentDAOImpl(); 
	private PostDAO postDAO = new PostDAOImpl();

	public void persit(byte[] data) {
		
		Post post = this.postDAO.findById(1);
		
		Attachment attachment = new Attachment();
		attachment.setVisible(true);
		attachment.setDescription("description");
		attachment.setFileName("fileName");
		attachment.setPost(post);
		attachment.setContentType("contentType");
		
		FileStore fileStore = new FileStore();
		
		try {
			attachment.setFileUUID(fileStore.store(data));
		} catch (ComponentException e) {
			e.printStackTrace();
		}
		System.out.println(attachment);
		this.attachmentDAO.persist(attachment);
		
		post.addAttachment(attachment);
		this.postDAO.update(post);
	}

	public void findById() {
		Attachment item = this.attachmentDAO.findById(1);

		Assert.assertNotNull(item);
		Assert.assertSame(1, item.getId());

		System.out.println(item);
	}

	/*public void update() {
		Post item = this.postDAO.findById(1);

		System.out.println("before update // " + item.isDeleted());

		item.setDeleted(true);
		this.postDAO.update(item);
		System.out.println("after 1 update // " + item.isDeleted());

		item.setDeleted(false);
		this.postDAO.update(item);
		System.out.println("after 2 update // " + item.isDeleted());
	}
*/
	public void findAll() {
		List<Attachment> attachments = this.attachmentDAO.findAll();
		for (Attachment a : attachments) {
			System.out.println(a);
		}
	}	
}
