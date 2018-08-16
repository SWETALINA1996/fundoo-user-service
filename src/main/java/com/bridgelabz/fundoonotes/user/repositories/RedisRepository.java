package com.bridgelabz.fundoonotes.user.repositories;

public interface RedisRepository {
	 
	public String find(String token);

	public void save(String token, String userId);
	
	public void delete(String token);
}
