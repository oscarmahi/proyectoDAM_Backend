package com.proyectodam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectodam.model.Ramas;

public interface IRamasRepository extends JpaRepository<Ramas, Integer>{
		
	@Query("SELECT u FROM Ramas u WHERE u.nombre LIKE %?1%")
	public List<Ramas> findByName(String name);	
	

}
