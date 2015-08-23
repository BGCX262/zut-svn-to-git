package fr.dorian.service.dao.jpa.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dorian.model.Account;
import fr.dorian.model.Address;
import fr.dorian.service.dao.AddressDAO;
import fr.dorian.service.dao.util.EntityManagerUtil;

@Repository
public class AddressDAOImpl extends AbstractDAO<Address> implements AddressDAO, Serializable {

	private static final long serialVersionUID = -1511982359095994816L;
	
	private static final Log log = LogFactory.getLog(AddressDAO.class);
	
	@Override
	@Transactional(readOnly = true)
	public List<Address> findAll() {
		log.info("find all");
		return this.findAll(Address.class);
	}

	@Override
	@Transactional(readOnly = true)
	public Address findById(Integer id) {
		log.info("find by id // " + id);
		return this.findById(Address.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Address> findByAccount(Account account) {
		log.info("find by account id // " + account);
		
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("accountId", account.getId());
		return (List<Address>)EntityManagerUtil.executeNamedQueryInTransaction("Address.findByAccount", params);
	}
}
