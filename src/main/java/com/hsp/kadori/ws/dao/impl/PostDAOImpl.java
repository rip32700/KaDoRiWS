package com.hsp.kadori.ws.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hsp.kadori.ws.dao.FriendshipDAO;
import com.hsp.kadori.ws.dao.PostDAO;
import com.hsp.kadori.ws.domain.Group;
import com.hsp.kadori.ws.domain.Post;
import com.hsp.kadori.ws.domain.User;

public class PostDAOImpl extends DAOImplBase implements PostDAO {

	@Inject
	private FriendshipDAO friendshipRepository;
	
	public PostDAOImpl() {
		super(Post.class);
	}
	
	@Override
	public Post save(Post post) {
	    Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	       tx = session.beginTransaction();
	       session.save(post);
	       tx.commit();
	    }catch (HibernateException e) {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace();
	    }finally {
	       session.close(); 
	    }
	      
	    return post;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Post> getPostsOfFriends(User me) {
		Session session = factory.openSession();
	    Transaction tx = null;
	    List<Post> posts = new ArrayList<Post>();
	    try{
	       tx = session.beginTransaction();
	       List<User> friends = friendshipRepository.getFriendsOfUser(me);
	       friends.add(me);
	       Query q = session.createQuery("From Post where user.userId In (:users)");
	       q.setParameterList("users", friends.stream().map(x -> x.getUserId()).collect(Collectors.toList()));
	       posts = q.list();
	       tx.commit();
	    }catch (HibernateException e) {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace();
	    }finally {
	       session.close(); 
	    }
	    
	    return posts;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Post> getPublicPosts() {
		Session session = factory.openSession();
	    Transaction tx = null;
	    List<Post> posts = new ArrayList<Post>();
	    try{
	       tx = session.beginTransaction();
	       Query q = session.createQuery("From Post where isPublic = true");
	       posts = q.list();
	       tx.commit();
	    }catch (HibernateException e) {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace();
	    }finally {
	       session.close(); 
	    }
	    
	    return posts;
	}

	@Override
	public List<Post> getPostsOfGroup(Long id) {
		Session session = factory.openSession();
	    Transaction tx = null;
	    List<Post> posts = new ArrayList<Post>();
	    try{
	       tx = session.beginTransaction();
	       Query q = session.createQuery("From Post where group.groupId = id");
	       posts = q.list();
	       tx.commit();
	    }catch (HibernateException e) {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace();
	    }finally {
	       session.close(); 
	    }
	    
	    return posts;
	}
}
