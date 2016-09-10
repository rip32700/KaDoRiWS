package com.hsp.kadori.ws.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hsp.kadori.ws.dao.GroupDAO;
import com.hsp.kadori.ws.domain.Group;

public class GroupDAOImpl extends DAOImplBase implements GroupDAO {

	public GroupDAOImpl() {
		super(Group.class);
	}
	
	@Override
	public Group save(Group group) {
	    Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	       tx = session.beginTransaction();
	       session.save(group);
	       tx.commit();
	    }catch (HibernateException e) {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace();
	    }finally {
	       session.close(); 
	    }
	      
	    return group;
	}

	@Override
	public Group findGroupById(Long groupId) {
		Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	       tx = session.beginTransaction();
	       Group group = (Group)session.get(Group.class, groupId);
	       tx.commit();
	       return group;
	    }catch (HibernateException e) {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace();
	    }finally {
	       session.close(); 
	    }
	    
	    return null;
	}
}
