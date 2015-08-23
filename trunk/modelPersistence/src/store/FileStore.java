package store;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import test.util.ComponentException;

public class FileStore implements ObjectStore, Serializable {

	private static final long serialVersionUID = 1351346202154733558L;

	private static final Log log = LogFactory.getLog(FileStore.class);

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////

	public static final String STORE_DIR = "A:\\DorianStore";

	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 
	 * @param data
	 * @return uuid (new filename)
	 */
	@Override
	public String store(byte[] data) throws ComponentException {

		if (data == null || data.length < 1) {
			throw ComponentException.ILLEGAL_ARGUMENT_ERROR;
		}

		log.info("Storing " + data.length + " bytes");

		String uuid = null;
		File file = null;
		String pathname = null;

		try {
			do {
				uuid = UUID.randomUUID().toString();
				pathname = STORE_DIR + File.separatorChar + uuid;
				file = new File(pathname);
			} while (!file.createNewFile());
		} catch (IOException io) {
			log.fatal("Error creating file: ", io);
			throw new ComponentException(io);
		}

		log.info("new file generated [" + uuid + "] " + file);

		// Write to file 
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(data);
		} catch (Exception e) {
			log.error("Error writing to file.");
			throw new ComponentException(e);
		} finally {
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (Exception e) {
					log.error("Error closing fileOutputStream: ", e);
					throw new ComponentException(e);
				}
			}
		}
		return uuid;
	}

	@Override
	public byte[] getObject(String uuid) throws ComponentException {

		if (uuid == null)
			throw ComponentException.ILLEGAL_ARGUMENT_ERROR;
		
		byte[] result = null;
		
		String filePath = STORE_DIR + File.separator + uuid;
		File file = new File(filePath);

		if (!file.exists() || !file.isFile()) {
			String message = "Error opening: " + file.getPath();
			log.error(message);
			throw new ComponentException(message);
		}

		// read content
		try {
			FileInputStream fis = new FileInputStream(file);
			result = IOUtils.toByteArray(fis);
		} catch (Exception e) {
			String msg = "Error reading file: " + file.getPath();
			log.error(msg);
			throw new ComponentException(msg);
		}
		
		return result;
	}

	@Override
	public byte[] update(String uuid, byte[] data) throws ComponentException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(String uuid) throws ComponentException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

}
