package fr.dorian.web;

import java.util.List;

import fr.dorian.model.Post;

public interface PostBean {

	void getEmpty();

	String createPost();

	String updatePost(Integer id);

	Post readPost(Integer id);

	List<Post> getAllPosts();

	void removePostById(Integer id);

	List<Post> getAllPostsByThreadId(Integer thread_id);

	String redirectTo(Post post);

	String getContent();

	void setContent(String content);

	void setId(Integer id);

	Integer getId();

	String countByAccount(Integer accountId);

	void setThreadId(Integer id);

	Integer getThreadId();

	List<Post> getAllByAccountId(Integer accountId);

	boolean canEdit(Post post);
}
