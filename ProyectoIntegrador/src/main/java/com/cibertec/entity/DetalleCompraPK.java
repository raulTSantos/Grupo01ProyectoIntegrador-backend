package com.cibertec.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DetalleCompraPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name="idCompra", unique = true ,nullable = false, insertable = true ,updatable = false)
	private int idCompra;
	@Column(name="idBoleto", unique = true ,nullable = false, insertable = true ,updatable = false)
	private int idBoleto;
	
	public int getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	public int getIdBoleto() {
		return idBoleto;
	}
	public void setIdBoleto(int idBoleto) {
		this.idBoleto = idBoleto;
	}

	
}
