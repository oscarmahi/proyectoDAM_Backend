package com.proyectodam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectodam.model.Roles;
import com.proyectodam.service.roles.IRolesService;

@RestController
@RequestMapping("/api/roles")
public class RolController {
		
	@Autowired
	private IRolesService rolesService;
	
	@GetMapping
	public ResponseEntity<List<Roles>> findAll(){
		return ResponseEntity.ok(rolesService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Roles> findById(@PathVariable("id") int id){
		
			return rolesService.findById(id)
					.map(ResponseEntity::ok)									//lo que hace si lo encuentra
					.orElseGet(() -> ResponseEntity.notFound().build());		//lo que hace si no lo encuentra
	}
	

}
