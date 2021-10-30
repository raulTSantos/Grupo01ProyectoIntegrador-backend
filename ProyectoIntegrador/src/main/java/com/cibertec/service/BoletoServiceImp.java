package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Boleto;
import com.cibertec.repository.BoletoRepository;

@Service
public class BoletoServiceImp implements BoletoService {

	@Autowired
	private BoletoRepository repository;
	
	@Override
	public List<Boleto> getAllBoleto() {		
		return repository.findAll();
	}

}
