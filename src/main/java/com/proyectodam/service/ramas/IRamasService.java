package com.proyectodam.service.ramas;

import java.util.List;
import java.util.Optional;

import com.proyectodam.model.Ramas;

public interface IRamasService {
	
	public List<Ramas> findAll();
	
	public Optional<Ramas> findById(int id);
	
	public Ramas create(Ramas ramas);
	
	public Ramas update(Ramas ramas);
	
	void delete (int id);
	
	public List<Ramas> findByName(String name);		

}
