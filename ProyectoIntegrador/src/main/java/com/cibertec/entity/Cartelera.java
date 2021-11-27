package com.cibertec.entity;


import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="cartelera")
public class Cartelera {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int idCartelera;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="idPelicula") 
	private Pelicula pelicula; 
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="idCine") 
	private Cine cine; 
	
	/*
	 * @JsonFormat(pattern = "yyyy-MM-dd", timezone="America/Lima" )
	 * 
	 * @Temporal(TemporalType.DATE)
	 * 
	 * @DateTimeFormat(pattern = "yyyy-MM-dd")
	 */
	private String fecha;
	
	/*
	 * @JsonFormat(pattern = "HH:mm:ss", timezone="America/Lima" )
	 * 
	 * @Temporal(TemporalType.TIME)
	 * 
	 * @DateTimeFormat(pattern = "HH-mm-ss")
	 */
	private String hora ;
	
	private String descripcion;

	public int getIdCartelera() {
		return idCartelera;
	}

	public void setIdCartelera(int idCartelera) {
		this.idCartelera = idCartelera;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Cine getCine() {
		return cine;
	}

	public void setCine(Cine cine) {
		this.cine = cine;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	} 
	
	
}
