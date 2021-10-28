package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Usuario;

public interface UsuarioService {

	
	public Usuario  createUser(Usuario obj);
	public List<Usuario> retrieveAllUsers();
	
}
