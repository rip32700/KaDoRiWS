package com.hsp.kadori.ws.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hsp.kadori.ws.dao.*;
import com.hsp.kadori.ws.domain.*;

@RestController
@RequestMapping("test")
public class TestController {
	
	@Inject
	private UserDAO userRepository;
	@Inject
	private ChatDAO chatRepository;
	@Inject
	private ChatMessageDAO chatMessageRepository;
	@Inject
	private FriendshipDAO friendshipRepository;
	@Inject
	private GroupDAO groupRepository;
	@Inject
	private GroupMemberDAO groupMemberRepository;
	@Inject
	private PostDAO postRepository;
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public ResponseEntity<?> insert() {

		// Create two users
		User user1 = new User(new Long(20), "Yirica", "Michael", "Dorr", "michidorr@outlook.de", "password", "1992-03-06", "Ruckäckerweg", 6, "Regensburg", 93055, 1);
		userRepository.save(user1);
		User user2 = new User(new Long(25), "kaa23700", "Andreas", "Kalo Fogados", "beispiel@mail.net", "test", "1992-03-06", "Strasse", 123, "Regensburg", 93055, 1);
		userRepository.save(user2);
		
		// Create a group
		Group g = new Group(new Long(1), new Date(), "Gruppe zum Besprechen von Studiensachen.", "KaDoRi");
		groupRepository.save(g);
		
		// Add Users to group
		GroupMember gm = new GroupMember(new Long(1), g, user1);
		groupMemberRepository.save(gm);
		gm = new GroupMember(new Long(2), g, user2);
		groupMemberRepository.save(gm);
		
		// Create Friendship between Users
		Friendship f = new Friendship(new Long(1), user1, user2);
		friendshipRepository.save(f);
		
		// Create Chat between Users
		Chat c = new Chat(new Long(1), user1, user2);
		chatRepository.save(c);
		
		// Send one Message per User
		ChatMessage m = new ChatMessage(new Long(1), "Hallo du da", new Date(), c, user2);
		chatMessageRepository.save(m);
		m = new ChatMessage(new Long(2), "Hallo zurück dir da", new Date(), c, user1);
		chatMessageRepository.save(m);
		
		// Create one Post per User
		Post p = new Post(new Long(1), "Mein erster Post. Der erste Überhaupt.", new Date(), true, user1);
		postRepository.save(p);
		p = new Post(new Long(2), "Mein erster Post. Aber ein anderer User war schon vor mir da.", new Date(), true, user2);
		postRepository.save(p);
		
        return new ResponseEntity<>(null, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/posts", method=RequestMethod.GET)
	public ResponseEntity<?> getPostsOfFriends() {
		List<Post> test = postRepository.getPublicPosts();
        return new ResponseEntity<>(null, HttpStatus.FOUND);
	}
}
