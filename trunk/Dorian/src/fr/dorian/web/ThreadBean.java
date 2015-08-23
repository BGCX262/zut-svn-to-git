package fr.dorian.web;

import java.util.List;

import org.primefaces.event.SelectEvent;

import fr.dorian.model.Post;
import fr.dorian.model.Tag;
import fr.dorian.model.Thread;

public interface ThreadBean {

	void getEmpty();

	String createThread();

	String view(Integer threadId);

	String getTitle();

	void setTitle(String title);

	List<Post> findAllPostFromThread();

	Thread getThread();

	String redirectToNewResponse();

	String getContent();

	void setContent(String content);

	String close();

	String addTags();

	List<Tag> getThreadTags();

	List<Thread> getThreadsByAccount(Integer accountId);

	void setThread(Thread thread);

	Integer getId();

	void setId(Integer id);

	List<String> onCompleteTag(String query);

	List<String> getSelectedTagsText();

	void setSelectedTagsText(List<String> selectedTagsText);

	void onSelectTag(SelectEvent event);

	String countByAccount(Integer accountId);

	String validateThread(Integer postId);

	String unvalidateThread(Integer postId);

	String createTutorialFromThread();

	String destroyTutorialByThreadId(Integer threadId);

	String goToAskQuestion();

	String goToThreadList();

	boolean isCanEdit();

	void setCanEdit(boolean canEdit);

}
