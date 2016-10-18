package com.hsp.kadori.ws.dao;

import java.util.List;

import org.hibernate.Session;

import com.hsp.kadori.ws.domain.Post;
import com.hsp.kadori.ws.domain.User;


public interface PostDAO {

	Post save(Post post);
	List<Post> getPostsOfFriends(User me);
	List<Post> getPublicPosts();
	List<Post> getPostsOfGroup(Long groupId);
	void deleteAllPostsFromUser(User user);
	void deleteAllPostsFromGroup(Long groupId);
}
