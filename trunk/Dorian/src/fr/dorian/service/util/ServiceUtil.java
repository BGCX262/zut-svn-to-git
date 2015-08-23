package fr.dorian.service.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import fr.dorian.model.User;
import fr.dorian.service.exception.ServiceException;

@Service
@Scope("singleton")
@PropertySource(value = {"classpath:app.properties"})
public class ServiceUtil implements Serializable {

	private static final long serialVersionUID = -6027203641728766250L;

	private static final Log log = LogFactory.getLog(ServiceUtil.class);
	
	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////

	public static final String ID = "id";
	public static final String CODE = "code";
	public static final String SEPARATOR = ":";
	public static final String DEVELOPMENT_MODE = "DEV";
	public static final String PRODUCTION_MODE = "PROD";
	
	@Autowired
	private Environment environment;

	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getApplicationMode() {
		return this.environment.getRequiredProperty("app.mode");
	}
	/**
	 * Checks if development mode is activated for application.
	 * @return true if Development mode is activated; otherwise false.
	 */
	public boolean isDevelopmentMode() {
		if (this.environment.getRequiredProperty("app.mode").equals(DEVELOPMENT_MODE))
			return true;
		return false;
	}
	
	public final String generateCode() {
		String code = UUID.randomUUID().toString().replace("-", "");
		System.out.println("generated code" + code);
		return code;
	}
	
	public final String getProperty(String key) throws ServiceException {
		return environment.getProperty(key);
	}
	
	public String encodeUser(User user) {
		if (user == null)
			return null;
		
		String value = user.getId() + SEPARATOR + user.getPrimaryEmail();
		return new String(Base64.encodeBase64(value.getBytes()));
	}
	
	public Map<String, Object> decodeUser(String code) {
		if (code == null)
			return null;
		String value = new String(Base64.decodeBase64(code.getBytes()));
		String[] tab = value.split(SEPARATOR);
		if (tab == null || tab.length != 2) 
			return null;
		
		Map<String, Object> details = new HashMap<String, Object>(2);
		details.put(ID, Integer.parseInt(tab[0]));
		details.put(CODE, tab[1]);
		
		return details;
	}
	
	public final String buildLink(String page, String code) {
		StringBuilder stringBuilder = new StringBuilder();
		try {
			stringBuilder.append(getProperty("app.base.url"))
						 .append(page);
		} catch (ServiceException e) {
			log.error("Property not found", e);
		}
		return stringBuilder.toString();
	}
}
