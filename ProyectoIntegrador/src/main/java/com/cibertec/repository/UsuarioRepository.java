package com.cibertec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cibertec.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
	
	
	public Optional<Usuario> findByEmailAndPassword(String email ,String password);
}
