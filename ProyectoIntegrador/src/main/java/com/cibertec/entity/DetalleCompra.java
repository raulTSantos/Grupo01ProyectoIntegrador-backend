package com.cibertec.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalleCompra")
public class DetalleCompra {

	@EmbeddedId
	private DetalleCompraPK detalleCompraPK;
	@ManyToOne
	@JoinColumn(name = "idCompra", nullable = false, insertable = false,updatable = false)
	private Compra compra;
	@ManyToOne
	@JoinColumn(name = "idBoleto", nullable = false, insertable = false,updatable = false)
	private Boleto boleto;
	
	private int cantidad;

	public DetalleCompraPK getDetalleCompraPK() {
		return detalleCompraPK;
	}

	public void setDetalleCompraPK(DetalleCompraPK detalleCompraPK) {
		this.detalleCompraPK = detalleCompraPK;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Boleto getBoleto() {
		return boleto;
	}

	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
}
