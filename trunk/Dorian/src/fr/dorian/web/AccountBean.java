package fr.dorian.web;

import java.util.List;

import fr.dorian.model.Account;

public interface AccountBean {

	String view(Integer accountId);

	void update();

	List<Account> getNewUsers();

	boolean getEditRole();

	String registerUser();

	String viewCurrent(Integer username);

	boolean isDisplayValueOnly();

	void setDisplayValueOnly(boolean displayValueOnly);

	void goToEdition();

	void goToView();

	String getEmail();

	String getPassword();

	void setEmail(String email);

	void setPassword(String password);

	String getUsername();

	void setUsername(String username);

	String getPasswordVerifier();

	void setPasswordVerifier(String passwordVerifier);

	Account getAccount();

	void setAccount(Account account);

	boolean isEditModeActived();

	String getImageFilename();

	void setEditModeActived(boolean editModeActived);

	void setImageFilename(String imageFilename);

	Integer getAccountId();

	void setAccountId(Integer accountId);

	String close(Integer accountId);

	String open(Integer accountId);

}
