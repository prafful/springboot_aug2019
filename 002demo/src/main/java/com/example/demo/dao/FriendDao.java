package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Friend;
import com.example.demo.repository.FriendRepository;

@Repository("friendDao")
public class FriendDao {
	
	@Autowired
	private FriendRepository friendRepository;

	public List<Friend> addFriend(Friend f) {
		// TODO Auto-generated method stub
		friendRepository.save(f);
		return friendRepository.findAll();
		
		
	
	}

	public List<Friend> updateFriend(Long id, Friend f) {
		// TODO Auto-generated method stub..
		Optional<Friend> fe = friendRepository.findById(id);
		if(fe.isPresent()) {
			Friend friend = fe.get();
			friend.setLocation(f.getLocation());
			friend.setName(f.getName());
			friendRepository.save(friend);
			return friendRepository.findAll();
		}
		else {
			return null;
		}
		
		
		
	}

}
