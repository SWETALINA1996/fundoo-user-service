package com.bridgelabz.fundoonotes.user.rabbitmq;

import javax.mail.MessagingException;

import com.bridgelabz.fundoonotes.user.models.Email;

public interface IConsumer {

	public void receiveMessage(Email email) throws MessagingException;
	
	//public Email getMessage();
	
}
