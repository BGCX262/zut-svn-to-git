package fr.dorian.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.primefaces.model.UploadedFile;

import fr.dorian.model.superclasses.StoreableEntity;

@Entity
@Table(name = "attachment", uniqueConstraints = {@UniqueConstraint(columnNames = {"file_uuid"})})
@NamedQueries({
	@NamedQuery(name = "Attachment.findAll",	query = "SELECT a FROM Attachment a "),
	@NamedQuery(name = "Attachment.findById",	query = "SELECT a FROM Attachment a WHERE a.id = :id"),
	@NamedQuery(name = "Attachment.findByPost",	query = "SELECT a FROM Attachment a WHERE a.post.id = :postId"),
	@NamedQuery(name = "Attachment.findByTutorial",	query = "SELECT a FROM Attachment a WHERE a.tutorial.id = :tutorialId"),
	@NamedQuery(name = "Attachment.findByAccount",query = "SELECT a FROM Attachment a WHERE a.account.id = :accountId")
})
public class Attachment extends StoreableEntity implements Serializable {

	private static final long serialVersionUID = 3861512482576048497L;

	public static final String NO_DESCRIPTION = "NO DESCRIPTION";
	
	// PROPERTIES
	///////////////////////////////////////////////////////////////////////////////////////////////

	@ManyToOne
	@JoinColumn(name = "post_id", nullable = true)
	private Post post;

	@ManyToOne
	@JoinColumn(name = "tutorial_id", nullable = true)
	private Tutorial tutorial;

	@Transient
	private UploadedFile file;
	
	// CONSTRUCTORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	public Attachment() {
		super();
	}

	// ACCESSORS
	///////////////////////////////////////////////////////////////////////////////////////////////

	public Post getPost() {return post;}
	public void setPost(Post post) {this.post = post;}
	
	public UploadedFile getFile() {return file;}
	public void setFile(UploadedFile file) {this.file = file;}

	public Tutorial getTutorial() {return tutorial;}
	public void setTutorial(Tutorial tutorial) {this.tutorial = tutorial;}
	
	// HELPER
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", this.id)
			.append("filename", this.fileName)
			.toString();
	}

}
