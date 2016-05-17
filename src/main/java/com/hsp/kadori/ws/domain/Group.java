package com.hsp.kadori.ws.domain;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "GROUPS")
public class Group {
	
	@Id @GeneratedValue
	@Column(name = "GROUP_ID")
	private Long groupId;
	
	@Column(name = "CREATIONDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(name = "GROUPDESCRIPTION")
	private String groupDescription;

	@Column(name = "GROUPNAME")
	private String groupName;
	
	public Group() {}
	
	public Group (Long groupId, Date date, String description, String name) {
		super();
		this.groupId = groupId;
		this.date = date;
		this.groupDescription = description;
		this.groupName = name;
	}
	
	public Long getGroupId() {
		return groupId;
	}
	
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getGroupDescription() {
		return groupDescription;
	}
	
	public void setGroupDescription(String description) {
		this.groupDescription = description;
	}
	
	public String getGroupName() {
		return groupName;
	}
	
	public void setGroupName(String name) {
		this.groupName = name;
	}
}
