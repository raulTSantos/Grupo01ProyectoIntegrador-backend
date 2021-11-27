package com.cibertec.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.config.JwtTokenUtil;
import com.cibertec.entity.Usuario;
import com.cibertec.service.UsuarioService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Usuario>> getAllUser(){
		List<Usuario> listUser = service.retrieveAllUsers();
		return ResponseEntity.ok(listUser);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> createNewUser(@RequestBody Usuario user){
		Map<String, Object> salida = new HashMap<>();
		try {
			Optional<Usuario> optUser=service.login(user.getEmail(),user.getPassword());
			
			Usuario objSalida = service.createUser(user);
					
			if (objSalida == null) {
				salida.put("mensaje", "ERROR AL REGISTRAR");
			} else {
				salida.put("mensaje", "REGISTRO EXITOSO");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje",  "No se pudo registrar");
		}
		
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping()
	@ResponseBody
	public ResponseEntity<Map<String, Object>> updateUser(@RequestBody Usuario user){
		Map<String, Object> salida = new HashMap<>();
		try {
			Optional<Usuario> optUser=service.findUserById(user.getIdUsuario());
					
			if (optUser.isPresent()) {
				salida.put("mensaje", "EDITADO EXITOSAMENTE");
				
			} else {
				salida.put("mensaje", "ERROR AL EDITAR");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje",  "No se pudo editar");
		}
		
		return ResponseEntity.ok(salida);
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> deleteUser(@RequestBody int id){
		Map<String, Object> salida = new HashMap<>();
		try {
			Optional<Usuario> optUser=service.findUserById(id);
					
			if (optUser.isPresent()) {
				service.deleteUser(id);
				salida.put("mensaje", "Borrado");
			} else {
				salida.put("mensaje", "ERROR AL Eliminar");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje",  "No se pudo Eliminar");
		}
		
		return ResponseEntity.ok(salida);
	}
	
	
}
