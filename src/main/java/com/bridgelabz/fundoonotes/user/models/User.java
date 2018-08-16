package com.bridgelabz.fundoonotes.user.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

//@Document(collection = "Users")
@Document(indexName = "fundoo", type = "user")
public class User 
{
	@Id
	private String userId;

	private String userName;

	private String emailId;

	private String password;

	private String phoneNumber;
	
	private boolean activeStatus;

	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", emailId=" + emailId + ", password=" + password + ", phoneNumber="
				+ phoneNumber + "]";
	}
}
