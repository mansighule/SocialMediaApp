package com.social.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Posts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	
	@Column(columnDefinition="TEXT")
	private String postImg;
	
	
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime postDate;

	
	

	public Posts() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Posts(int postId, User user, String postImg, LocalDateTime postDate) {
		super();
		this.postId = postId;
		this.user = user;
		this.postImg = postImg;
		this.postDate = postDate;
	}


	
	
	
	public int getPostId() {
		return postId;
	}


	public void setPostId(int postId) {
		this.postId = postId;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getPostImg() {
		return postImg;
	}


	public void setPostImg(String postImg) {
		this.postImg = postImg;
	}


	public LocalDateTime getPostDate() {
		return postDate;
	}


	public void setPostDate(LocalDateTime postDate) {
		this.postDate = postDate;
	}
	
	

}
