package com.hsp.kadori.ws.dao;

import java.util.List;

import com.hsp.kadori.ws.domain.User;

public interface UserDAO {

	User findUserById(final Long id);
	List<User> findAllUser();
	User save(User user);
}
