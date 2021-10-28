package com.cibertec.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Usuario;
import com.cibertec.service.UsuarioService;

@RestController
@RequestMapping("/rest/user")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Usuario>> getAllUser(){
		List<Usuario> listUser = service.retrieveAllUsers();
		return ResponseEntity.ok(listUser);
	}
	
}
