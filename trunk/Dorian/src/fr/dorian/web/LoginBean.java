package fr.dorian.web;

import java.io.IOException;

public interface LoginBean {
	String doLogin() throws IOException, Exception;

	public String getPassword();
	public String getUsername();
	public boolean isRememberMe();

	public void setPassword(String password);
	public void setUsername(String userId);
	public void setRememberMe(boolean rememberMe);

	public String getEmail();

	boolean isLogged();

	String getDisplayName();

	void setEmail(String email);

	String goToRegistrationPage();
}
