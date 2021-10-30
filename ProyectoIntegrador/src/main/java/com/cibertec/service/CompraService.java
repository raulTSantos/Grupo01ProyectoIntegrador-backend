package com.cibertec.service;

import java.util.List;
import com.cibertec.entity.Compra;

public interface CompraService {

	public List<Compra > getAllCompra();

	public Compra saveCompra(Compra compra);
}
