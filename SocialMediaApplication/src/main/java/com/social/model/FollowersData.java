package com.social.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class FollowersData {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int followId;
	
	
	private int userId;
	
	@ManyToOne
	@JoinColumn(name = "followers_id")
	private User user;
	
	
	private String following;


	public FollowersData() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FollowersData(int followId, int userId, User user, String following) {
		super();
		this.followId = followId;
		this.userId = userId;
		this.user = user;
		this.following = following;
	}


	
	
	
	
	
	public int getFollowId() {
		return followId;
	}


	public void setFollowId(int followId) {
		this.followId = followId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getFollowing() {
		return following;
	}


	public void setFollowing(String following) {
		this.following = following;
	}
	
	


}
