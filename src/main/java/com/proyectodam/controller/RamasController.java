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

import com.proyectodam.model.Ramas;
import com.proyectodam.service.ramas.IRamasService;

@RestController
@RequestMapping("/api/ramas")
public class RamasController {
	
	@Autowired
	private IRamasService ramasService;	
	
	@GetMapping
	public ResponseEntity<List<Ramas>> findAll(){
		return ResponseEntity.ok(ramasService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Ramas> findById(@PathVariable("id") int id){
		
			return ramasService.findById(id)
					.map(ResponseEntity::ok)									//lo que hace si lo encuentra
					.orElseGet(() -> ResponseEntity.notFound().build());		//lo que hace si no lo encuentra
	}
		
	
	@GetMapping("/byname/{name}")
	public List<Ramas> getRamasByName(@PathVariable String name){
		return ramasService.findByName(name);
	}	
	
	
	@PostMapping
	public ResponseEntity<Ramas> create(@Valid @RequestBody Ramas ramas){		//requestbody se pone para indicarle que el cliente vendra en la peticion
		
		return new ResponseEntity<>(ramasService.create(ramas), HttpStatus.CREATED);		//@Valid se pone por el tema de validaciones
		
	}
	
	@PutMapping
	public ResponseEntity<Ramas> update(@Valid @RequestBody Ramas ramas){
				
		return ramasService.findById(ramas.getId())
				.map( ramaEncontrado -> ResponseEntity.ok(ramasService.update(ramas)))
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Ramas> delete(@PathVariable("id") int id){
			
		return ramasService.findById(id)
				.map( ramaEncontrado -> {
					ramasService.delete(id);
					return ResponseEntity.ok(ramaEncontrado);
				})
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
		
	
}
