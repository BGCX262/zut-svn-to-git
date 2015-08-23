package test;

import java.util.List;

import junit.framework.Assert;

import model.Account;
import model.Post;
import model.Role;
import model.Tag;
import model.User;
import model.enums.RoleTypeEnum;

import dao.AccountDAO;
import dao.PostDAO;
import dao.RoleDAO;
import dao.TagDAO;
import dao.UserDAO;
import dao.impl.AccountDAOImpl;
import dao.impl.PostDAOImpl;
import dao.impl.RoleDAOImpl;
import dao.impl.TagDAOImpl;
import dao.impl.UserDAOImpl;

public class Tests {

	public class TestUserDAO {
		
		private final static String username = "toto"; 
		private final static String primaryEmail = "toto@toto.fr";
		private final static String password = "toto";
		
		private UserDAO userDAO = new UserDAOImpl();

		public void persit() {
			User user = new User();
			
			user.setUsername(username);
			user.setPrimaryEmail(primaryEmail);
			user.setPassword(password);
			
			this.userDAO.persist(user);
			System.out.println("New user insertion : " + user.getId());
		}
		
		public void findById(Integer id) {
			User user = this.userDAO.findById(id);
			System.out.println(user);
		}
		
		public void update() {
			User user = this.userDAO.findById(1);
			
			System.out.println("before update // " + user.isDeleted());
			
			user.setDeleted(true);
			this.userDAO.update(user);
			System.out.println("after 1 update // " + user.isDeleted());

			user.setDeleted(false);
			this.userDAO.update(user);
			System.out.println("after 2 update // " + user.isDeleted());
		}

		public void findAll() {
			List<User> users = this.userDAO.findAll();
			for (User u : users)
				System.out.println(u);
		}
		
		public UserDAO getUserDAO() {return userDAO;}
		public void setUserDAO(UserDAO userDAO) {this.userDAO = userDAO;}
	}

	public class TestRoleDAO {
		
		private RoleDAO roleDAO = new RoleDAOImpl();
		
		public void persit() {
			
			this.roleDAO.persist(new Role(RoleTypeEnum.ROLE_SUPERVISOR));
			this.roleDAO.persist(new Role(RoleTypeEnum.ROLE_TELLER));
			this.roleDAO.persist(new Role(RoleTypeEnum.ROLE_USER));
		}
		
		public void findById() {
			Role role = this.roleDAO.findById(1);
			
			Assert.assertNotNull(role);
			Assert.assertSame(1, role.getId());
			
			System.out.println(role);
		}
		
		public void update() {
			Role role = this.roleDAO.findById(1);
			
			System.out.println("before update // " + role.isDeleted());
			
			role.setDeleted(true);
			this.roleDAO.update(role);
			System.out.println("after 1 update // " + role.isDeleted());
			
			role.setDeleted(false);
			this.roleDAO.update(role);
			System.out.println("after 2 update // " + role.isDeleted());
		}
		
		public void findAll() {
			List<Role> roles = this.roleDAO.findAll();
			for (Role r : roles) {
				System.out.println(r);
				System.out.println(r.getAccounts());
			}
			
		}
		
		public RoleDAO getRoleDAO() {return roleDAO;}
		public void setRoleDAO(RoleDAO roleDAO) {this.roleDAO = roleDAO;}
	}

	public class TestAccountDAO {
		
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
	
	public class TestPostDAO {
		
		private AccountDAO accountDAO = new AccountDAOImpl();
		private PostDAO postDAO = new PostDAOImpl();
		
		public void persit() {
			
			Account item = this.accountDAO.findById(1);
			Post post = new Post(item, "ceci est un commentaire de test");
			
			this.postDAO.persist(post);
		}
		
		public void findById() {
			Post item = this.postDAO.findById(1);
			
			Assert.assertNotNull(item);
			Assert.assertSame(1, item.getId());
			
			System.out.println(item);
		}
		
		public void testUpdate() {
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
			List<Post> accounts = this.postDAO.findAll();
			for (Post p : accounts) {
				System.out.println(p);
			}
		}
	}
	
	public class TestTagDAO {
		
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
	}
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestUserDAO testUserDAO = new Tests().new TestUserDAO();
		TestRoleDAO testRoleDAO = new Tests().new TestRoleDAO();
		TestAccountDAO testAccountDAO = new Tests().new TestAccountDAO();
		TestPostDAO testPostDAO = new Tests().new TestPostDAO();
		TestTagDAO testTagDAO = new Tests().new TestTagDAO();
		
		
		//testUserDAO.persit();
		testUserDAO.findAll();
		//testUserDAO.update();
		//testUserDAO.findById(1);
		
		//testRoleDAO.persit();
		testRoleDAO.findAll();
		testRoleDAO.update();
		
		//testAccountDAO.persit();
		testAccountDAO.findAll();
	
		//testPostDAO.persit();
		testPostDAO.findAll();
		
		//testTagDAO.persit();
		testTagDAO.findAll();
		//testTagDAO.update();
	}

}
