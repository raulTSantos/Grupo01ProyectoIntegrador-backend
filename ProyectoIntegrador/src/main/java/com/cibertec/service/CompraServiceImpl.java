package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Compra;
import com.cibertec.repository.CompraRepository;


@Service
public class CompraServiceImpl implements CompraService {

	@Autowired
	private  CompraRepository repository;
	
	@Override
	public List<Compra> getAllCompra() {	
		return repository.findAll();
	}

	@Override
	public Compra saveCompra(Compra compra) {
		
		return repository.save(compra);
	}

}
