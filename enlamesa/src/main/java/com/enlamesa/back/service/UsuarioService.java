package com.enlamesa.back.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.enlamesa.back.model.Usuario;
import com.enlamesa.back.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario createUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario updateUsuario(Usuario usuario) {
		int idUsuario = usuario.getIdUsuario();
		Optional<Usuario> usuarioFromBDOptional = usuarioRepository.findById(idUsuario);
		
		if(usuarioFromBDOptional.isPresent()) {
			Usuario usuarioFromBD = usuarioFromBDOptional.get();
			usuarioFromBD.setUsername(usuario.getUsername());
			usuarioFromBD.setPassword(usuario.getPassword());
			return usuarioRepository.save(usuarioFromBD);
		}else {
			return usuarioRepository.save(usuario);
		}

	}

	public void deleteUsuario(int idUsuario) {
		if(usuarioRepository.existsById(idUsuario)) {
			usuarioRepository.deleteById(idUsuario);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username);
		
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		
		UserDetails userDet = new User(usuario.getUsername(),usuario.getPassword(), roles);
		return userDet;
	}
	
	
}
