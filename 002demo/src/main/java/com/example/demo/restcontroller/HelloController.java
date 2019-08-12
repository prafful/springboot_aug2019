package com.example.demo.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Friend;
import com.example.demo.service.FriendService;

@RestController
public class HelloController {

	@Autowired
	private FriendService friendService;
	
	
	@RequestMapping("/")
	public String welcome() {
		return "Welcome to Spring Boot!!!! with Devtools.";
	}
	
	
	@RequestMapping("/all")
	public List<Friend> getAllFriends() {
		List<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend(1L, "OBB", "Chennai"));
		friends.add(new Friend(2L, "OK", "Kolkata"));
		friends.add(new Friend(3L, "Buk", "Mumbai"));
		friends.add(new Friend(1L, "Jum", "Shimla"));
		
		return friends;
	
	}
	
	@RequestMapping(value = "/friend/add", method = RequestMethod.POST)
	//@PostMapping("/friend/add")
	public List<Friend> addFriend(@RequestBody Friend f) {
		System.out.println("Friend: " + f.getId() + " " + f.getName() +" " + f.getLocation() );
		return friendService.addFriend(f);
	}
	
	@RequestMapping(value = "/friend/edit/{id}", method = RequestMethod.POST )
	public List updateFriend(@PathVariable Long id, @RequestBody Friend f) {
		return friendService.updateFriend(id, f);
	}
	
	
	
}
