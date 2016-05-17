package com.hsp.kadori.ws.domain;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "CHATMESSAGE")
public class ChatMessage {
	
	@Id @GeneratedValue
	@Column(name = "CHATMESSAGE_ID")
	private Long chatMessageId;

	@Column(name = "CONTENT")
	private String content;

	@Column(name = "MESSAGETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date messageTime;
	
    @ManyToOne
    @JoinColumn(name = "CHAT_ID")
	private Chat chat;

    @ManyToOne
    @JoinColumn(name = "RECIEVER_ID", referencedColumnName = "USER_ID")
	private User user;
	
	public ChatMessage() {}
	
	public ChatMessage (Long chatMessageId, String content, Date messageTime, Chat chat, User user) {
		super();
		this.chatMessageId = chatMessageId;
		this.content = content;
		this.messageTime = messageTime;
		this.chat = chat;
		this.user = user;
	}
	
	public Long getChatMessageId() {
		return chatMessageId;
	}
	
	public void setChatMessageId(Long chatMessageId) {
		this.chatMessageId = chatMessageId;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getCreationTime() {
		return messageTime;
	}
	
	public void setCreationTime(Date messageTime) {
		this.messageTime = messageTime;
	}
	
	public Chat getChat() {
		return chat;
	}
	
	public void setChat(Chat chat) {
		this.chat = chat;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
