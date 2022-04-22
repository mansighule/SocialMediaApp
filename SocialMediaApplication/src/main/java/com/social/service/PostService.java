package com.social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.model.Posts;
import com.social.model.User;
import com.social.repository.PostRepo;
import com.social.repository.UserRepo;

@Service
public class PostService {
	
	@Autowired
	private PostRepo postRepo;

	@Autowired
	private UserRepo userRepo;
	
	
	public Posts savePost(Posts posts) {
		
		Posts savedPosts = postRepo.save(posts);
		
		return savedPosts;
	}
	
	
	public List<Posts> getAllPostByUser(Integer userId){
		
		User findByUserId = userRepo.findByUserId(userId);
		
		List<Posts> postList = postRepo.findByUser(findByUserId);
		
		return postList;
	}
	
	
	
	
	
	
	
	
	
	
	/*
	 * public List<Post> getAllPostByUser(Integer userId){
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * public List<PostDto> getPostsOfUser(Integer userId){ List<Post> postList=
	 * postRepository.findPostByUserOrderById(userRepository.findUserById(userId));
	 * List<PostDto> postDtoList= new ArrayList<>(); for (Post post :postList) {
	 * postDtoList.add(modelMapper.map(post,PostDto.class)); } return postDtoList; }
	 */
	
}
