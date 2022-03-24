package com.proyectodam.service.fasesproyectos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectodam.model.Fases_Proyectos;
import com.proyectodam.repository.IFasesProyectosRepository;

@Service
public class FasesProyectosService implements IFasesProyectosService{
	
	@Autowired
	private IFasesProyectosRepository fasesRepo;

	@Override
	public List<Fases_Proyectos> findAll() {

		return fasesRepo.findAll();
	}

	@Override
	public Optional<Fases_Proyectos> findById(int id) {

		return fasesRepo.findById(id);
	}

	@Override
	public Fases_Proyectos create(Fases_Proyectos fases_proyectos) {

		return fasesRepo.save(fases_proyectos);
	}

	@Override
	public Fases_Proyectos update(Fases_Proyectos fases_proyectos) {

		return fasesRepo.save(fases_proyectos);
	}

	@Override
	public void delete(int id) {

		fasesRepo.deleteById(id);
	}

	@Override
	public List<Fases_Proyectos> findByproyecto_id(int proyecto_id) {

		return fasesRepo.findByproyecto_id(proyecto_id);
	}

	
	
	
	
}
