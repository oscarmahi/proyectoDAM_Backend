package com.proyectodam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectodam.model.Centros;

public interface ICentrosRepository extends JpaRepository<Centros, Integer>{
	
	@Query("SELECT u FROM Centros u WHERE u.nombre LIKE %?1%")
	public List<Centros> findByName(String name);


}
