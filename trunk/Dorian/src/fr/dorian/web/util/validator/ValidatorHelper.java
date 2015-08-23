package fr.dorian.web.util.validator;

import org.apache.commons.validator.EmailValidator;
import org.apache.commons.validator.GenericValidator;

public class ValidatorHelper {

	public static boolean isSamePassword(String password, String passwordVerifier) {
		return password.equals(passwordVerifier);
	}
	
	public static boolean isRequired(String value) {
		return !GenericValidator.isBlankOrNull(value);
	}
	
	public static boolean isEmail(String value) {
		return GenericValidator.isBlankOrNull(value) ||
				EmailValidator.getInstance().isValid(value);
	}
}
