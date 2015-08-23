package fr.dorian.web;

import java.util.List;

import fr.dorian.model.Tag;

public interface TagListBean {

	List<Tag> getTags();

	void onCompleteTag();

	void setSearchTag(String searchTag);

	String getSearchTag();

	void setTags(List<Tag> tags);

	String goToListView();

}
