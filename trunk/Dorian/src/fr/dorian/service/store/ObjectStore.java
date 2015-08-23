package fr.dorian.service.store;

import java.io.InputStream;

public interface ObjectStore {

	String store(byte[] data) throws StoreException;

	byte[] getObject(String uuid) throws StoreException;
	
	byte[] update(String uuid, byte[] data) throws StoreException;

	void delete(String uuid) throws StoreException;

	InputStream getObjectAsInputStream(String uuid) throws StoreException;
}
