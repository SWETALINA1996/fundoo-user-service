package com.bridgelabz.fundoonotes.user.repositories;

import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.bridgelabz.fundoonotes.user.models.User;

public interface UserESRepository extends ElasticsearchRepository<User , String>{

	public Optional<User> findByEmailId(String emailId);
}
