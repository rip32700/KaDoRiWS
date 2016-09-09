package com.hsp.kadori.ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hsp.kadori.ws.dao.*;
import com.hsp.kadori.ws.dao.impl.*;

@Configuration
public class RootConfig {
	
	@Bean
	public UserDAO userDao() {
		return new UserDAOImpl();
	}
	
	@Bean
	public ChatDAO chatDao() {
		return new ChatDAOImpl();
	}
	
	@Bean
	public ChatMessageDAO chatMessageDao() {
		return new ChatMessageDAOImpl();
	}
	
	@Bean
	public FriendshipDAO friendshipDao() {
		return new FriendshipDAOImpl();
	}
	
	@Bean
	public GroupDAO GroupDao() {
		return new GroupDAOImpl();
	}
	
	@Bean
	public GroupMemberDAO groupMemberDao() {
		return new GroupMemberDAOImpl();
	}
	
	@Bean
	public PostDAO postDao() {
		return new PostDAOImpl();
	}
	
}
