package com.hsp.kadori.ws.web;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hsp.kadori.ws.dao.GroupDAO;
import com.hsp.kadori.ws.domain.Group;

@RestController
@RequestMapping("group")
public class GroupController {
	
	@Inject
	GroupDAO repository;
	
	@RequestMapping(value="/{groupId}", method=RequestMethod.GET)
	public ResponseEntity<?> getGroup(@PathVariable("groupId") Long groupId) {
		Group group = repository.findGroupById(groupId);
		
		return new ResponseEntity<>(group, HttpStatus.OK);
	}
}
