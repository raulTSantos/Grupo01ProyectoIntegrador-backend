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

import com.cibertec.entity.Cartelera;
import com.cibertec.service.CarteleraService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest/carteleras")
public class CarteleraController {
	
	@Autowired
	private CarteleraService service ;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Cartelera>> getCine(){
		List<Cartelera> listCine = service.getAllCartelera();
		return ResponseEntity.ok(listCine);
	}

	@GetMapping("filtroCinePelicula")
	@ResponseBody
	public ResponseEntity<Map<String,Object>> listaCartelera(
			@RequestParam(name ="idPelicula",defaultValue = "0", required = false) int idPelicula,
			@RequestParam(name ="idCine",defaultValue = "0", required = false) int idCine
			
			){
		Map<String,Object> salida = new HashMap<>();
		
		List<Cartelera> lista = service.consultarCartelera( idPelicula , idCine);
        if(CollectionUtils.isEmpty(lista)) {
            salida.put("mensaje", "No existe cliente para la consulta");
        } else {
            salida.put("lista", lista);
            salida.put("mensaje", "Existen " + lista.size() + " clientes");
        }
		return ResponseEntity.ok(salida);
	}
	
	

}
