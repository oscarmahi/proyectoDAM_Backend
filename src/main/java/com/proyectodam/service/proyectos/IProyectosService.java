package com.proyectodam.service.proyectos;

import java.util.List;
import java.util.Optional;

import com.proyectodam.model.Proyectos;


public interface IProyectosService {
	
	public List<Proyectos> findAll();
	
	public Optional<Proyectos> findById(int id);
	
	public Proyectos create(Proyectos proyectos);
	
	public Proyectos update(Proyectos proyectos);
	
	void delete (int id);
	
	public List<Proyectos> findByName(String name);
	

}
