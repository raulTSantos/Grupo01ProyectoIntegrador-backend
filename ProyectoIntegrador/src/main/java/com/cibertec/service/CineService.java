package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Cine;
public interface CineService {

	public List<Cine> getAllCine();
	public List<Cine> getCineByCiudad(int ciudad);
}
