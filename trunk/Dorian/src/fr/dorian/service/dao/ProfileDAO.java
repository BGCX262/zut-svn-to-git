package fr.dorian.service.dao;

import java.util.List;

import fr.dorian.model.Account;
import fr.dorian.model.Profile;

public interface ProfileDAO extends IDAO<Profile> {

	List<Profile> findByAccount(Account account);
}
