package com.social.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.social.fileuploadHelper.FileUpload;
import com.social.model.Posts;
import com.social.model.User;
import com.social.service.PostService;
import com.social.service.UserService;

@RestController
@RequestMapping("/posts")
public class PostsController {
	
	@Autowired
	private FileUpload upload;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/addpost/{userId}")
	public ResponseEntity<?> addPosts(@RequestParam("file") MultipartFile file,@PathVariable("userId") Integer userId){
		
		 System.out.println(file.getOriginalFilename());
		 System.out.println(file.getSize());
		 System.out.println(file.getContentType());
			
		 try {
			 
			 
			 //
			 if(file.isEmpty())
			 {
			 return ResponseEntity.status (HttpStatus. INTERNAL_SERVER_ERROR).body("Request must contain file");
			 }
			 
			 if(!file.getContentType().equals("image/jpeg"))
			 {
			 return ResponseEntity.status (HttpStatus. INTERNAL_SERVER_ERROR).body("Only jpeg allowed");
			 }
			 
			 boolean fileUploaded = upload.fileUpload(file);
			 
			 if(fileUploaded) {
				 
				 LocalDateTime localDateTime = LocalDateTime.now();
				 
				 System.out.println(localDateTime);
				 User findByUserId = userService.findByUserId(userId);
				 
				 Posts savePost = new Posts();
				 
				 savePost.setUser(findByUserId);
				 savePost.setPostDate(localDateTime);
				 savePost.setPostImg(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
				 
				 Posts savedPost = postService.savePost(savePost);
				 
				// return ResponseEntity.ok("file uploaded successfully..!");
				 
				// return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
				return ResponseEntity.ok(savedPost);		
				 
			 }
			 
			 
		 }catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		 
		 
		 return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Something went wrong..!Please try again..");
	}
	
	
	@GetMapping("/viewallposts/{userId}")
	public ResponseEntity<List<Posts>> getAllPostByUser(@PathVariable("userId") Integer userId){
		
		List<Posts> postListByUser = postService.getAllPostByUser(userId);
		
		return ResponseEntity.ok(postListByUser);
	}
	
	
	
	/*
	 * @PostMapping("/savepost/{userId}") public ResponseEntity<?>
	 * addPosts(@PathVariable("userId") Integer userId){
	 * 
	 * User findByUserId = userService.findByUserId(userId);
	 * 
	 * Posts savedPost = postService.savePost(post);
	 * 
	 * return ResponseEntity.created(URI.create("static/image/")).body(savedPost); }
	 */
	
}
