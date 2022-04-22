package com.social.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.social.model.FollowersData;


public interface FollowersDataRepo extends JpaRepository<FollowersData, Integer>{

	
	public List<FollowersData> findByUserId(int userId);
	
	
	@Query("From FollowersData f where f.userId= ?1 And f.following ='yes'")
	public List<FollowersData> getAllFollowing(int userId);
	
	
	@Query("from FollowersData f where user.userId = ?1 or userId = ?1 and following = 'yes'")
	public List<FollowersData> getknown(int uid);
	
}
