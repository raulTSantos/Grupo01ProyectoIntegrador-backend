package com.cibertec.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Pelicula;
import com.cibertec.service.PeliculaService;


@RestController
@RequestMapping("/rest/pelicula")
public class PeliculaController {
	
	@Autowired
	private PeliculaService peliculaService;
	
	
	 
	@GetMapping("/consultapelicula")
	@ResponseBody
	public ResponseEntity<Map<String, Object>>consultaPelicula(
			
			@RequestParam(name = "idGenero" , defaultValue = "0" , required = false) int idGenero
			){
		
		Map<String, Object> salida = new HashMap<>();
		List<Pelicula> lista = peliculaService.consultaPelicula( idGenero);
		if(CollectionUtils.isEmpty(lista)) {
            salida.put("mensaje", "No existe pelicula para la consulta");
        } else {
            salida.put("lista", lista);
            salida.put("mensaje", "Existen " + lista.size() + " peliculas");
        }
	
		return ResponseEntity.ok(salida);
	}
		
	}


