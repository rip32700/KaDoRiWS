package com.hsp.kadori.ws.dao;

import java.util.List;

import com.hsp.kadori.ws.domain.Group;
import com.hsp.kadori.ws.domain.User;

public interface GroupDAO {

	Group save(Group group);
	Group findGroupById(Long groupId);
	List<Group> findJoinableGroups(User me);
}
