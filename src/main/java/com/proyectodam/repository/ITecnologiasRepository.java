package com.proyectodam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectodam.model.Tecnologias;

public interface ITecnologiasRepository extends JpaRepository<Tecnologias, Integer>{

	@Query("SELECT u FROM Tecnologias u WHERE u.nombre LIKE %?1%")
	public List<Tecnologias> findByName(String name);	
}
