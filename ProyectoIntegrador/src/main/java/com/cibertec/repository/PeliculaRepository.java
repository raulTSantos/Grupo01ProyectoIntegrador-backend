package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.entity.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {

	@Query("Select e from Pelicula e where ( :p_gen is 0 or  e.genero.idGenero = :p_gen)")
	public abstract List<Pelicula> consultaPelicula(@Param("p_gen") int idGenero);

}
