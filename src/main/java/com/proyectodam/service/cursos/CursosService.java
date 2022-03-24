package com.proyectodam.service.cursos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectodam.model.Cursos;
import com.proyectodam.repository.ICursosRepository;

@Service
public class CursosService implements ICursosService{
	
	@Autowired
	private ICursosRepository cursosRepo;

	@Override
	public List<Cursos> findAll() {

		return cursosRepo.findAll();
	}

	@Override
	public Optional<Cursos> findById(int id) {

		return cursosRepo.findById(id);
	}

	@Override
	public Cursos create(Cursos cursos) {

		return cursosRepo.save(cursos);
	}

	@Override
	public Cursos update(Cursos cursos) {

		return cursosRepo.save(cursos);
	}

	@Override
	public void delete(int id) {
		cursosRepo.deleteById(id);
		
	}

	@Override
	public List<Cursos> findByName(String name) {

		return cursosRepo.findByName(name);
	}

	
	
	
}
