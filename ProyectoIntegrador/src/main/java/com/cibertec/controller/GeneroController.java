package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Genero;

import com.cibertec.service.GeneroService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest/generos")
public class GeneroController {

	@Autowired
	private GeneroService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Genero>> getTicket(){
		List<Genero> listBoleto = service.getAllGenero();
		return ResponseEntity.ok(listBoleto);
	}
}
