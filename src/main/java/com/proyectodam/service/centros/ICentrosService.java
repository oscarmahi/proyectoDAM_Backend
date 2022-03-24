package com.proyectodam.service.centros;

import java.util.List;
import java.util.Optional;

import com.proyectodam.model.Centros;

public interface ICentrosService {
	
	public List<Centros> findAll();
	
	public Optional<Centros> findById(int id);
	
	public Centros create(Centros centros);
	
	public Centros update(Centros centros);
	
	void delete (int id);
	
	public List<Centros> findByName(String name);

}
