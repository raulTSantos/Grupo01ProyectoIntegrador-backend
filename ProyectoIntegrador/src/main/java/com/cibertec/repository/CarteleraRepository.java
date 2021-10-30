package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.entity.Cartelera;


public interface CarteleraRepository extends JpaRepository< Cartelera, Integer>{
	
	
	@Query("select c from Cartelera c where (:p_peli is 0 or c.pelicula.idPelicula = :p_peli ) and "
	                                     + "(:p_cin  is 0 or c.cine.idCine = :p_cin ) ")
	                                   
	public abstract List<Cartelera> consultarCartelera(@Param("p_peli") int idPelicula ,@Param("p_cin") int idCine);
	

}
