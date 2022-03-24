package com.proyectodam.service.roles;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectodam.model.Roles;
import com.proyectodam.repository.IRolesRepository;

@Service
public class RolesService implements IRolesService{

	@Autowired
	private IRolesRepository rolRepo;
	
	
	@Override
	public List<Roles> findAll() {

		return rolRepo.findAll();
	}

	@Override
	public Optional<Roles> findById(int id) {

		return rolRepo.findById(id);
	}

	
	
	
}


