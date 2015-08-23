package test.dao;

import java.util.List;

import junit.framework.Assert;
import model.Account;
import model.User;
import model.enums.RoleTypeEnum;
import dao.AccountDAO;
import dao.RoleDAO;
import dao.UserDAO;
import dao.impl.AccountDAOImpl;
import dao.impl.RoleDAOImpl;
import dao.impl.UserDAOImpl;

public class AccountDAOTest {

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	private AccountDAO accountDAO = new AccountDAOImpl();
	private UserDAO userDAO = new UserDAOImpl();
	private RoleDAO roleDAO = new RoleDAOImpl();

	public void persit() {
		Account item = new Account();

		User user = this.userDAO.findById(1);
		Assert.assertNotNull(user);

		item.setOwner(user);
		item.addRole(this.roleDAO.findByName(RoleTypeEnum.ROLE_SUPERVISOR.name()));
		item.addRole(this.roleDAO.findByName(RoleTypeEnum.ROLE_USER.name()));
		item.addRole(this.roleDAO.findByName(RoleTypeEnum.ROLE_TELLER.name()));

		this.accountDAO.persist(item);
		Assert.assertNotNull(item.getId());
	}

	public void findById() {
		Account item = this.accountDAO.findById(1);

		Assert.assertNotNull(item);
		Assert.assertSame(1, item.getId());

		System.out.println(item);
	}

	public void testUpdate() {
		Account item = this.accountDAO.findById(1);

		System.out.println("before update // " + item.isDeleted());

		item.setDeleted(true);
		this.accountDAO.update(item);
		System.out.println("after 1 update // " + item.isDeleted());

		item.setDeleted(false);
		this.accountDAO.update(item);
		System.out.println("after 2 update // " + item.isDeleted());
	}

	public void findAll() {
		List<Account> accounts = this.accountDAO.findAll();
		for (Account a : accounts) {
			System.out.println(a);
			System.out.println(a.getRoles());
		}
	}
}
