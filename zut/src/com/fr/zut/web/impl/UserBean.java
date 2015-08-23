package com.fr.zut.web.impl;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;

import com.fr.zut.business.def.IUserBO;
import com.fr.zut.business.exception.BusinessException;
import com.fr.zut.model.User;
import com.fr.zut.model.enums.RoleTypeEnum;
import com.fr.zut.web.def.IUserBean;

@ViewScoped
@ManagedBean(name="userMB")
@RequestScoped
public class UserBean implements Serializable, IUserBean {

	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(UserBean.class);
	
	private static final String SUCCESS = "success";
    private static final String ERROR   = "error";
    
    //Spring User Service is injected...
    @ManagedProperty(value="#{userBO}")
    IUserBO userBO;
 
    private String name;
    private String surname;
    private User selectedUser;
    private RoleTypeEnum role;
    
    public UserBean() {
    	super();
	}
    
    /**
     * Add User
     * @return String - Response Message
     */
    public String addUser() {
    	log.debug("add user");
        try {
            User user = new User();
            user.setName(getName());
            user.setSurname(getSurname());
            user.setRole(getRole());
            getUserBO().addUser(user);
            return SUCCESS;
        } catch (DataAccessException e) {
            log.error("Add user fail / DataAccessException", e);
        } catch (BusinessException e) {
			log.error("Add user fail / BusinessException", e);
		}   
        return ERROR;
    }
 
    public RoleTypeEnum[] getRoles() {
    	log.debug("get roles");
    	return RoleTypeEnum.values();
    }
    
    public void handleRoleChange() {
    	log.debug("handle role change");  
    }
    
    /**
     * Reset Fields
     */
    public void reset() {
        this.setName("");
        this.setSurname("");
    }
 
    /**
     * Get User List
     * @return List - User List
     */
    public List<User> getUserList() {
    	log.info("get user list");
        return this.userBO.getUsers();
    }
 
    /**
     * Get User Service
     * @return IUserBO - User Service
     */
    public IUserBO getUserBO() {
        return userBO;
    }
 
    /**
     * Set User Service
     * @param IUserBO - User Service
     */
    public void setUserBO(IUserBO userBO) {
        this.userBO = userBO;
    }
  
    /**
     * Get User Name
     * @return String - User Name
     */
    public String getName() {
        return name;
    }
 
    /**
     * Set User Name
     * @param String - User Name
     */
    public void setName(String name) {
        this.name = name;
    }
 
    /**
     * Get User Surname
     * @return String - User Surname
     */
    public String getSurname() {
        return surname;
    }
 
    /**
     * Set User Surname
     * @param String - User Surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	public RoleTypeEnum getRole() {
		return role;
	}

	public void setRole(RoleTypeEnum role) {
		this.role = role;
	}
}
