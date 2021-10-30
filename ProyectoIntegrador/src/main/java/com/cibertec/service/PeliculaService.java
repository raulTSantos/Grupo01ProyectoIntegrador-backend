package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Pelicula;

public interface PeliculaService {
	
	public List<Pelicula>listarPelicula ();
	public List<Pelicula>consultaPelicula( int idGenero);

}
