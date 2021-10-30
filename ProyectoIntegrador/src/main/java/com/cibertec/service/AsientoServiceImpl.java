package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Asiento;
import com.cibertec.repository.AsientoRepository;

@Service
public class AsientoServiceImpl implements AsientoService{

	@Autowired
	private AsientoRepository repository;
	@Override
	public List<Asiento> getAllAsiento() {
		
		return repository.findAll();
	}

}
