package com.proyectodam.service.fasesproyectos;

import java.util.List;
import java.util.Optional;

import com.proyectodam.model.Fases_Proyectos;


public interface IFasesProyectosService {

	public List<Fases_Proyectos> findAll();
	
	public Optional<Fases_Proyectos> findById(int id);
	
	public Fases_Proyectos create(Fases_Proyectos fases_proyectos);
	
	public Fases_Proyectos update(Fases_Proyectos fases_proyectos);
	
	void delete (int id);
	
	public List<Fases_Proyectos> findByproyecto_id(int proyecto_id);
	
	
}
