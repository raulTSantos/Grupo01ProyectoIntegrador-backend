package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Ciudad;
import com.cibertec.service.CiudadService;

@RestController
@RequestMapping("/rest/ciudad")
public class CiudadController {

	@Autowired
	private CiudadService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Ciudad>> getTicket(){
		List<Ciudad> listCiudad = service.getAllCiudad();
		return ResponseEntity.ok(listCiudad);
	}
}
