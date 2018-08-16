package com.bridgelabz.fundoonotes.user.controllers;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundoonotes.user.exceptions.ActivationException;
import com.bridgelabz.fundoonotes.user.exceptions.InvalidIdException;
import com.bridgelabz.fundoonotes.user.exceptions.LoginException;
import com.bridgelabz.fundoonotes.user.exceptions.RegistrationException;
import com.bridgelabz.fundoonotes.user.models.LoginDTO;
import com.bridgelabz.fundoonotes.user.models.RegistrationDTO;
import com.bridgelabz.fundoonotes.user.models.ResetPasswordDTO;
import com.bridgelabz.fundoonotes.user.models.Response;
import com.bridgelabz.fundoonotes.user.services.FacebookService;
import com.bridgelabz.fundoonotes.user.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private FacebookService facebookService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Response> login(@RequestBody LoginDTO loginDTO , HttpServletResponse resp) throws LoginException, com.bridgelabz.fundoonotes.user.exceptions.LoginException {
		
		userService.login(loginDTO , resp);
		Response dto = new Response();
		dto.setMessage("successfully logged in");
		dto.setStatus(1);
		
		return new ResponseEntity<Response>(dto, HttpStatus.OK);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Response> register(@RequestBody RegistrationDTO registrationDTO)
			throws RegistrationException, MessagingException {
		
		userService.register(registrationDTO);
		Response dto = new Response();
		dto.setMessage("Successfully Registered");
		dto.setStatus(2);
		
		return new ResponseEntity<Response>(dto, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/activate" , method = RequestMethod.GET)
	public ResponseEntity<Response> activateUser(@RequestParam(value = "token") String token ) throws ActivationException{
				
		userService.activate(token);
		Response dto = new Response();
		dto.setMessage("Activated User");
		dto.setStatus(3);
		
		return new ResponseEntity<Response>(dto , HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/forgotPassword" , method = RequestMethod.POST)
	public ResponseEntity<Response> forgotPassword(@RequestParam(value = "emailId") String emailId ) throws LoginException, MessagingException{
		
		userService.forgotPassword(emailId);
		Response dto = new Response();
		dto.setMessage("Link sent to change the password");
		dto.setStatus(4);
		
		return new ResponseEntity<Response>(dto , HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/resetPassword")
	public ResponseEntity<Response> resetPassword(@RequestParam(value = "token") String token , @RequestBody ResetPasswordDTO resetDTO) throws LoginException, MessagingException, InvalidIdException{
		
		userService.resetPassword(token, resetDTO);
		Response dto = new Response();
		dto.setMessage("Password has been successfully reset.");
		dto.setStatus(5);
		
		return new ResponseEntity<Response>(dto , HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/createFacebookAuthorization")
    public String createFacebookAuthorization() {
        return facebookService.createFacebookAuthorizationURL();
    }

    @GetMapping(value = "/facebook")
    public void createFacebookAccessToken(@RequestParam String code) {
        facebookService.createFacebookAccessToken(code);
    }

    @GetMapping(value = "/getName")
    public String getNameResponse() {
        return facebookService.getName();
    }



}
