package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import model.Tag;
import dao.TagDAO;

public class TagDAOImpl extends AbstractDAO<Tag> implements TagDAO, Serializable {

	private static final long serialVersionUID = 4922584297894762589L;
	
	private static final Log log = LogFactory.getLog(TagDAO.class);
	
	@Override
	public List<Tag> findAll() {
		log.info("find all");
		return this.findAll(Tag.class);
	}

	@Override
	public Tag findById(Integer id) {
		log.info("find by id // " + id);
		return this.findById(Tag.class, id);
	}
}
