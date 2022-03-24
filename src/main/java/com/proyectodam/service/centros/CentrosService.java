package com.proyectodam.service.centros;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectodam.model.Centros;
import com.proyectodam.repository.ICentrosRepository;

@Service
public class CentrosService implements ICentrosService{
	
	@Autowired
	private ICentrosRepository centrosRepo;

	@Override
	public List<Centros> findAll() {

		return centrosRepo.findAll();
	}

	@Override
	public Optional<Centros> findById(int id) {

		return centrosRepo.findById(id);
	}

	@Override
	public Centros create(Centros centros) {

		return centrosRepo.save(centros);
	}

	@Override
	public Centros update(Centros centros) {

		return centrosRepo.save(centros);
	}

	@Override
	public void delete(int id) {

		centrosRepo.deleteById(id);
	}

	@Override
	public List<Centros> findByName(String name) {

		return centrosRepo.findByName(name);
	}
	
	

		

}
