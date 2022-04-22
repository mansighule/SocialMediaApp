package com.social.model;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails{

	private User user;
	
	public CustomUserDetails(User user) {
		
		this.user = user;
	}
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
	
		HashSet<SimpleGrantedAuthority> set = new HashSet<>(); 
		 
		set.add(new SimpleGrantedAuthority(this.user.getUserRole()));
		
		return set;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		
		String userPassword = user.getUserPassword();
		
		return userPassword;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		
		String userName = user.getUserName();
		
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
