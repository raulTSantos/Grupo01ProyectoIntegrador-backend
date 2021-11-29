package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Cartelera;

public interface CarteleraService  {
	
	public  List<Cartelera>consultarCartelera(int idPelicula,int idCine);
	public List<Cartelera> getAllCartelera();

}
