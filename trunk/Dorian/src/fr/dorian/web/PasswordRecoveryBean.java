package fr.dorian.web;

public interface PasswordRecoveryBean {

	String edit();

	String recover();

	/**
	 * Save new password after changed
	 * @return
	 */
	String save();

	String getData();

	void setData(String password);

	String getNewPassword();

	void setNewPassword(String newPassword);

	String getNewPasswordVerifier();

	void setNewPasswordVerifier(String newPasswordVerifier);

	boolean isRendered();

	void setRendered(boolean displayOnly);

	String send();

	void setCaptcha(String captcha);

	String getCaptcha();

	String getEmail();

	void setEmail(String email);

	String getToken();

	void setToken(String token);

}
