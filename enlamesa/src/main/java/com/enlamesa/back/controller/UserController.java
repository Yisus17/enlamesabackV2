package com.enlamesa.back.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enlamesa.back.model.User;
import com.enlamesa.back.repository.UserRepository;


@RestController
@RequestMapping("/users")
public class UserController {

	private static Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(method= RequestMethod.GET)
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public void addUser(@RequestBody User user) {
		userRepository.save(user);
	}
	
	@RequestMapping(method= RequestMethod.PUT)
	public void editUser(@RequestBody User user) {
		userRepository.save(user);
	}
	
	
	@RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id")Integer id) {
		userRepository.deleteById(id);
	}

}
