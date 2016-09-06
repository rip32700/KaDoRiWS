package com.hsp.kadori.ws.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session; 
import org.hibernate.Transaction;

import com.hsp.kadori.ws.dao.UserDAO;
import com.hsp.kadori.ws.domain.User;

public class UserDAOImpl extends DAOImplBase implements UserDAO {
	
	public UserDAOImpl() {
		super(User.class);
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
	public User findUserByUsername(String username) {
	    Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	       tx = session.beginTransaction();
	       Query q = session.createQuery("From User where username=:name");
	       q.setParameter("name", username);
	       User user = (User)q.uniqueResult();
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
	       if (user.getUserId() == null) {
	    	   session.save(user);
	       } else {
	    	   session.update(user);
	       }
	       
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
