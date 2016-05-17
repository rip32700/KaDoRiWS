package com.hsp.kadori.ws.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hsp.kadori.ws.dao.UserDAO;
import com.hsp.kadori.ws.domain.User;

@RestController
@RequestMapping("user")
public class UserController {

	@Inject
	private UserDAO repository;
	
	@RequestMapping(value="/{userId}", method=RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("userId") Long userId) {
		User user = repository.findUserById(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/name/{username}", method=RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("username") String username) {
		User user = repository.findUserByUsername(username);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<?> getAllUser() {
		List<User> users = repository.findAllUser();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user) {
	        user = repository.save(user);
	        return new ResponseEntity<>(null, HttpStatus.CREATED);
	}
	
}