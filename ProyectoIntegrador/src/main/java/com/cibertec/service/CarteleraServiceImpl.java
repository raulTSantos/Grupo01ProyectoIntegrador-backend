package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Cartelera;
import com.cibertec.repository.CarteleraRepository;

@Service
public class CarteleraServiceImpl implements CarteleraService{

	
	    @Autowired
	    private CarteleraRepository repository;
	
	@Override
	public List<Cartelera> consultarCartelera(int idPelicula, int idCine) {
		
		return repository.consultarCartelera(idPelicula, idCine) ;
	}

}
