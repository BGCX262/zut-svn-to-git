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
import fr.dorian.model.Attachment;
import fr.dorian.model.Post;
import fr.dorian.model.Tutorial;
import fr.dorian.service.dao.AttachmentDAO;
import fr.dorian.service.dao.util.EntityManagerUtil;

@Repository
public class AttachmentDAOImpl extends AbstractDAO<Attachment> implements AttachmentDAO, Serializable {

	private static final long serialVersionUID = 979385482116620190L;

	private static final Log log = LogFactory.getLog(AttachmentDAO.class);
	
	@Override
	@Transactional(readOnly = true)
	public List<Attachment> findAll() {
		log.info("find all");
		return this.findAll(Attachment.class);
	}

	@Override
	@Transactional(readOnly = true)
	public Attachment findById(Integer id) {
		log.info("find by id // " + id);
		return this.findById(Attachment.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Attachment> findByPost(Post post) {
		log.info("find by post id // " + post.getId());
		
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("postId", post.getId());
		return (List<Attachment>)EntityManagerUtil.executeNamedQueryInTransaction("Attachment.findByPost", params);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Attachment> findByTutorial(Tutorial tutorial) {
		log.info("find by tutorial id // " + tutorial.getId());
		
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("tutorialId", tutorial.getId());
		return (List<Attachment>)EntityManagerUtil.executeNamedQueryInTransaction("Attachment.findByTutorial", params);
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Attachment> findByAccount(Account account) {
		log.info("find by account id // " + account);
		
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("accountId", account.getId());
		return (List<Attachment>)EntityManagerUtil.executeNamedQueryInTransaction("Attachment.findByAccount", params);
	}
}
