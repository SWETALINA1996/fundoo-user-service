package com.bridgelabz.fundoonotes.user.services;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.fundoonotes.user.exceptions.ActivationException;
import com.bridgelabz.fundoonotes.user.exceptions.InvalidIdException;
import com.bridgelabz.fundoonotes.user.exceptions.LoginException;
import com.bridgelabz.fundoonotes.user.exceptions.RegistrationException;
import com.bridgelabz.fundoonotes.user.models.LoginDTO;
import com.bridgelabz.fundoonotes.user.models.RegistrationDTO;
import com.bridgelabz.fundoonotes.user.models.ResetPasswordDTO;

public interface UserService
{
	
	String login(LoginDTO loginDTO , HttpServletResponse resp) throws LoginException;

	void register(RegistrationDTO registrationDTO) throws RegistrationException, MessagingException;
	
	void activate(String token) throws ActivationException;
	
	void forgotPassword(String emailId) throws LoginException, MessagingException;
	
	void resetPassword(String token , ResetPasswordDTO password) throws LoginException, InvalidIdException;

}
