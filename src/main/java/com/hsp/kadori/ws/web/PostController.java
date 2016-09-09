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

import com.hsp.kadori.ws.dao.PostDAO;
import com.hsp.kadori.ws.dao.UserDAO;
import com.hsp.kadori.ws.domain.Post;
import com.hsp.kadori.ws.domain.User;


@RestController
@RequestMapping("post")
public class PostController {
	@Inject
	private PostDAO repository;
	
	@Inject
	private UserDAO userRepository;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<?> createPost(@RequestBody Post post) {
		post = repository.save(post);
	    return new ResponseEntity<>(null, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/all_Public", method=RequestMethod.GET)
	public ResponseEntity<?> getAllPublicPosts() {
		List<Post> publicPosts = repository.getPublicPosts();
		return new ResponseEntity<>(publicPosts, HttpStatus.OK);
	}
	
	@RequestMapping(value="/private/{userId}", method=RequestMethod.GET)
	public ResponseEntity<?> getPostsOfFriends(@PathVariable("userId") Long userId) {
		User me = userRepository.findUserById(userId);
		List<Post> postsOfFriends = repository.getPostsOfFriends(me);
		return new ResponseEntity<>(postsOfFriends, HttpStatus.OK);
	}
}
