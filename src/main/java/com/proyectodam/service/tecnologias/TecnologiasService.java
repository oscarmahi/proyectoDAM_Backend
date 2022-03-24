package com.proyectodam.service.tecnologias;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectodam.model.Tecnologias;
import com.proyectodam.repository.ITecnologiasRepository;

@Service
public class TecnologiasService implements ITecnologiasService{
	
		
	@Autowired
	private ITecnologiasRepository tecnoRepo;

	@Override
	public List<Tecnologias> findAll() {

		return tecnoRepo.findAll();
	}

	@Override
	public Optional<Tecnologias> findById(int id) {

		return tecnoRepo.findById(id);
	}

	@Override
	public Tecnologias create(Tecnologias tecnologias) {

		return tecnoRepo.save(tecnologias);
	}

	@Override
	public Tecnologias update(Tecnologias tecnologias) {

		return tecnoRepo.save(tecnologias);
	}

	@Override
	public void delete(int id) {

		tecnoRepo.deleteById(id);
	}

	@Override
	public List<Tecnologias> findByName(String name) {

		return tecnoRepo.findByName(name);
	}
	
		
	

}
