package com.proyectodam.service.asignaturas;

import java.util.List;
import java.util.Optional;

import com.proyectodam.model.Asignaturas;

public interface IAsignaturasService {
	
	public List<Asignaturas> findAll();
	
	public Optional<Asignaturas> findById(int id);
	
	public Asignaturas create(Asignaturas asignaturas);
	
	public Asignaturas update(Asignaturas asignaturas);
	
	void delete (int id);
	
	public List<Asignaturas> findByName(String name);	

}
