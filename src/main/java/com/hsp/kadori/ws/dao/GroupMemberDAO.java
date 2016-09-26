package com.hsp.kadori.ws.dao;

import java.util.List;

import com.hsp.kadori.ws.domain.Group;
import com.hsp.kadori.ws.domain.GroupMember;
import com.hsp.kadori.ws.domain.User;

public interface GroupMemberDAO {

	GroupMember save(GroupMember groupMember);
	void delete(GroupMember groupMember);
	List<Group> getGroupsOfUser(User user);
	List<User> findGroupMembers(Long groupId);
}
