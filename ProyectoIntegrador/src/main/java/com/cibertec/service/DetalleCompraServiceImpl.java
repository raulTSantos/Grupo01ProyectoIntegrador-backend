package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.DetalleCompra;
import com.cibertec.repository.DetalleCompraRepository;

@Service
public class DetalleCompraServiceImpl implements DetalleCompraService {

	@Autowired
	private DetalleCompraRepository repository;

	@Override
	public List<DetalleCompra> getDetalleCompra() {
		// TODO Auto-generated method stub
		return  repository.findAll();
	}

	@Override
	public DetalleCompra saveDetalleCompra(DetalleCompra obj) {
		
		return repository.save(obj);
	}
	
	
}
