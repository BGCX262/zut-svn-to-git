package fr.dorian.service.dao;

import java.util.List;

import fr.dorian.model.Mail;
import fr.dorian.model.enums.TemplateTypeEnum;

public interface MailDAO extends IDAO<Mail> {

	List<Mail> findAll(TemplateTypeEnum type);

}
