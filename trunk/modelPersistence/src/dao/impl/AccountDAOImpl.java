package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dao.AccountDAO;

import model.Account;

public class AccountDAOImpl extends AbstractDAO<Account> implements AccountDAO, Serializable {

	private static final long serialVersionUID = -1526467105153042475L;
	
	private static final Log log = LogFactory.getLog(AccountDAO.class);

	@Override
	public Account findById(Integer id) {
		log.info("find by id // " + id);
		
		return this.findById(Account.class, id);
	}

	@Override
	public List<Account> findAll() {
		log.info("find all");
		return this.findAll(Account.class);
	}
}
