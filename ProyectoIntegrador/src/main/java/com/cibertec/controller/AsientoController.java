package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Asiento;
import com.cibertec.service.AsientoService;

@RestController
@RequestMapping("/rest/asientos")
public class AsientoController {

	@Autowired
	private AsientoService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Asiento>> getAllUser(){
		List<Asiento> listAsiento = service.getAllAsiento();
		return ResponseEntity.ok(listAsiento);
	}
}
