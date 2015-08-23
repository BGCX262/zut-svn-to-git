package fr.dorian.web.impl;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.CroppedImage;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import fr.dorian.business.ImageBO;
import fr.dorian.model.enums.Avatar;
import fr.dorian.web.ImageBean;
import fr.dorian.web.security.AccountContext;
import fr.dorian.web.security.Secure;

@Controller("imageBean")
@Scope("session")
public class ImageBeanImpl implements ImageBean, Serializable {

	private static final long serialVersionUID = -6408922994021508745L;
	
	private static final Logger logger = Logger.getLogger(ImageBean.class);

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Autowired
	private ImageBO imageBO;
	
	@Autowired
	private AccountContext accountContext;
	
	// View
	private UploadedFile file;
	private CroppedImage croppedImage;
	private String imageFilename;
	
	// OVERRIDES
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	@Secured(Secure.ROLE_USER)
	public void uploadImage(FileUploadEvent event) {
		logger.debug("handle image upload");
		try {
			ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
			this.imageFilename = this.imageBO.saveTemp(event.getFile(), servletContext.getRealPath(""), this.accountContext.getCurrentAccount().getId());
			logger.info("new image name // " + this.imageFilename);
			if (this.imageFilename == null)
				return;
			
			FacesContext.getCurrentInstance().getExternalContext().redirect("/Dorian/jsp/user/account.jsf?faces-redirect=true");
			return;
		} catch (Exception e) {
			logger.error("handleImageUpload failed", e);
		}
	}
	
	@Override
	public String cropImage() {
		logger.debug("cropped image");
		return null;
	}

	@Override
	public String load128(Integer accountId) {
		logger.debug("load 128");
		return this.imageBO.load(accountId, Avatar.AVATAR_128);
	}
	
	@Override
	public String load32(Integer accountId) {
		logger.debug("load 32");
		return this.imageBO.load(accountId, Avatar.AVATAR_32);
	}
	
	@Override
	public String load64(Integer accountId) {
		logger.debug("load 64");
		return this.imageBO.load(accountId, Avatar.AVATAR_64);
	}
	
	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public CroppedImage getCroppedImage() {return croppedImage;}
	@Override
	public void setCroppedImage(CroppedImage croppedImage) {this.croppedImage = croppedImage;}
	@Override
	public String getImageFilename() {return imageFilename;}
	@Override
	public void setImageFilename(String filename) {this.imageFilename = filename;}

	@Override
	public UploadedFile getFile() {
		return file;
	}

	@Override
	public void setFile(UploadedFile file) {
		this.file = file;
	}
	
	
}
