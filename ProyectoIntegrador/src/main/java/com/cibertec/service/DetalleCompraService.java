package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.DetalleCompra;

public interface DetalleCompraService {

	public List<DetalleCompra> getDetalleCompra();
	public DetalleCompra saveDetalleCompra(DetalleCompra obj);

}