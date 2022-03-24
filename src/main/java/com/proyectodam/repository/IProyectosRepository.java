package com.proyectodam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectodam.model.Proyectos;

public interface IProyectosRepository extends JpaRepository<Proyectos, Integer>{
	
	@Query("SELECT u FROM Proyectos u WHERE u.nombre LIKE %?1%")
	public List<Proyectos> findByName(String name);

}
