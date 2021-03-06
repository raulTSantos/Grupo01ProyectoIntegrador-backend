package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Compra;
import com.cibertec.service.CompraService;

@RestController
@RequestMapping("/rest/compras")
@CrossOrigin(origins = "http://localhost:4200")
public class CompraController {

	@Autowired
	public CompraService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Compra>> listarCompras(){
		List<Compra> listcompra = service.getAllCompra();
		return ResponseEntity.ok(listcompra);
	}
	
}
