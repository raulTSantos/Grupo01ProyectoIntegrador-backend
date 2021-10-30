package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Pelicula;
import com.cibertec.repository.PeliculaRepository;

@Service
public class PeliculaServiceImpl implements PeliculaService{

	@Autowired
	private PeliculaRepository repository;
	
	@Override
	public List<Pelicula> listarPelicula() {
		
		return repository.findAll();
	}

	@Override
	public List<Pelicula> consultaPelicula( int idGenero) {
		
		return repository.consultaPelicula(idGenero);
	}
	
	

}
