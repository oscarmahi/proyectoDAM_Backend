package com.proyectodam.service.tecnologias;

import java.util.List;
import java.util.Optional;

import com.proyectodam.model.Tecnologias;

public interface ITecnologiasService {
	
	public List<Tecnologias> findAll();
	
	public Optional<Tecnologias> findById(int id);
	
	public Tecnologias create(Tecnologias tecnologias);
	
	public Tecnologias update(Tecnologias tecnologias);
	
	void delete (int id);
	
	public List<Tecnologias> findByName(String name);		

}
