package fr.dorian.service.dao;

import fr.dorian.model.AccountActivation;
import fr.dorian.model.User;

public interface AccountActivationDAO extends IDAO<AccountActivation> {

	/**
	 * Loads an {@link AccountActivation} by code;
	 * @param code - Activation code stored in database
	 * @return new {@link AccountActivation} contains code; otherwise null {@link AccountActivation} is returned.
	 */
	AccountActivation findByCode(String code);

	/**
	 * Loads an {@link AccountActivation} by user.
	 * <br> Note: Only the user id is used.
	 * @param user - Activation user stored in database
	 * @return new {@link AccountActivation} contains user; otherwise null {@link AccountActivation} is returned.
	 */
	AccountActivation findByUser(User user);

}
