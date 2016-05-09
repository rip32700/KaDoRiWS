package com.hsp.kadori.ws.dao.impl;

import java.util.List;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hsp.kadori.ws.dao.UserDAO;
import com.hsp.kadori.ws.domain.User;

public class UserDAOImpl implements UserDAO {
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;
	
	public UserDAOImpl() {
		try{
	         Configuration configuration = new Configuration();
	         configuration.configure().addAnnotatedClass(User.class);
	         serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	         factory = configuration.buildSessionFactory(serviceRegistry);
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	}
	
	@Override
	public User findUserById(Long id) {
	    Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	       tx = session.beginTransaction();
	       User user = (User)session.get(User.class, id);
	       tx.commit();
	       return user;
	    }catch (HibernateException e) {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace();
	    }finally {
	       session.close(); 
	    }
	    
	    return null;
	}
	
	@Override
	public List<User> findAllUser() {
	    Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	       tx = session.beginTransaction();
	       List<User> users = session.createQuery("FROM User").list(); 
	       tx.commit();
	       return users;
	    }catch (HibernateException e) {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace();
	    }finally {
	       session.close(); 
	    }
	    
	    return null;
	}
	
	@Override
	public User save(User user) {
	    Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	       tx = session.beginTransaction();
	       session.saveOrUpdate(user);
	       tx.commit();
	    }catch (HibernateException e) {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace();
	    }finally {
	       session.close(); 
	    }
	      
	    return user;
	}

}
