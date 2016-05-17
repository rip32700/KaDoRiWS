package com.hsp.kadori.ws.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hsp.kadori.ws.dao.FriendshipDAO;
import com.hsp.kadori.ws.domain.Friendship;

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
}
