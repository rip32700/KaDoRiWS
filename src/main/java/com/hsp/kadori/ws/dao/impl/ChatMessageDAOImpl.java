package com.hsp.kadori.ws.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hsp.kadori.ws.dao.ChatMessageDAO;
import com.hsp.kadori.ws.domain.ChatMessage;

public class ChatMessageDAOImpl extends DAOImplBase implements ChatMessageDAO {
	public ChatMessageDAOImpl() {
		super(ChatMessage.class);
	}
	
	@Override
	public ChatMessage save(ChatMessage chatMessage) {
	    Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	       tx = session.beginTransaction();
	       session.save(chatMessage);
	       tx.commit();
	    }catch (HibernateException e) {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace();
	    }finally {
	       session.close(); 
	    }
	      
	    return chatMessage;
	}
}
