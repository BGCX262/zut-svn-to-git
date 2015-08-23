package fr.dorian.web;

import java.util.List;

import fr.dorian.model.Account;

public interface AccountListBean {

	List<Account> getAll();

	List<Account> getReputations();

	String goToListView();

}
