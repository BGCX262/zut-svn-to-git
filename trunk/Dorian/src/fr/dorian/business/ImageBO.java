package fr.dorian.business;

import org.primefaces.model.UploadedFile;

import fr.dorian.model.enums.Avatar;
import fr.dorian.service.exception.ServiceException;

public interface ImageBO {

	public static final String EXTENSION_JPG = "jpg";
	
	String saveTemp(UploadedFile event, String servletContextRealPath,
			Integer accountId) throws ServiceException;

	String load(Integer accountId, Avatar avatar128);
}
