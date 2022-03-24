package com.proyectodam.service.cursos;

import java.util.List;
import java.util.Optional;

import com.proyectodam.model.Cursos;


public interface ICursosService {
	
	public List<Cursos> findAll();
	
	public Optional<Cursos> findById(int id);
	
	public Cursos create(Cursos cursos);
	
	public Cursos update(Cursos cursos);
	
	void delete (int id);
	
	public List<Cursos> findByName(String name);
	

}
