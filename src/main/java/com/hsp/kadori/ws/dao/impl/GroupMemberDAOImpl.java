package com.hsp.kadori.ws.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hsp.kadori.ws.dao.GroupMemberDAO;
import com.hsp.kadori.ws.domain.GroupMember;

public class GroupMemberDAOImpl extends DAOImplBase implements GroupMemberDAO {

	public GroupMemberDAOImpl() {
		super(GroupMember.class);
	}
	
	@Override
	public GroupMember save(GroupMember groupMember) {
	    Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	       tx = session.beginTransaction();
	       session.save(groupMember);
	       tx.commit();
	    }catch (HibernateException e) {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace();
	    }finally {
	       session.close(); 
	    }
	      
	    return groupMember;
	}
}
