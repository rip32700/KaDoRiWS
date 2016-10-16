package com.hsp.kadori.ws.web;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hsp.kadori.ws.dao.FriendshipDAO;
import com.hsp.kadori.ws.domain.Friendship;

@RestController
@RequestMapping("friendship")
public class FriendshipController {
	@Inject
	FriendshipDAO repository;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<?> createFriendship(@RequestBody Friendship friendship) {
		friendship = repository.save(friendship);
	    return new ResponseEntity<>(friendship, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ResponseEntity<?> deleteFriendship(@RequestBody Friendship friendship) {
		repository.delete(friendship);
	    return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	}
}
