package com.bridgelabz.fundoonotes.user.utility;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bridgelabz.fundoonotes.user.exceptions.LoginException;
import com.bridgelabz.fundoonotes.user.exceptions.RegistrationException;
import com.bridgelabz.fundoonotes.user.models.LoginDTO;
import com.bridgelabz.fundoonotes.user.models.RegistrationDTO;

public class Utility {

	// RegEx for EmailId Validation
	public static Pattern EMAIL_ID_Validate = Pattern
			.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

	// RegEx for Password Validation
	public static Pattern PASSWORD_Validate = Pattern
			.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}");

	/**
	 * @param registrationDTO
	 * @return
	 * @throws RegistrationException
	 */
	public static void isRegistrationValidate(RegistrationDTO registrationDTO) throws RegistrationException {
		
		if(registrationDTO.getUserName() == null || registrationDTO.getPhoneNumber() == null
				|| registrationDTO.getEmailId() == null || registrationDTO.getPassword() == null 
				|| registrationDTO.getConfirmPassword() == null) {
			throw new RegistrationException("FillUp all the fields");
		}
		
		if (registrationDTO.getUserName().length() <= 3) {
			throw new RegistrationException("Username should contain more than 3 characters");
		}

		else if (registrationDTO.getPhoneNumber().length() != 10) {
			throw new RegistrationException("Phone Number should be of minimum 10 digits");
		}
		else if (!isValidEmail(registrationDTO.getEmailId())) {
			
			throw new RegistrationException("EmailId must be in 'abcd@mail.com' format");
		} else if (registrationDTO.getPassword().length() < 8) {
			
			throw new RegistrationException("Password must contain 8 characters");
		} else if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
			
			throw new RegistrationException("Both Passwords does not match..");
		}

	}
	
	/**
	 * @param loginDto
	 * @throws LoginException
	 */
	public static void isLoginValidate(LoginDTO loginDto) throws LoginException {
		
		if(loginDto.getEmailId() == null || loginDto.getPassword() == null) {
			throw new LoginException("Fill all the fields");
		}
		
		if(!isValidEmail(loginDto.getEmailId())) {
			throw new LoginException("Emaild is invalid");
		}
		
		/*if(!isValidPassword(loginDto.getPassword())) {
			throw new LoginException("Password is invalid");
		}*/
	}

	/**
	 * @param emailId
	 * @return
	 */
	public static boolean isValidEmail(String emailId) {
		Matcher matcher = EMAIL_ID_Validate.matcher(emailId);
		return matcher.find();
	}

	/**
	 * @param password
	 * @return
	 */
	public static boolean isValidPassword(String password) {
		Matcher matcher = PASSWORD_Validate.matcher(password);
		return matcher.find();
	}

    public static String generateUUID() {
        
        UUID key = UUID.randomUUID();
        return key.toString();
    }

}
