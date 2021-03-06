package com.hsp.kadori.ws.dao;

import java.util.List;

import org.hibernate.Session;

import com.hsp.kadori.ws.domain.Friendship;
import com.hsp.kadori.ws.domain.User;

public interface FriendshipDAO {

	Friendship save(Friendship friendship);
	void delete(Friendship friendship);
	void deleteAllFriendsForUser(User user);
	List<User> getFriendsOfUser(User me);
}
