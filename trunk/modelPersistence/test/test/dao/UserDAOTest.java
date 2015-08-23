package test.dao;

import java.util.List;

import model.User;
import dao.UserDAO;
import dao.impl.UserDAOImpl;

public class UserDAOTest {

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
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
