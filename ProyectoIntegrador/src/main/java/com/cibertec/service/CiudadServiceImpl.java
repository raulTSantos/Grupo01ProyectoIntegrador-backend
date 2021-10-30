package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Ciudad;
import com.cibertec.repository.CiudadRepository;

@Service
public class CiudadServiceImpl  implements CiudadService{

	@Autowired
	private CiudadRepository repository;
	@Override
	public List<Ciudad> getAllCiudad() {
		
		return repository.findAll();
	}

}
