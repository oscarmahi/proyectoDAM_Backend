package com.proyectodam.service.ramas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectodam.model.Ramas;
import com.proyectodam.repository.IRamasRepository;

@Service
public class RamasService implements IRamasService{

	@Autowired
	private IRamasRepository ramasRepo;

	@Override
	public List<Ramas> findAll() {

		return ramasRepo.findAll();
	}

	@Override
	public Optional<Ramas> findById(int id) {

		return ramasRepo.findById(id);
	}

	@Override
	public Ramas create(Ramas ramas) {

		return ramasRepo.save(ramas);
	}

	@Override
	public Ramas update(Ramas ramas) {

		return ramasRepo.save(ramas);
	}

	@Override
	public void delete(int id) {

		ramasRepo.deleteById(id);
	}

	@Override
	public List<Ramas> findByName(String name) {

		return ramasRepo.findByName(name);
	}
	
	

	
}
