package com.hsp.kadori.ws.dao;

import java.util.List;

import com.hsp.kadori.ws.domain.Friendship;
import com.hsp.kadori.ws.domain.User;

public interface FriendshipDAO {

	Friendship save(Friendship friendship);
	List<User> getFriendsOfUser(User me);
}
