package com.bridgelabz.fundoonotes.user.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bridgelabz.fundoonotes.user.services.EmailService;
import com.bridgelabz.fundoonotes.user.services.EmailServiceImpl;

@Configuration
public class UserConfig {

	@Bean
	public PasswordEncoder pwdEncoder() {
		return new BCryptPasswordEncoder();
	}	
	
	@Bean
	@Scope("prototype")
	public EmailService emailService() {
		return new EmailServiceImpl();
	}
	
	@Bean
	//@Scope("prototype")
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
