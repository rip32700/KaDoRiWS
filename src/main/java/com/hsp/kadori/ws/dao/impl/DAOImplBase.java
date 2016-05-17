package com.hsp.kadori.ws.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DAOImplBase {
	static SessionFactory factory;
	static ServiceRegistry serviceRegistry;

	public DAOImplBase(Class<?> configClass) {
		try{
	         Configuration configuration = new Configuration();
	         configuration.configure().addAnnotatedClass(configClass);
	         serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	         factory = configuration.buildSessionFactory(serviceRegistry);
	    }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	    }
	}
}
