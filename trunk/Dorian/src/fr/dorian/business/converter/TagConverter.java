package fr.dorian.business.converter;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import fr.dorian.model.Tag;

@Scope("session")
@FacesConverter("tagConverter")
public class TagConverter implements Converter, Serializable {

	private static final long serialVersionUID = -6291644410073303882L;
	
	private static final Logger logger = Logger.getLogger(TagConverter.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		logger.debug("get as object");
		try {
			if (StringUtils.isEmpty(submittedValue))
				return null;
			
		} catch (Exception e) {
			logger.error("get as object failed", e);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object submittedValue) {
		logger.debug("get as string");
		try {
			if (submittedValue == null) 
				return "";
			
			Tag tag = null;
			if (submittedValue instanceof Tag)
				tag = (Tag) submittedValue;
			
			return tag.getName();
		} catch (Exception e) {
			logger.error("get as string failed", e);
		}
		return "";
	}

}
