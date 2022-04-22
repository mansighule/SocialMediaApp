package com.social.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.model.Posts;
import com.social.model.User;

public interface PostRepo extends JpaRepository<Posts, Integer>{
	
	/* public List<Posts> findAllPostByUserId() */
	
	
	public List<Posts> findByUser(User user);

}
