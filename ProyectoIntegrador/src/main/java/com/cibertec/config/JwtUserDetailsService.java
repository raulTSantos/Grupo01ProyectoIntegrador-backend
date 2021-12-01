package com.cibertec.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Usuario;
import com.cibertec.repository.UsuarioRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private  UsuarioRepository repository;
	@Autowired
	private PasswordEncoder bcryptEncoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario objUsuario = repository.findByEmail(username);
		/*if ("securityJWT".equals(username)) {
			return new User("securityJWT", "$2a$10$ixlPY3AAd4ty1l6E2IsQ9OFZi2ba9ZQE0bP7RFcGIWNhyFrrT3YUi",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}*/
		if (objUsuario == null) {
			throw new UsernameNotFoundException("User not found with email: " + username);
		}
		return new org.springframework.security.core.userdetails.User(objUsuario.getEmail(), objUsuario.getPassword(),
				new ArrayList<>());
	}
	public Usuario  save(Usuario  user) {
		Usuario  newUser = new Usuario ();
		newUser.setDni(user.getDni());
		newUser.setAmaterno(user.getAmaterno());
		newUser.setApaterno(user.getApaterno());
		newUser.setLogin(user.getLogin());
		newUser.setNombres(user.getNombres());
		
		newUser.setEmail(user.getEmail());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return  repository.save(newUser);
	}

}