package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Genero;
import com.cibertec.repository.GeneroRepository;

@Service
public class GeneroServiceImpl implements GeneroService{

	@Autowired
	private GeneroRepository repository;
	@Override
	public List<Genero> getAllGenero() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	

}
