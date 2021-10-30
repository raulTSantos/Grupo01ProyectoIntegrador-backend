package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.entity.Usuario;

public interface UsuarioService {

	public Usuario  createUser(Usuario obj);
	public List<Usuario> retrieveAllUsers();
	public  Optional<Usuario> findUserById(int id);
	public void deleteUser(int id);
	public  Optional<Usuario> login(String email ,String password);
	
}
