package com.proyectodam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectodam.model.Cursos;

public interface ICursosRepository extends JpaRepository<Cursos, Integer>{
	
	@Query("SELECT u FROM Cursos u WHERE u.nombre LIKE %?1%")
	public List<Cursos> findByName(String name);
}
