package com.bridgelabz.fundoonotes.user.repositories;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRepositoryImpl implements RedisRepository {
	  
	   private static final String KEY = "TOKEN";
      
	   //autowire
	    private RedisTemplate<String, String> redisTemplate;
	   
	    private HashOperations<String, String, String> hashOperations;
	   
	    @Autowired
	    public RedisRepositoryImpl(RedisTemplate<String, String> redisTemplate) {
	        this.redisTemplate = redisTemplate;
	    }
	   
	    @PostConstruct
	    private void init() {
	        hashOperations = redisTemplate.opsForHash();
	    }
	 
	    @Override
	    public void save(String token, String userId) {
	        hashOperations.put(KEY, token, userId);
	    }
	 
	    @Override
	    public String find(String token) {
	        return hashOperations.get(KEY, token);
	    }

	    @Override
	    public void delete(String token) {
	        hashOperations.delete(KEY, token);
	    }
}
