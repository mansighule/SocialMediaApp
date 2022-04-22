package com.social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.model.User;
import com.social.repository.UserRepo;
import com.social.service.UserService;

@RestController
@RequestMapping("/socialmedia")
public class UserController {
	
	 @Autowired
	    private AuthenticationManager authenticationManager;

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder passowrdEncoder;
	
	
	@PostMapping("/register")
	public User addUser(@RequestBody User user) {
		
		User newUser = new User();
		
		newUser.setUserName(user.getUserName());
		
		newUser.setUserEmail(user.getUserEmail());
		
		newUser.setUserPassword(passowrdEncoder.encode(user.getUserPassword()));
		
		newUser.setUserRole(user.getUserRole());
		
		User addUser = userService.addUser(newUser);
		
		return addUser;
	}
	
	
	@GetMapping("/viewusers")
	public List<User> getAllUsers(){
		
		List<User> allUsers = userService.getAllUsers();
		
		return allUsers;
		
	}
	
	
	@GetMapping("/getuserbyid/{userId}")
	public User getUserById(@PathVariable("userId") Integer userId) {
		
		
		User findByUserId = userService.findByUserId(userId);
		
		return findByUserId;
	}
	
	
	@PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody User user){
		
		//System.out.println("password" +passowrdEncoder.encode(user.getUserPassword()));
		
		
		
		
		if(userService.existsByUserName(user.getUserName()))
		{
			
			//if(userService.existsByUserPassword(user.getUserPassword()))
		
			
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
						user.getUserName(), user.getUserPassword()));

		        SecurityContextHolder.getContext().setAuthentication(authentication);
		        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
			
            
        }else {
        	return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }
		
		
      
    }
	

}
