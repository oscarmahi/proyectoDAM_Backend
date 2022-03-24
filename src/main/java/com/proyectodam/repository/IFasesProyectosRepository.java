package com.proyectodam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectodam.model.Fases_Proyectos;

public interface IFasesProyectosRepository extends JpaRepository<Fases_Proyectos, Integer>{
		
	//@Query("SELECT u FROM Fases_Proyectos u WHERE u.proyecto_id = ?1")
	//public List<Fases_Proyectos> findByproyecto_id(int proyecto_id);

	@Query(value="SELECT * FROM Fases_Proyectos WHERE proyecto_id = ?", nativeQuery= true)
	public List<Fases_Proyectos> findByproyecto_id(int proyecto_id);

	
}
