package com.bridgelabz.fundoonotes.user.models;


public class ResetPasswordDTO {

	private String newPassword;

	private String confirmNewPassword;
	
	public String getConfirmPassword() {
		return confirmNewPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmNewPassword = confirmPassword;
	}

	public String getPassword() {
		return newPassword;
	}

	public void setPassword(String password) {
		this.newPassword = password;
	}

}
