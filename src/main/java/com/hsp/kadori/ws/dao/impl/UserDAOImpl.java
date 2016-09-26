package com.hsp.kadori.ws.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session; 
import org.hibernate.Transaction;

import com.hsp.kadori.ws.dao.FriendshipDAO;
import com.hsp.kadori.ws.dao.UserDAO;
import com.hsp.kadori.ws.domain.User;

public class UserDAOImpl extends DAOImplBase implements UserDAO {

	@Inject
	private FriendshipDAO friendshipRepository;
	
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

	@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAvailableFriends(User me) {
	    Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	       tx = session.beginTransaction();
	       List<Long> currentFriendsIds = friendshipRepository.getFriendsOfUser(me).stream().map(x -> x.getUserId()).collect(Collectors.toList());
	       currentFriendsIds.add(me.getUserId());
	       currentFriendsIds.add(findUserByUsername("anonymousUser").getUserId());
	       currentFriendsIds.add(findUserByUsername("ADMIN").getUserId());
	       
	       Query q = session.createQuery("From User Where userId not in (:userids)");
	       q.setParameterList("userids", currentFriendsIds);
	       List<User> availableUsers = q.list();
	       tx.commit();
	       
	       return availableUsers;
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
