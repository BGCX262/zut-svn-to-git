package fr.dorian.business;

import java.util.List;

import fr.dorian.model.Account;
import fr.dorian.model.Attachment;
import fr.dorian.model.Post;
import fr.dorian.service.exception.ServiceException;

public interface PostBO
{
	//CRUD services
	
	public Post findById(Integer id) throws ServiceException;
	public abstract void updatePost(Post post);
	public abstract void deletePostById(Account account, Integer id) throws ServiceException;
	
	//Additional services
	
	public abstract List<Post> findAll() throws ServiceException;
	public abstract List<Post> findByThreadId(Integer id) throws ServiceException;
	Long countByAccountId(Integer accountId) throws ServiceException;
	void createPost(Integer threadId, Post post, List<Attachment> attachments) throws ServiceException;
	List<Post> findByAccountId(Integer accountId) throws ServiceException;
}