package com.serveplus.web.response;

import java.util.Date;

public class AssignedTo {
	private String fullName;
	private String phoneNumber;
	private Date assignedTime;
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getAssignedTime() {
		return assignedTime;
	}
	public void setAssignedTime(Date assignedTime) {
		this.assignedTime = assignedTime;
	}
	
}
