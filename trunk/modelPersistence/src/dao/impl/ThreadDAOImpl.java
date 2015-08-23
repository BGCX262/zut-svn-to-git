package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import model.Thread;
import dao.ThreadDAO;

public class ThreadDAOImpl extends AbstractDAO<Thread> implements ThreadDAO, Serializable {

	private static final long serialVersionUID = -4689632426298773037L;

	private static final Log log = LogFactory.getLog(ThreadDAO.class);
	
	@Override
	public List<Thread> findAll() {
		log.info("find all");
		return this.findAll(Thread.class);
	}

	@Override
	public Thread findById(Integer id) {
		log.info("find by id // " + id);
		return this.findById(Thread.class, id);
	}
}
