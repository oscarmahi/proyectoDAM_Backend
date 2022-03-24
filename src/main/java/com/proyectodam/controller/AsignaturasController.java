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

import com.proyectodam.model.Asignaturas;
import com.proyectodam.service.asignaturas.IAsignaturasService;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturasController {
	
	
	@Autowired
	private IAsignaturasService asignaturasService;
	
	@GetMapping
	public ResponseEntity<List<Asignaturas>> findAll(){
		return ResponseEntity.ok(asignaturasService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Asignaturas> findById(@PathVariable("id") int id){
		
			return asignaturasService.findById(id)
					.map(ResponseEntity::ok)									//lo que hace si lo encuentra
					.orElseGet(() -> ResponseEntity.notFound().build());		//lo que hace si no lo encuentra
	}
		
	
	@GetMapping("/byname/{name}")
	public List<Asignaturas> getAsignaturasByName(@PathVariable String name){
		return asignaturasService.findByName(name);
	}	
	
	
	@PostMapping
	public ResponseEntity<Asignaturas> create(@Valid @RequestBody Asignaturas asignaturas){		//requestbody se pone para indicarle que el cliente vendra en la peticion
		
		return new ResponseEntity<>(asignaturasService.create(asignaturas), HttpStatus.CREATED);		//@Valid se pone por el tema de validaciones
		
	}
	
	@PutMapping
	public ResponseEntity<Asignaturas> update(@Valid @RequestBody Asignaturas asignaturas){
				
		return asignaturasService.findById(asignaturas.getId())
				.map( asignaturaEncontrado -> ResponseEntity.ok(asignaturasService.update(asignaturas)))
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Asignaturas> delete(@PathVariable("id") int id){
			
		return asignaturasService.findById(id)
				.map( asignaturaEncontrado -> {
					asignaturasService.delete(id);
					return ResponseEntity.ok(asignaturaEncontrado);
				})
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
		

}
