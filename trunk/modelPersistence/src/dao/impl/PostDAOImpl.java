package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import model.Post;
import dao.PostDAO;

public class PostDAOImpl extends AbstractDAO<Post> implements PostDAO, Serializable {

	private static final long serialVersionUID = -1065996733767950602L;

	private static final Log log = LogFactory.getLog(PostDAO.class);
	
	@Override
	public List<Post> findAll() {
		log.info("find all");
		return this.findAll(Post.class);
	}

	@Override
	public Post findById(Integer id) {
		log.info("find by id // " + id);
		return this.findById(Post.class, id);
	}
}
