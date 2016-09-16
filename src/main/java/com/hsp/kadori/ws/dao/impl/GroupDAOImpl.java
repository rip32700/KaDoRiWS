package com.hsp.kadori.ws.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hsp.kadori.ws.dao.*;
import com.hsp.kadori.ws.domain.Group;
import com.hsp.kadori.ws.domain.User;

public class GroupDAOImpl extends DAOImplBase implements GroupDAO {

	@Inject
	private GroupMemberDAO groupMemberRepository;
	
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
	
	@Override
	public List<Group> findJoinableGroups(User me) {
		Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	       tx = session.beginTransaction();
	       List<Long> currentGroupIds = groupMemberRepository.getGroupsOfUser(me).stream().map(x -> x.getGroupId()).collect(Collectors.toList());
	       Query q;
	       
	       if (currentGroupIds.isEmpty()) {
		       q = session.createQuery("From Group");
	       }
	       else {
		       q = session.createQuery("From Group Where groupId not in (:groupids)");
		       q.setParameterList("groupids", currentGroupIds);
	       }
	       
	       List<Group> availableGroups = q.list();
	       tx.commit();
	       return availableGroups;
	    }catch (HibernateException e) {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace();
	    }finally {
	       session.close(); 
	    }
	    
	    return null;
	}
}
