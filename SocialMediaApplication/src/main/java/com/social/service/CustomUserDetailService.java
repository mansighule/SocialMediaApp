package com.social.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.social.model.CustomUserDetails;
import com.social.model.User;
import com.social.repository.UserRepo;


@Service
public class CustomUserDetailService implements UserDetailsService {

	
	@Autowired
	private UserRepo userRepo;
	
	
	public CustomUserDetailService(UserRepo userRepo) {
		
		this.userRepo = userRepo;
		
	}
	
	
	
	
	  @Override public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException { 
		  // TODO Auto-generated method stub
	  
		  System.out.println("loadbyuser");
		  
	  User user = userRepo.findByUserName(userName);
	  
	  
	  
	  if(user == null) {
	  
		  throw new UsernameNotFoundException("No Such User");
	  }
	  
	  return new CustomUserDetails(user); }
	 

}
