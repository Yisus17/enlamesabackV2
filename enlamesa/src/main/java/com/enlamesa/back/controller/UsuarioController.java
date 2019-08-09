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

import com.enlamesa.back.model.Usuario;
import com.enlamesa.back.repository.UsuarioRepository;
import com.enlamesa.back.service.UsuarioService;


@RestController
@RequestMapping("/users")
public class UsuarioController {

	private static Logger LOG = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@RequestMapping(method= RequestMethod.GET)
	public List<Usuario> getUsuarios(){
		return usuarioService.getUsuarios();
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public Usuario addUsuario(@RequestBody Usuario user) {
		return usuarioService.createUsuario(user);
	}
	
	@RequestMapping(method= RequestMethod.PUT)
	public Usuario updateUsuario(@RequestBody Usuario user) {
		return usuarioService.updateUsuario(user);
	}
	
	
	@RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
	public void deleteUsuario(@PathVariable("id")Integer id) {
		usuarioService.deleteUsuario(id);
	}

}
