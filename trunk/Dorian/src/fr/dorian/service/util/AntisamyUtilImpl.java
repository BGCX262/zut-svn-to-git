package fr.dorian.service.util;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.owasp.validator.html.AntiSamy;
import org.owasp.validator.html.CleanResults;
import org.owasp.validator.html.Policy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import fr.dorian.service.exception.ServiceException;

@Service
public class AntisamyUtilImpl implements AntiSamyUtil, Serializable {

	private static final long serialVersionUID = 597844262071713672L;
	
	private static final Log log = LogFactory.getLog(AntiSamyUtil.class);
	
	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	public static final String POLICY_FILE_LOCATION = "antisamy-anythinggoes-1.4.4.xml";
	
	private AntiSamy antiSamy;
	
	private Policy policy;
	
	// CONSTRUCTOR
	///////////////////////////////////////////////////////////////////////////////////////////////
	@PostConstruct
	public void onConstruct() {
		try {
			ClassPathResource cpr = new ClassPathResource(POLICY_FILE_LOCATION);
			this.policy = Policy.getInstance(cpr.getFile());
		} catch (Exception e) {
			throw new RuntimeException("antisamy policy file not found", e);
		}
		this.antiSamy = new AntiSamy(this.policy);
	}

	// OVERRIDE
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String cleanContent(String content) throws ServiceException {
		log.info("clean content");
		try {
			CleanResults cleanResults = this.antiSamy.scan(content, this.policy);
			return cleanResults.getCleanHTML();
		} catch (Exception e) {
			throw new ServiceException("clean content failed", e);
		}
	}
}
