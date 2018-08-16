package com.bridgelabz.fundoonotes.user.models;

public class RegistrationDTO {

	private String userName;

	private String emailId;

	private String phoneNumber;

	private String password;

	private String confirmPassword;

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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

	/*
	 * @Override public String toString() { return "User [userName=" + userName +
	 * ", emailId=" + emailId + ", password=" + password + ", phoneNumber=" +
	 * phoneNumber + "]"; }
	 */
}
