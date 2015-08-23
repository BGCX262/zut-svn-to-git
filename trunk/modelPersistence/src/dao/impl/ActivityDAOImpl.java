package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import model.Activity;
import dao.ActivityDAO;

public class ActivityDAOImpl extends AbstractDAO<Activity> implements ActivityDAO, Serializable {

	private static final long serialVersionUID = 979385482116620190L;

	private static final Log log = LogFactory.getLog(ActivityDAO.class);
	
	@Override
	public List<Activity> findAll() {
		log.info("find all");
		return this.findAll(Activity.class);
	}

	@Override
	public Activity findById(Integer id) {
		log.info("find by id // " + id);
		return this.findById(Activity.class, id);
	}
}
