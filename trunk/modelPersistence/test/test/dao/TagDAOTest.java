package test.dao;

import java.util.List;

import junit.framework.Assert;
import model.Account;
import model.Tag;
import dao.AccountDAO;
import dao.TagDAO;
import dao.impl.AccountDAOImpl;
import dao.impl.TagDAOImpl;

public class TagDAOTest {

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	private TagDAO tagDAO = new TagDAOImpl();
	private AccountDAO accountDAO = new AccountDAOImpl();

	public void persit() {

		Account account = this.accountDAO.findById(1);
		Tag tag = new Tag("Test-title", account, "description test");

		this.tagDAO.persist(tag);
	}

	public void findById() {
		Tag item = this.tagDAO.findById(1);

		Assert.assertNotNull(item);
		Assert.assertSame(1, item.getId());

		System.out.println(item);
	}

	public void update() {
		Tag item = this.tagDAO.findById(1);

		System.out.println("before update // " + item.isDeleted());

		item.setDeleted(true);
		this.tagDAO.update(item);
		System.out.println("after 1 update // " + item.isDeleted());

		item.setDeleted(false);
		this.tagDAO.update(item);
		System.out.println("after 2 update // " + item.isDeleted());
	}

	public void findAll() {
		List<Tag> accounts = this.tagDAO.findAll();
		for (Tag t : accounts) {
			System.out.println(t);
		}
	}
	
	public void addChildAndUpdate() {
		Tag parent = this.tagDAO.findById(1);
		System.out.println("before // " + parent);
		
		// Create child
		Account account = this.accountDAO.findById(1);
		Tag child = new Tag("Test-title-child", account, "description test for child");
		this.tagDAO.persist(child);

		parent.addChildTag(child);
		
		this.tagDAO.update(parent);
		System.out.println("after // " + parent);
	}
}
