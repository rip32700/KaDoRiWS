package com.hsp.kadori.ws.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hsp.kadori.ws.dao.GroupMemberDAO;
import com.hsp.kadori.ws.dao.PostDAO;
import com.hsp.kadori.ws.domain.Group;
import com.hsp.kadori.ws.domain.GroupMember;
import com.hsp.kadori.ws.domain.User;

public class GroupMemberDAOImpl extends DAOImplBase implements GroupMemberDAO {
	@Inject
	private PostDAO postRepository;
	
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
	
	@Override
	public void delete(GroupMember groupMember) {
	    Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	       tx = session.beginTransaction();
	       Query q = session.createQuery("From GroupMember where user=:user and group=:group");
	       q.setParameter("user", groupMember.getUser());
	       q.setParameter("group", groupMember.getGroup());
	       deleteGroupMemberAndCheckGroup(session, (GroupMember)q.uniqueResult());
	       tx.commit();
	    }catch (HibernateException e) {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace();
	    }finally {
	       session.close(); 
	    }
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void deleteAllGroupsForUser(User user) {
	    Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	       tx = session.beginTransaction();
			Query q = session.createQuery("From GroupMember where user=:user");
			q.setParameter("user", user);
		    q.list().stream().forEach(gm -> deleteGroupMemberAndCheckGroup(session, (GroupMember)gm));
		    
	       tx.commit();
	    }catch (HibernateException e) {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace();
	    }finally {
	       session.close(); 
	    }
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Group> getGroupsOfUser(User me) {
		Session session = factory.openSession();
	    Transaction tx = null;
	    List<Group> groups = new ArrayList<Group>();
	    try{
	       tx = session.beginTransaction();
	       Query q = session.createQuery("From GroupMember where user=:me");
	       q.setParameter("me", me);
	       List<GroupMember> groupMembers = q.list();
	       
	       for(GroupMember gm : groupMembers) {
	    	   groups.add(gm.getGroup());
	       }
	       
	       tx.commit();
	    }catch (HibernateException e) {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace();
	    }finally {
	       session.close(); 
	    }
	    
		return groups;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findGroupMembers(Long groupId) {
		Session session = factory.openSession();
	    Transaction tx = null;
	    List<User> members = new ArrayList<User>();
	    try{
	       tx = session.beginTransaction();
	       Query q = session.createQuery("From GroupMember where group_id=:id");
	       q.setParameter("id", groupId);
	       List<GroupMember> groupMembers = q.list();
	       
	       for(GroupMember gm : groupMembers) {
	    	   members.add(gm.getUser());
	       }
	       
	       tx.commit();
	    }catch (HibernateException e) {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace();
	    }finally {
	       session.close(); 
	    }
	    
		return members;
	}
	
	private void deleteGroupMemberAndCheckGroup(Session session, GroupMember gm) {
		Group groupToCheck = gm.getGroup();
		List<User> members = findGroupMembers(groupToCheck.getGroupId());
		session.delete(gm);
		
		if (members.size() == 1 && members.get(0).getUserId().equals(gm.getUser().getUserId())) {
			postRepository.deleteAllPostsFromGroup(groupToCheck.getGroupId());
			session.delete(groupToCheck);
		}
	}
}
