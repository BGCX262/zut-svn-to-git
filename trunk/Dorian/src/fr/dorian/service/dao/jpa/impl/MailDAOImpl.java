package fr.dorian.service.dao.jpa.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dorian.model.Mail;
import fr.dorian.model.enums.TemplateTypeEnum;
import fr.dorian.service.dao.MailDAO;
import fr.dorian.service.dao.util.EntityManagerUtil;

@Repository
public class MailDAOImpl extends AbstractDAO<Mail> implements MailDAO, Serializable {

	private static final long serialVersionUID = 5544512517672574271L;

	private static final Log log = LogFactory.getLog(MailDAO.class);
	
	@Override
	@Transactional(readOnly = true)
	public Mail findById(Integer id) {
		log.info("find by id // " + id);
		return this.findById(Mail.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Mail> findAll() {
		log.info("find all Mails");
		return this.findAll(Mail.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Mail> findAll(TemplateTypeEnum type) {
		log.info("find templates by template type enum// " + type);
		
		Map<String, Object> params = new TreeMap<String, Object>();
		
		params.put("type", type);
		@SuppressWarnings("unchecked")
		List<Mail> mails = EntityManagerUtil.executeNamedQueryInTransaction("Mail.findByType", params);
		return mails;
	}
	
}
