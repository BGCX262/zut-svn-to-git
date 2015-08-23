package fr.dorian.service.store;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = { "classpath:app.properties" })
public class FileStore implements ObjectStore, Serializable {

	private static final long serialVersionUID = 1351346202154733558L;

	private static final Log log = LogFactory.getLog(FileStore.class);

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	private Environment environment;
	
	private String targetDirectory;
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	private String getTargetPath(String property) throws StoreException {
		
		String path = null;
		File store = new File(environment.getRequiredProperty("app.store.root.directory"));
		if (!store.exists()) {
			try {
				store.createNewFile();
			}  catch (IOException e) {
				throw StoreException.IOEXCEPTION;
			} catch (SecurityException securityException) {
				throw securityException;
			}
		}
		
		path = new StringBuilder(store.getAbsolutePath())
		.append(File.separator)
		.append(environment.getRequiredProperty(property))
		.toString();
		
		return path;
	}
	/**
	 * 
	 * @param data
	 * @return uuid (new filename)
	 */
	@Override
	public String store(byte[] data) throws StoreException {

		if (data == null || data.length < 1) {
			throw StoreException.ILLEGAL_ARGUMENT_ERROR;
		}

		log.info("Storing " + data.length + " bytes");

		String uuid = null;
		File file = null;
		String pathname = null;
		
		this.targetDirectory = this.getTargetPath("app.store.attachment.directory");
		File target = new File(targetDirectory);
		if (!target.exists())
			target.mkdirs();
		
		try {
			do {
				uuid = UUID.randomUUID().toString();
				pathname = targetDirectory + File.separatorChar + uuid;
				file = new File(pathname);
			} while (!file.createNewFile());
		} catch (IOException io) {
			log.fatal("Error creating file: ", io);
			throw new StoreException(io);
		}

		log.info("new file generated [" + uuid + "] " + file);

		// Write to file 
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(data);
		} catch (Exception e) {
			log.error("Error writing to file.");
			throw new StoreException(e);
		} finally {
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (Exception e) {
					log.error("Error closing fileOutputStream: ", e);
					throw new StoreException(e);
				}
			}
		}
		return uuid;
	}

	@Override
	public byte[] getObject(String uuid) throws StoreException {

		if (uuid == null)
			throw StoreException.ILLEGAL_ARGUMENT_ERROR;
		
		byte[] result = null;
		
		this.targetDirectory = this.getTargetPath("app.store.attachment.directory");
		File target = new File(targetDirectory);
		if (!target.exists())
			target.mkdirs();
		
		String filePath = this.targetDirectory + File.separator + uuid;
		File file = new File(filePath);
		if (!file.exists() || !file.isFile()) {
			String message = "Error opening: " + file.getPath();
			log.error(message);
			throw new StoreException(message);
		}

		// read content
		try {
			FileInputStream fis = new FileInputStream(file);
			result = IOUtils.toByteArray(fis);
		} catch (Exception e) {
			String msg = "Error reading file: " + file.getPath();
			log.error(msg);
			throw new StoreException(msg);
		}
		
		return result;
	}

	@Override
	public InputStream getObjectAsInputStream(String uuid) throws StoreException {
		return new ByteArrayInputStream(this.getObject(uuid));
	}
	
	@Override
	public byte[] update(String uuid, byte[] data) throws StoreException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(String uuid) throws StoreException {
		throw new UnsupportedOperationException();
	}

	public String getTargerDirectory() {return targetDirectory;}
	public void setTargerDirectory(String targerDirectory) {this.targetDirectory = targerDirectory;}
}
