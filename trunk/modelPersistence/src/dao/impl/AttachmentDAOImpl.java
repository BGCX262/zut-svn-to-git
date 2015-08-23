package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import model.Attachment;
import dao.AttachmentDAO;

public class AttachmentDAOImpl extends AbstractDAO<Attachment> implements AttachmentDAO, Serializable {

	private static final long serialVersionUID = 979385482116620190L;

	private static final Log log = LogFactory.getLog(AttachmentDAO.class);
	
	@Override
	public List<Attachment> findAll() {
		log.info("find all");
		return this.findAll(Attachment.class);
	}

	@Override
	public Attachment findById(Integer id) {
		log.info("find by id // " + id);
		return this.findById(Attachment.class, id);
	}
}
