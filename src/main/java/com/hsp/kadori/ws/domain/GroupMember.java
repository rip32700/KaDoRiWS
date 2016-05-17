package com.hsp.kadori.ws.domain;

import javax.persistence.*;

@Entity
@Table(name = "GROUPMEMBER")
public class GroupMember {
	
	@Id @GeneratedValue
	@Column(name = "GROUPMEMBER_ID")
	private Long groupMemberId;
	
    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
	private Group group;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
	private User user;
	
	public GroupMember() {}
	
	public GroupMember (Long groupMemberId, Group group, User user) {
		super();
		this.groupMemberId = groupMemberId;
		this.group = group;
		this.user = user;
	}
	
	public Long getGroupMemberId() {
		return groupMemberId;
	}
	
	public void setGroupMemberId(Long groupMemberId) {
		this.groupMemberId = groupMemberId;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Group getGroup() {
		return group;
	}
	
	public void setGroup(Group group) {
		this.group = group;
	}
}
