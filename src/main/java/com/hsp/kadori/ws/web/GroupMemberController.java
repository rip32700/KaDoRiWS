package com.hsp.kadori.ws.web;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hsp.kadori.ws.dao.GroupMemberDAO;
import com.hsp.kadori.ws.domain.GroupMember;

@RestController
@RequestMapping("groupmember")
public class GroupMemberController {
	@Inject
	GroupMemberDAO repository;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<?> createGroupMember(@RequestBody GroupMember gm) {
		gm = repository.save(gm);
	    return new ResponseEntity<>(gm, HttpStatus.CREATED);
	}

	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ResponseEntity<?> leaveGroup(@RequestBody GroupMember gm) {
		repository.delete(gm);
	    return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
