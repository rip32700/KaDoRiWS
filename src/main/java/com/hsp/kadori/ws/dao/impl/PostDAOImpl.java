package com.hsp.kadori.ws.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hsp.kadori.ws.dao.PostDAO;
import com.hsp.kadori.ws.domain.Post;

public class PostDAOImpl extends DAOImplBase implements PostDAO {

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
}
