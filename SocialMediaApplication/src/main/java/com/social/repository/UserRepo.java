package com.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	
	public User findByUserName(String userName);
	
	public Boolean existsByUserName(String userName);
	
	public Boolean existsByUserPassword(String userPassword);
	
	public User findByUserId(Integer userId);
	
	
	
}
