package store;

import test.util.ComponentException;

public interface ObjectStore {

	String store(byte[] data) throws ComponentException;

	byte[] getObject(String uuid) throws ComponentException;
	
	byte[] update(String uuid, byte[] data) throws ComponentException;

	void delete(String uuid) throws ComponentException;
}
