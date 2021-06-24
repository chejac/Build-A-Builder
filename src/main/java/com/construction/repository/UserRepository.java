package com.construction.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.construction.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	public User findByUsernameIgnoreCase(String username);
	
	public User findByEmailIgnoreCase(String email);
	
}
