package com.enlamesa.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.enlamesa.back.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUsername(String username);
	
	//@Query("select u from Usuario u where u.username=1")
	//public User findByUsername2(String username);
	
}
