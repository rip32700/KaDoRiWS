package com.hsp.kadori.ws.domain;
import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {

	@Id @GeneratedValue
	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "FIRSTNAME")
	private String firstname;
	
	@Column(name = "LASTNAME")
	private String lastname;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "BIRTHDAY")
	private String birthday;
	
	@Column(name = "STREET")
	private String street;
	
	@Column(name = "STREET_NR")
	private String streetNumber;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "ZIP")
	private String zip;
	
	@Column(name = "ROLE")
	private int role;
	
	public User() {
		
	}

	public User(Long userId, String username, String firstname, String lastname, String email, String password,
			String birthday, String street, String streetNumber, String city, String zip, int role) {
		super();
		this.userId = userId;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.birthday = birthday;
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
		this.zip = zip;
		this.role = role;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	
}
