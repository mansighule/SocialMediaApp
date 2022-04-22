package com.social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.model.FollowersData;
import com.social.repository.FollowersDataRepo;

@Service
public class FollowersDataService {
	
	@Autowired
	private FollowersDataRepo dataRepo;
	
	
	
	public List<FollowersData> getAllFollowers(int userId){
		
		
		List<FollowersData> followersList = dataRepo.findByUserId(userId);
	
		return followersList;
		
	}
	
	
	
	public List<FollowersData> getAllFollowings(int userId){
		
		
		List<FollowersData> followingList = dataRepo.getAllFollowing(userId);
		return followingList;
	}
	
	
	
	public List<FollowersData> getConnected(int userId){
		
		List<FollowersData> getknown = dataRepo.getknown(userId);
		
		return getknown;
	}
	

}
