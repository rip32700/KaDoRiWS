package com.hsp.kadori.ws.domain;

import javax.persistence.*;

@Entity
@Table(name = "FRIENDSHIP")
public class Friendship {
	
	@Id @GeneratedValue
	@Column(name = "FRIENDSHIP_ID")
	private Long friendshipId;
	
    @ManyToOne
    @JoinColumn(name = "USER1_ID", referencedColumnName = "USER_ID")
	private User user1;

    @ManyToOne
    @JoinColumn(name = "USER2_ID", referencedColumnName = "USER_ID")
	private User user2;
	
	public Friendship() {}
	
	public Friendship (Long friendshipId, User user1, User user2) {
		super();
		this.friendshipId = friendshipId;
		this.user1 = user1;
		this.user2 = user2;
	}
	
	public Long getFriendshipId() {
		return friendshipId;
	}
	
	public void setFriendshipId(Long friendshipId) {
		this.friendshipId = friendshipId;
	}
	
	public User getUser1() {
		return user1;
	}
	
	public void setUser1(User user) {
		this.user1 = user;
	}
	
	public User getUser2() {
		return user2;
	}
	
	public void setUser2(User user) {
		this.user2 = user;
	}
}
