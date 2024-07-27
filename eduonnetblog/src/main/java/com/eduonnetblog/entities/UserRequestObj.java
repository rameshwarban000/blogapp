package com.eduonnetblog.entities;

import org.springframework.util.StringUtils;

public class UserRequestObj {

	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private long mobNumber;
	private int role;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public long getMobNumber() {
		return mobNumber;
	}
	public void setMobNumber(long mobNumber) {
		this.mobNumber = mobNumber;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
	public static User prepareUser(UserRequestObj userRequestObj) {
		if(userRequestObj != null) {
			User user = new User();
			user.setFirstName(userRequestObj.getFirstName());
			if(StringUtils.hasText(userRequestObj.getLastName())) user.setLastName(userRequestObj.getLastName());
			
			user.setEmail(userRequestObj.getEmail());
			if(userRequestObj.getMobNumber() != 0) user.setMobNumber(userRequestObj.getMobNumber());
			user.setRole(userRequestObj.getRole());
			return user;
		}
		return null;
	}
}
