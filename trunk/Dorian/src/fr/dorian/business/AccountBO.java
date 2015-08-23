package fr.dorian.business;

import java.util.List;

import fr.dorian.model.Account;
import fr.dorian.model.User;
import fr.dorian.service.exception.ServiceException;

public interface AccountBO {

	void registerUser(String email, String password, String username) throws ServiceException;

	Account findByEmail(String email) throws ServiceException;

	void update(Account account) throws ServiceException;

	Account findById(Integer accountId) throws ServiceException;

	List<Account> findAll() throws ServiceException;

	Account findByUserId(Integer principalId) throws ServiceException;

	List<Account> findByReputation() throws ServiceException;

	void closeOrOpen(Integer accountId, boolean b) throws ServiceException;

	User buildPassword(User user, String newPassword) throws ServiceException;

	void changePassword(Integer id, String newPassword) throws ServiceException;

}
