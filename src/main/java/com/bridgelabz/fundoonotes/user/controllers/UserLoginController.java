package com.bridgelabz.fundoonotes.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundoonotes.user.services.FacebookService;

@RestController
public class UserLoginController {

	@Autowired
	private FacebookService facebookService;
	
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
