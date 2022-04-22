package com.social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.social.model.User;
import com.social.repository.UserRepo;



@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	

	
	public User addUser(User user) {
		
		User newUser = userRepo.save(user);
		
		return newUser;
	}
	
	public List<User> getAllUsers(){
		
		List<User> userList = userRepo.findAll();
		
		return userList;
	}
	
	public Boolean existsByUserName(String userName) {
		
		Boolean user = userRepo.existsByUserName(userName);
		
		return user;
			
	}
	
	public Boolean existsByUserPassword(String userPassword) {
		
		Boolean user = userRepo.existsByUserPassword(userPassword);
		
		return user;
			
	}

	
	
	
	public User findByUserId(Integer userId) {
		
		User findByUserId = userRepo.findByUserId(userId);
		
		return findByUserId;
		
	}
	
	
	
	
	

}
