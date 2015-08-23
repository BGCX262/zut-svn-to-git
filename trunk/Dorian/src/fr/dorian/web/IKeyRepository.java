package fr.dorian.web;

import java.util.ResourceBundle;

public interface IKeyRepository {
	
	public static final String baseName = "message";
	//Shared resources
	public ResourceBundle getResourceBundle();
}