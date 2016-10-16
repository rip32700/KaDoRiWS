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

import com.hsp.kadori.ws.dao.GroupDAO;
import com.hsp.kadori.ws.dao.GroupMemberDAO;
import com.hsp.kadori.ws.domain.Group;
import com.hsp.kadori.ws.domain.User;

@RestController
@RequestMapping("group")
public class GroupController {
	
	@Inject
	GroupDAO repository;
	
	@Inject
	private GroupMemberDAO groupMemberRepository;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<?> createGroup(@RequestBody Group group) {
		group = repository.save(group);
	    return new ResponseEntity<>(group, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{groupId}", method=RequestMethod.GET)
	public ResponseEntity<?> getGroup(@PathVariable("groupId") Long groupId) {
		Group group = repository.findGroupById(groupId);
		
		return new ResponseEntity<>(group, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{groupId}/members", method=RequestMethod.GET)
	public ResponseEntity<?> getGroupMembers(@PathVariable("groupId") Long groupId) {
		List<User> groupMembers = groupMemberRepository.findGroupMembers(groupId);
		
		return new ResponseEntity<>(groupMembers, HttpStatus.OK);
	}
}
