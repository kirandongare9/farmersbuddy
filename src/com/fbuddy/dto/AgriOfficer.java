package com.fbuddy.dto;

public class AgriOfficer {

	private User user;
	private String qualification;
	private String designation;
	
	public AgriOfficer() {
		this.user = new User();
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	
}
