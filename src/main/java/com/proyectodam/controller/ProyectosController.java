package com.proyectodam.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectodam.model.Proyectos;
import com.proyectodam.service.proyectos.IProyectosService;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectosController {
	
	
	@Autowired
	private IProyectosService proyectosService;
	
	@GetMapping
	public ResponseEntity<List<Proyectos>> findAll(){
		return ResponseEntity.ok(proyectosService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Proyectos> findById(@PathVariable("id") int id){
		
			return proyectosService.findById(id)
					.map(ResponseEntity::ok)									//lo que hace si lo encuentra
					.orElseGet(() -> ResponseEntity.notFound().build());		//lo que hace si no lo encuentra
	}
		
	
	@GetMapping("/byname/{name}")
	public List<Proyectos> getProyectosByName(@PathVariable String name){
		return proyectosService.findByName(name);
	}	
	
	
	@PostMapping
	public ResponseEntity<Proyectos> create(@Valid @RequestBody Proyectos proyectos){		//requestbody se pone para indicarle que el cliente vendra en la peticion
		
		return new ResponseEntity<>(proyectosService.create(proyectos), HttpStatus.CREATED);		//@Valid se pone por el tema de validaciones
		
	}
	
	@PutMapping
	public ResponseEntity<Proyectos> update(@Valid @RequestBody Proyectos proyectos){
				
		return proyectosService.findById(proyectos.getId())
				.map( proyectoEncontrado -> ResponseEntity.ok(proyectosService.update(proyectos)))
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Proyectos> delete(@PathVariable("id") int id){
			
		return proyectosService.findById(id)
				.map( proyectoEncontrado -> {
					proyectosService.delete(id);
					return ResponseEntity.ok(proyectoEncontrado);
				})
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	

}
