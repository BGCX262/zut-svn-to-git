package fr.dorian.web.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.dorian.business.TagBO;
import fr.dorian.model.Tag;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.web.TagListBean;

@Controller("tagListBean")
@Scope("session")
public class TagListBeanImpl implements TagListBean, Serializable {

	private static final long serialVersionUID = 1909104165554338349L;
	
	private static final Logger logger = Logger.getLogger(TagListBean.class);

	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired(required = true)
	private TagBO tagBO;
	
	private List<Tag> tags;
	private String searchTag;
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public String goToListView() {
		return Redirect.redirect("/jsp/tag/list");
	}
	
	@Override
	public List<Tag> getTags() {
		if (this.searchTag == null || this.searchTag.isEmpty())
			try {
				this.tags = tagBO.findAll();
			} catch (ServiceException e) {
				logger.error("find all tags failed", e);
			}
		return tags;
	}
	
	@Override
	public void setTags(List<Tag> tags) {this.tags = tags;}
	@Override
	public String getSearchTag() {return searchTag;}
	@Override
	public void setSearchTag(String searchTag) {this.searchTag = searchTag;}
	
	@Override
	public void onCompleteTag() {
		logger.debug("complete");
		try {
			System.out.println(this.searchTag);
			
			if (this.searchTag != null && !this.searchTag.isEmpty())
				this.tags = this.tagBO.findTagContains(this.searchTag);
			/*else	
				this.tags = this.tagBO.findAll();*/
			//return suggestions;
		} catch (ServiceException e) {
			logger.error("complete failed", e);
		}
	} 
}
