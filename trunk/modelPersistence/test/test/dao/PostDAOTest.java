package test.dao;

import java.util.List;

import junit.framework.Assert;
import model.Account;
import model.Post;
import model.Thread;
import dao.AccountDAO;
import dao.PostDAO;
import dao.ThreadDAO;
import dao.impl.AccountDAOImpl;
import dao.impl.PostDAOImpl;
import dao.impl.ThreadDAOImpl;

public class PostDAOTest {

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	private PostDAO postDAO = new PostDAOImpl();
	private AccountDAO accountDAO = new AccountDAOImpl();
	private ThreadDAO threadDAO = new ThreadDAOImpl(); 

	public void persit() {
		Account account = this.accountDAO.findById(1);
		
		Thread thread = new Thread(account, "Thread created for new Post");
		this.threadDAO.persist(thread);
		
		Post post = new Post(account, thread, "ceci est un commentaire de test");

		this.postDAO.persist(post);
	}

	public void findById() {
		Post item = this.postDAO.findById(1);

		Assert.assertNotNull(item);
		Assert.assertSame(1, item.getId());

		System.out.println(item);
	}

	public void update() {
		Post item = this.postDAO.findById(1);

		System.out.println("before update // " + item.isDeleted());

		item.setDeleted(true);
		this.postDAO.update(item);
		System.out.println("after 1 update // " + item.isDeleted());

		item.setDeleted(false);
		this.postDAO.update(item);
		System.out.println("after 2 update // " + item.isDeleted());
	}

	public void findAll() {
		List<Post> posts = this.postDAO.findAll();
		for (Post p : posts) {
			System.out.println(p);
		}
	}
	
	public void findByThread() {
		Thread thread = this.threadDAO.findById(1);
		
		List<Post> posts = this.postDAO.findByThread(thread);
		for (Post p : posts) {
			System.out.println(p);
		}
	}
	
}
