package blogPostApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Comment {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CommnetId;
	private String content;
	
	@ManyToOne
	private Posts post;

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(int commnetId, String content, Posts post) {
		super();
		CommnetId = commnetId;
		this.content = content;
		this.post = post;
	}

	public int getCommnetId() {
		return CommnetId;
	}

	public void setCommnetId(int commnetId) {
		CommnetId = commnetId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Posts getPost() {
		return post;
	}

	public void setPost(Posts post) {
		this.post = post;
	}

	
	
}
