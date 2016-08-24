package com.hsp.kadori.ws.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hsp.kadori.ws.dao.FriendshipDAO;
import com.hsp.kadori.ws.dao.UserDAO;
import com.hsp.kadori.ws.domain.Friendship;
import com.hsp.kadori.ws.domain.User;

public class FriendshipDAOImpl extends DAOImplBase implements FriendshipDAO {
	
	public FriendshipDAOImpl() {
		super(Friendship.class);
	}
	
	@Override
	public Friendship save(Friendship friendship) {
	    Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	       tx = session.beginTransaction();
	       session.save(friendship);
	       tx.commit();
	    }catch (HibernateException e) {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace();
	    }finally {
	       session.close(); 
	    }
	      
	    return friendship;
	}

	@Override
	public List<User> getFriendsOfUser(User me) {
		Session session = factory.openSession();
	    Transaction tx = null;
	    List<User> friends = new ArrayList<User>();
	    try{
	       tx = session.beginTransaction();
	       Query q = session.createQuery("From Friendship where user1=:user OR user2=:user");
	       q.setParameter("user", me);
	       List<Friendship> friendships = q.list();
	       
	       for(Friendship f : friendships) {
	    	   friends.add(f.getUser1().getUserId().equals(me.getUserId()) ? f.getUser2() : f.getUser1());
	       }
	       
	       tx.commit();
	    }catch (HibernateException e) {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace();
	    }finally {
	       session.close(); 
	    }
	    
		return friends;
	}
}
