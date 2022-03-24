package com.proyectodam.service.roles;

import java.util.List;
import java.util.Optional;

import com.proyectodam.model.Roles;

public interface IRolesService {
	
	public List<Roles> findAll();
	
	public Optional<Roles> findById(int id);
	
}
