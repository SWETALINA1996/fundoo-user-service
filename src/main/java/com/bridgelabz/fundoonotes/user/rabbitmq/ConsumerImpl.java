package com.bridgelabz.fundoonotes.user.rabbitmq;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bridgelabz.fundoonotes.user.models.Email;
import com.bridgelabz.fundoonotes.user.services.EmailService;

@Component
public class ConsumerImpl implements IConsumer {
	
	@Autowired
	EmailService emailService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerImpl.class);
	
	@RabbitListener(queues="jsa.queue",containerFactory="jsaFactory")
	public void receiveMessage(Email email) throws MessagingException {
		System.out.println("Inside receie message");
		emailService.sendEmail(email);
		LOGGER.info(email.toString());
		System.out.println("outside receie message");
	}
	
	
}
