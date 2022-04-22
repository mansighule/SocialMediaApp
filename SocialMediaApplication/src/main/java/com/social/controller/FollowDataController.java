package com.social.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.model.FollowersData;
import com.social.service.FollowersDataService;



@RestController
@RequestMapping("/followerdata")
public class FollowDataController {
	
	
	@Autowired
	private FollowersDataService dataService;
	
	@GetMapping("/getallfollowers/{userId}")
	public List<FollowersData> getAllFollowers(@PathVariable("userId") int userId){
		
		
		List<FollowersData> allFollowersList = dataService.getAllFollowers(userId);
		
		return allFollowersList;
	}
	
	
	@GetMapping("/getallfollowings/{userId}")
	public ResponseEntity<List<FollowersData>> getAllFollowings(@PathVariable("userId") int userId){
		
		
		List<FollowersData> allFollowingsList = dataService.getAllFollowings(userId);
		
		return ResponseEntity.ok(allFollowingsList);
	}
	
	
	@GetMapping("/connected/{userId}")
	public ResponseEntity<?> getCon(@PathVariable("userId") int userId){
		List<FollowersData> following = dataService.getAllFollowings(userId);
		List<FollowersData> data = new ArrayList<FollowersData>();

		for (FollowersData followData : following) {
			
			
				List<FollowersData> getknown = dataService.getConnected(followData.getUser().getUserId());
				for (FollowersData followData2 : getknown ) {
					if(followData2.getUserId() == userId) {
						
					}else {
						data.add(followData2);
					}
				}
				
			
		}
		
		return ResponseEntity.ok(data);
	}

}
