package test.dao;

import java.util.List;

import junit.framework.Assert;
import model.Account;
import model.Post;
import model.Tag;
import model.Thread;
import dao.AccountDAO;
import dao.PostDAO;
import dao.TagDAO;
import dao.ThreadDAO;
import dao.impl.AccountDAOImpl;
import dao.impl.PostDAOImpl;
import dao.impl.TagDAOImpl;
import dao.impl.ThreadDAOImpl;

public class ThreadDAOTest {

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	private ThreadDAO threadDAO = new ThreadDAOImpl();
	private AccountDAO accountDAO = new AccountDAOImpl();
	private PostDAO postDAO = new PostDAOImpl();
	private TagDAO tagDAO = new TagDAOImpl();

	public void persitWithoutTagAndPost() {
		Account account = this.accountDAO.findById(1);
		Thread thread = new Thread(account, "Thread title created without post and tag");
		
		this.threadDAO.persist(thread);
	}

	public void persitWithTagWithoutPost() {
		Account account = this.accountDAO.findById(1);
		
		Thread thread = new Thread(account, "Thread title created with tags C++ without post");
		
		Tag tag = new Tag("C++", account, "C++ category");
		this.tagDAO.persist(tag);
		Tag tagDb = this.tagDAO.findById(1);
		
		thread.addTag(tag);
		thread.addTag(tagDb);
		
		this.threadDAO.persist(thread);
	}

	public void persitWithTagAndPost() {
		Account account = this.accountDAO.findById(1);
		
		Thread thread = new Thread(account, "Thread title created with tags (1, Java) and post");
		
		Tag tag = new Tag("Java", account, "Java category");
		this.tagDAO.persist(tag);
		Tag tagDb = this.tagDAO.findById(1);
		
		thread.addTag(tag);
		thread.addTag(tagDb);
		
		this.threadDAO.persist(thread);

		Post post = new Post(account, thread, "Je code java, je fait la Java");
		this.postDAO.persist(post);
		
		thread.addPost(post);
		
		this.threadDAO.update(thread);
	}
	
	public void findById() {
		Thread item = this.threadDAO.findById(1);

		Assert.assertNotNull(item);
		Assert.assertSame(1, item.getId());

		System.out.println(item);
	}

	public void update() {
		Thread item = this.threadDAO.findById(1);

		System.out.println("before update // " + item.isDeleted());

		item.setDeleted(true);
		this.threadDAO.update(item);
		System.out.println("after 1 update // " + item.isDeleted());

		item.setDeleted(false);
		this.threadDAO.update(item);
		System.out.println("after 2 update // " + item.isDeleted());
	}

	public void findAll() {
		List<Thread> threads = this.threadDAO.findAll();
		for (Thread t : threads) {
			System.out.println(t);
		}
	}
}
