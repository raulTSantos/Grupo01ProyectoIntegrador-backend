package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.entity.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer>{

}
