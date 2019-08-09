package com.enlamesa.back;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.enlamesa.back.model.Usuario;
import com.enlamesa.back.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnlamesaApplicationTests {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	public void createUsuarioTest() {
		
		Usuario us = new Usuario();
		us.setUsername("jesus");
		us.setPassword(encoder.encode("jesus"));
		Usuario retorned = usuarioRepository.save(us);
		assert(retorned.getPassword().equals(us.getPassword()));
	}

}
