package fr.dorian.web;

import java.util.List;

import fr.dorian.model.Mail;

public interface MailBean {

	String send();

	Mail getMail();

	void setMail(Mail mail);

	String contactUs();

	List<Mail> getAllMails();
}
