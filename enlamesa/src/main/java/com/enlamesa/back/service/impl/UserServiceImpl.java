package com.enlamesa.back.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enlamesa.back.model.User;
import com.enlamesa.back.repository.UserRepository;
import com.enlamesa.back.service.UserService;

@Service
public class UserServiceImpl implements UserService , UserDetailsService{
	
	Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public User updateUser(User user) {
		int idUser = user.getIdUser();
		Optional<User> userFromBDOptional = userRepository.findById(idUser);
		
		if(userFromBDOptional.isPresent()) {
			User userFromBD = userFromBDOptional.get();
			userFromBD.setUsername(user.getUsername());
			userFromBD.setPassword(user.getPassword());
			return userRepository.save(userFromBD);
		}else {
			return userRepository.save(user);
		}

	}

	@Override
	public void deleteUser(int idUser) {
		if(userRepository.existsById(idUser)) {
			userRepository.deleteById(idUser);
		}
	}

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username);
		if(user == null) {
			logger.error("No existe el usuario: "+username);
			throw new UsernameNotFoundException("No existe el usuario: "+username);
		}
		
		List<GrantedAuthority> authorities = user.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.peek(authority-> logger.info("Role: "+ authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), user.getEnabled(), true, true, true, authorities);
	}
	
	
}
