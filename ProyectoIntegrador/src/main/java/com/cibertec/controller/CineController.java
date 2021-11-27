package com.cibertec.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Cine;
import com.cibertec.service.CineService;


@RestController
@RequestMapping("/rest/cines")
@CrossOrigin(origins = "http://localhost:4200")
public class CineController {

	
	@Autowired
	private CineService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Cine>> getCine(){
		List<Cine> listCine = service.getAllCine();
		return ResponseEntity.ok(listCine);
	}
	
	@GetMapping("/listCineByCiudad")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> fetchCineByCiudad(@RequestParam(name="idCiudad",defaultValue ="0",required = false  )int ciudad){
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Cine> lstCines= service.getCineByCiudad(ciudad);
			if(CollectionUtils.isEmpty(lstCines)) {
				salida.put("msj","No existe Cine" );
			}else {
				salida.put("lista", lstCines);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("msj", "Ocurrio un Error");
		}
		return ResponseEntity.ok(salida);
	}

	
}
