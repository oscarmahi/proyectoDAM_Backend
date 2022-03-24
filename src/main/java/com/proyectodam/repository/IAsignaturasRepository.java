package com.proyectodam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectodam.model.Asignaturas;

public interface IAsignaturasRepository extends JpaRepository<Asignaturas, Integer>{
	
	@Query("SELECT u FROM Asignaturas u WHERE u.nombre LIKE %?1%")
	public List<Asignaturas> findByName(String name);

}
