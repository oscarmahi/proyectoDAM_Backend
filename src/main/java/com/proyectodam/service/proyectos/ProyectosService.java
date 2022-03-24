package com.proyectodam.service.proyectos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectodam.model.Proyectos;
import com.proyectodam.repository.IProyectosRepository;

@Service
public class ProyectosService implements IProyectosService{
	
	@Autowired
	private IProyectosRepository proyectosRepo;

	@Override
	public List<Proyectos> findAll() {

		return proyectosRepo.findAll();
	}

	@Override
	public Optional<Proyectos> findById(int id) {

		return proyectosRepo.findById(id);
	}

	@Override
	public Proyectos create(Proyectos proyectos) {

		return proyectosRepo.save(proyectos);
	}

	@Override
	public Proyectos update(Proyectos proyectos) {

		return proyectosRepo.save(proyectos);
	}

	@Override
	public void delete(int id) {
		
		proyectosRepo.deleteById(id);
		
	}

	@Override
	public List<Proyectos> findByName(String name) {
		
		return proyectosRepo.findByName(name);
	}

}
