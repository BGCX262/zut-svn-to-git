package fr.dorian.web;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.CroppedImage;
import org.primefaces.model.UploadedFile;

public interface ImageBean {

	CroppedImage getCroppedImage();

	void setCroppedImage(CroppedImage croppedImage);

	String getImageFilename();

	void setImageFilename(String filename);

	String cropImage();

	UploadedFile getFile();

	void setFile(UploadedFile file);

	void uploadImage(FileUploadEvent event);

	String load128(Integer accountId);

	String load32(Integer accountId);

	String load64(Integer accountId);

	
}
