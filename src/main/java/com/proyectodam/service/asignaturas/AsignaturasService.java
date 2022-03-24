package com.proyectodam.service.asignaturas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectodam.model.Asignaturas;
import com.proyectodam.repository.IAsignaturasRepository;

@Service
public class AsignaturasService implements IAsignaturasService{

	@Autowired
	private IAsignaturasRepository asignaturasRepo;

	@Override
	public List<Asignaturas> findAll() {

		return asignaturasRepo.findAll();
	}

	@Override
	public Optional<Asignaturas> findById(int id) {

		return asignaturasRepo.findById(id);
	}

	@Override
	public Asignaturas create(Asignaturas asignaturas) {

		return asignaturasRepo.save(asignaturas);
	}

	@Override
	public Asignaturas update(Asignaturas asignaturas) {

		return asignaturasRepo.save(asignaturas);
	}

	@Override
	public void delete(int id) {

		asignaturasRepo.deleteById(id);
	}

	@Override
	public List<Asignaturas> findByName(String name) {

		return asignaturasRepo.findByName(name);
	}
	
		
	
	
	
	
}
