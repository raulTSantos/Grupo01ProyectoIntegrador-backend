package com.cibertec.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Usuario;
import com.cibertec.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private  UsuarioRepository repository;
	
	@Override
	public Usuario createUser(Usuario obj) {
		
		return repository.save(obj);
	}

	@Override
	public List<Usuario> retrieveAllUsers() {
		
		return repository.findAll();
	}

	@Override
	public Optional<Usuario> login(String email, String password) {
		return repository.findByEmailAndPassword(email, password);
	}

	@Override
	public Optional<Usuario> findUserById(int id) {
		
		return repository.findById(id);
	}

	@Override
	public void deleteUser(int id) {
		 repository.deleteById(id);
		
	}

	@Override
	public Usuario obtenerEmail(String email) {
		// TODO Auto-generated method stub
		return repository.findByEmail(email);
	}
	

}
