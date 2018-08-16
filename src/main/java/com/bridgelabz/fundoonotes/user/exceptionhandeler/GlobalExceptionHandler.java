package com.bridgelabz.fundoonotes.user.exceptionhandeler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.fundoonotes.user.controllers.UserController;
import com.bridgelabz.fundoonotes.user.exceptions.ActivationException;
import com.bridgelabz.fundoonotes.user.exceptions.InvalidIdException;
import com.bridgelabz.fundoonotes.user.exceptions.LoginException;
import com.bridgelabz.fundoonotes.user.exceptions.RegistrationException;
import com.bridgelabz.fundoonotes.user.models.Response;

@ControllerAdvice
public class GlobalExceptionHandler {

	public static final Logger logger = LoggerFactory.getLogger(UserController.class);

	  @ExceptionHandler(RegistrationException.class)
	    public ResponseEntity<Response> handleRegistrationException(RegistrationException e) {
	       
		  logger.error(e.getMessage());
		  
		  Response response = new Response();
	        response.setMessage(e.getMessage());
	        response.setStatus(-3);
	        return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
	    }

	    @ExceptionHandler(LoginException.class)
	    public ResponseEntity<Response> handleLoginException(LoginException e) {
	    	
	    	logger.error(e.getMessage());
	    	
	        Response response = new Response();
	        response.setMessage(e.getMessage());
	        response.setStatus(-2);
	        return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
	    }
	    
	    @ExceptionHandler(ActivationException.class)
	    public ResponseEntity<Response> handleActivationException(ActivationException e) {
	    	
	    	logger.error(e.getMessage());
	    	
	        Response response = new Response();
	        response.setMessage(e.getMessage());
	        response.setStatus(-4);
	        return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
	    }
	    
	    @ExceptionHandler(InvalidIdException.class)
	    public ResponseEntity<Response> handleActivationException(InvalidIdException e) {
	    	
	    	logger.error(e.getMessage());
	    	
	        Response response = new Response();
	        response.setMessage(e.getMessage());
	        response.setStatus(-5);
	        return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<Response> handleGenericExceptions(Exception e) {
	    	
	    	logger.error(e.toString());
	    	
	        Response response = new Response();
	        response.setMessage("Something went wrong");
	        response.setStatus(-1);
	        return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	
}
