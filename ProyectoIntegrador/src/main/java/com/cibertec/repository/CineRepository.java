package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.entity.Cine;

public interface CineRepository extends JpaRepository<Cine, Integer> {

	@Query("select c from Cine c where (:p_ciudad is 0 or c.ciudad.idCiudad =:p_ciudad )")
	public List<Cine> fetchCineByCiudad(@Param("p_ciudad") int ciudad);
}
