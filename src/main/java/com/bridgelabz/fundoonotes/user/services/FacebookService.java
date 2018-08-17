package com.bridgelabz.fundoonotes.user.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoonotes.user.models.User;
import com.bridgelabz.fundoonotes.user.models.UserLogin;
import com.bridgelabz.fundoonotes.user.repositories.UserESRepository;
import com.bridgelabz.fundoonotes.user.repositories.UserRepository;
import com.bridgelabz.fundoonotes.user.security.JWTtokenProvider;

@Service
public class FacebookService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserESRepository esUser;

	@Autowired
	private JWTtokenProvider tokenProvider;

	String accessToken;

	@Value("${spring.social.facebook.appId}")
	String facebookAppId;

	@Value("${spring.social.facebook.appSecret}")
	String facebookSecret;

	public String getName() {
	        Facebook facebook = new FacebookTemplate(accessToken);
	        String[] fields = { "id", "email" };
	        
	        UserLogin userFields = facebook.fetchObject("me", UserLogin.class, fields);
	        Optional<User> optionalUser = esUser.findByEmailId(userFields.getEmail());
	        if(!optionalUser.isPresent()) {
	        	User user = new User();
	        	user.setEmailId(userFields.getEmail());
	        	user.setUserName(userFields.getName());
	        	
	        	userRepository.save(user);
	        	esUser.save(user);
	        	
	        	return tokenProvider.generator(user.getUserId());
	        }
	        
	        return tokenProvider.generator(userFields.getId());

}

	public String createFacebookAuthorizationURL() {
		FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(facebookAppId, facebookSecret);
		OAuth2Operations oauthOperations = connectionFactory.getOAuthOperations();
		OAuth2Parameters params = new OAuth2Parameters();
		params.setRedirectUri(
				"http://localhost:8200/swagger-ui.html#!/facebook-login-controller/createFacebookAccessToken");
		params.setScope("public_profile,email,user_birthday");
		return oauthOperations.buildAuthorizeUrl(params);
	}

	public void createFacebookAccessToken(String code) {
		FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(facebookAppId, facebookSecret);
		AccessGrant accessGrant = connectionFactory.getOAuthOperations().exchangeForAccess(code,
				"http://localhost:8200/swagger-ui.html#!/facebook-login-controller/createFacebookAccessToken",
				null);
		accessToken = accessGrant.getAccessToken();
	}
}
