package com.hsp.kadori.ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.hsp.kadori.ws.dao.UserDAO;
import com.hsp.kadori.ws.dao.impl.UserDAOImpl;

@Configuration
@ComponentScan( {"de.flatspection.service" })
public class RootConfig {
	
	@Bean
	public UserDAO userDao() {
		return new UserDAOImpl();
	}
	
}
