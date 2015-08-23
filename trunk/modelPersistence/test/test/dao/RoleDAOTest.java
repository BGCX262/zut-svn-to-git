package test.dao;

import java.util.List;

import junit.framework.Assert;
import model.Role;
import model.enums.RoleTypeEnum;
import dao.RoleDAO;
import dao.impl.RoleDAOImpl;

public class RoleDAOTest {

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
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
		for (Role r : roles)
			System.out.println(r);
	}
	
	public RoleDAO getRoleDAO() {return roleDAO;}
	public void setRoleDAO(RoleDAO roleDAO) {this.roleDAO = roleDAO;}

}
