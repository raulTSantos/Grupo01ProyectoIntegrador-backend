package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Boleto;
import com.cibertec.service.BoletoService;

@RestController
@RequestMapping("/rest/ticket")
public class BoletoController {

	@Autowired
	private BoletoService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Boleto>> getTicket(){
		List<Boleto> listBoleto = service.getAllBoleto();
		return ResponseEntity.ok(listBoleto);
	}
	
}
