package com.bridgelabz.fundoonotes.user.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.bridgelabz.fundoonotes.user.models.Email;

@Component
public class EmailServiceImpl implements EmailService {

	@Autowired
	JavaMailSender mailSender;
	
	@Override
	public void sendEmail(Email email) throws MessagingException {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message);
		
		messageHelper.setTo(email.getTo());
		messageHelper.setSubject(email.getSubject());
		messageHelper.setText(email.getText());
		
		mailSender.send(message);

	}

}
