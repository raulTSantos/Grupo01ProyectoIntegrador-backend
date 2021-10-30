package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Cine;
import com.cibertec.repository.CineRepository;

@Service
public class CineServiceImp  implements CineService{

	@Autowired
	private CineRepository repository;

	@Override
	public List<Cine> getAllCine() {
		
		return repository.findAll();
	}

	@Override
	public List<Cine> getCineByCiudad(int ciudad) {
		
		return  repository.fetchCineByCiudad(ciudad);
	}
	
}
