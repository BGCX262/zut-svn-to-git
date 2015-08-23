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
import fr.dorian.model.Comment;
import fr.dorian.model.Tutorial;
import fr.dorian.service.dao.CommentDAO;
import fr.dorian.service.dao.util.EntityManagerUtil;

@Repository
public class CommentDAOImpl extends AbstractDAO<Comment> implements CommentDAO, Serializable {

	private static final long serialVersionUID = 5763240041153547392L;
	
	private static final Log log = LogFactory.getLog(CommentDAO.class);

	@Override
	@Transactional(readOnly = true)
	public Comment findById(Integer id) {
		log.info("find by id");
		return this.findById(Comment.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Comment> findAll() {
		log.info("find all comments");
		return this.findAll(Comment.class);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Comment> findByAccount(Account account) {
		log.info("find comments by account with id // " + account.getId());

		Map<String, Object> params = new TreeMap<String, Object>();

		params.put("accountId", account.getId());
		return EntityManagerUtil.executeNamedQueryInTransaction("Comment.findByAccountId", params);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Comment> findByTutorial(Tutorial tutorial) {
		log.info("find comments by tutorial with id // " + tutorial.getId());
		
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("tutorialId", tutorial.getId());
		return EntityManagerUtil.executeNamedQueryInTransaction("Comment.findByTutorialId", params);
	}

}
