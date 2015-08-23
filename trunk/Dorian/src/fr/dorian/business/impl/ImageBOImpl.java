package fr.dorian.business.impl;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.UUID;

import javax.imageio.ImageIO;
import org.apache.log4j.Logger;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import fr.dorian.business.ImageBO;
import fr.dorian.model.Account;
import fr.dorian.model.enums.Avatar;
import fr.dorian.service.dao.AccountDAO;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.service.store.StoreException;

@Service
@Scope("session")
@PropertySource(value = { "classpath:app.properties" })
public class ImageBOImpl implements ImageBO, Serializable {

	private static final long serialVersionUID = -8581819543519319954L;

	private static final Logger logger = Logger.getLogger(ImageBO.class);

	public static final String DEFAULT_WEB_PATH = "/includes/images/";
	
	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	private Environment environment;
	
	@Autowired
	private AccountDAO accountDAO;
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String saveTemp(UploadedFile event, String servletContextRealPath, Integer accountId) throws ServiceException {
		logger.debug("save temp");
		try {
			if (accountId == null || event == null || servletContextRealPath == null)
				throw new ServiceException("Invalid.request: invalid file or servletContextRealPath");

			Account account = this.accountDAO.findById(accountId);
			if (account == null)
				throw ServiceException.INVALID_REQUEST;
			
			/* /tmp/images/file.jpg */
			String tempPath = servletContextRealPath + File.separator + "tmp" + File.separator + "images";
			File tmpDirectory = new File(tempPath);
			if (!tmpDirectory.exists())
				tmpDirectory.mkdirs();
			
			System.out.println("tmpdir // " + tempPath);
			BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(event.getContents()));
			
			File tmp = null;
			String uuid = null;
			try {
				do {
					uuid = UUID.randomUUID().toString();
					tmp = File.createTempFile(uuid.toString(), ".jpg", tmpDirectory);
				} while (!tmp.exists());
			} catch (IOException io) {
				logger.fatal("Error creating file: ", io);
				throw new StoreException("Error creating file", io);
			}
			
			ImageIO.write(originalImage, "JPEG", tmp);
			String filename = uuid + ".jpg";	
			this.createImages(accountId, tmp.getAbsolutePath());
			
			// update account 
			account.setAvatar(true);
			this.accountDAO.update(account);
			return filename;
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}
	
	private void createResizedCopy(BufferedImage original, Avatar avatarSize, String filename) throws IOException {
		logger.debug("create resized copy for avatar // " + avatarSize);
		BufferedImage img = new BufferedImage(avatarSize.getWidth(), avatarSize.getHeight(), original.getType());
		Graphics2D graphics2d = img.createGraphics();
		graphics2d.drawImage(original, 0, 0, avatarSize.getWidth(), avatarSize.getHeight(), null);
		graphics2d.dispose();
		graphics2d.setComposite(AlphaComposite.Src);
		graphics2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		graphics2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		ImageIO.write(img, "JPEG", new File(filename));
	}
	
	private void createImages(Integer accountId, String temporalFilename) throws ServiceException {
		logger.debug("creates images");
		try {
			if (temporalFilename == null)
				throw ServiceException.INVALID_REQUEST;
			
			File tmpFile = new File(temporalFilename);
			if (!tmpFile.exists())
				throw ServiceException.INVALID_REQUEST;
			
			BufferedImage original = ImageIO.read(tmpFile);
			String tempPath = new StringBuilder(this.environment.getProperty("app.store.root.directory"))
												.append(File.separator)
												.append(this.environment.getProperty("app.store.users.directory"))
												.append(File.separator)
												.append(accountId)
												.append(File.separator)
												.toString();
			File tmpDirectory = new File(tempPath);
			if (!tmpDirectory.exists())
				tmpDirectory.mkdirs();

			// save original
			ImageIO.write(original, "JPEG", new File(tempPath + "original.jpg"));
			// create new file
			for (Avatar avatarSize : Avatar.values()) {
				String filename = new StringBuilder(tempPath).append(avatarSize.getName()).toString();
				this.createResizedCopy(original, avatarSize, filename);
			}
		} catch (Exception e) {
			throw new ServiceException("Internal error", e);
		}
	}
	
	@Override
	public String load(Integer accountId, Avatar avatar) {
		logger.debug("load");
		String image = new StringBuilder(DEFAULT_WEB_PATH).append(avatar.getName()).toString();
		try {
			if (accountId == null || avatar == null)
				throw ServiceException.INVALID_REQUEST;
			
			Account account = this.accountDAO.findById(accountId);
			if (account == null)
				throw ServiceException.INVALID_REQUEST;
			
			if (account.isAvatar())
				image = String.format("/images/%d/%s", accountId, avatar.getName());
		} catch (Exception e) {
			logger.error("Can't load avatar, default will be returned", e);
		}
		return image;
	}
}
