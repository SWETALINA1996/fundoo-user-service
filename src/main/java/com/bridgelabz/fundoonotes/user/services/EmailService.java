package com.bridgelabz.fundoonotes.user.services;

import javax.mail.MessagingException;

import com.bridgelabz.fundoonotes.user.models.Email;

public interface EmailService {

	public void sendEmail( Email email) throws MessagingException;
}
