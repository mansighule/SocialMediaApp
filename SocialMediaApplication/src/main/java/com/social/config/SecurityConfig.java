 package com.social.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.social.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		http
				.csrf().disable()// by default it is enable so to disable this have to write this
				.requestMatchers()
		        .antMatchers("/newuser")
		        .and()
		        .authorizeRequests()
		        .anyRequest()
		        .authenticated()
		        .and()
		        .httpBasic();
		        
		
		
	}
	
	

	  @Override 
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
	  
		  	auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
	  
	  }
	  
	  
	  @Override
	    @Bean
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }
	  
	
	@Bean 
	public BCryptPasswordEncoder passwordEncoder() {
	  
		  return new BCryptPasswordEncoder(11);
	  }
	
	
	
}
