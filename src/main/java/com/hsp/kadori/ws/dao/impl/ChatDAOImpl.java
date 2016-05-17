package com.hsp.kadori.ws.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hsp.kadori.ws.dao.ChatDAO;
import com.hsp.kadori.ws.domain.Chat;

public class ChatDAOImpl extends DAOImplBase implements ChatDAO {

	public ChatDAOImpl() {
		super(Chat.class);
	}
	
	@Override
	public Chat save(Chat chat) {
	    Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	       tx = session.beginTransaction();
	       session.save(chat);
	       tx.commit();
	    }catch (HibernateException e) {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace();
	    }finally {
	       session.close(); 
	    }
	      
	    return chat;
	}
}
