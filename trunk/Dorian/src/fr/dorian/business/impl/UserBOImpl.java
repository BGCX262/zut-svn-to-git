package fr.dorian.business.impl;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import fr.dorian.business.UserBO;

@Service
@Scope("session")
public class UserBOImpl implements UserBO, Serializable {
	
	private static final long serialVersionUID = 532563116386483006L;
	

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////
}
