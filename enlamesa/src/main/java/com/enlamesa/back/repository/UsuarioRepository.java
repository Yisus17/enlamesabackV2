package com.enlamesa.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enlamesa.back.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByUsername(String username);
	
}
