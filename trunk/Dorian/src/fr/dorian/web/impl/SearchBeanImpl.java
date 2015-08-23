package fr.dorian.web.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.dorian.business.SearchBO;
import fr.dorian.model.util.searchengine.SearchObject;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.web.SearchBean;


@Scope("session")
@Controller("searchBean")
public class SearchBeanImpl implements SearchBean, Serializable
{
	//Logger + serialization
	
	private static final long serialVersionUID = -2180093109454706052L;	
	private static final Logger logger = Logger.getLogger(SearchBean.class);
	
	//Properties
	
	@Autowired
	private SearchBO searchBO;
	private String value;

	//Virtual
	
	@Override
	public String redirectToSearchedThreads() {
		return (Redirect.redirect("/jsp/search/list"));
	}
	
	@Override
	public List<SearchObject> findSearchedThreads() {		
		try {
			if (this.value == null || this.value.isEmpty())
				return null;
			return (this.searchBO.searchThreads(this.value));
		} catch (ServiceException e) {
			logger.error("search failed", e);
		}  
		return null;
	}
	
	//Accessors
	
	@Override
	public String getValue() {return value;}
	@Override
	public void setValue(String value) {this.value = value;}
}