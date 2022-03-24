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

import com.proyectodam.model.Cursos;
import com.proyectodam.service.cursos.ICursosService;

@RestController
@RequestMapping("/api/cursos")
public class CursosController {
	
	@Autowired
	private ICursosService cursosService;	
	
	
	@GetMapping
	public ResponseEntity<List<Cursos>> findAll(){
		return ResponseEntity.ok(cursosService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cursos> findById(@PathVariable("id") int id){
		
			return cursosService.findById(id)
					.map(ResponseEntity::ok)									//lo que hace si lo encuentra
					.orElseGet(() -> ResponseEntity.notFound().build());		//lo que hace si no lo encuentra
	}
		
	
	@GetMapping("/byname/{name}")
	public List<Cursos> getCursosByName(@PathVariable String name){
		return cursosService.findByName(name);
	}	
	
	
	@PostMapping
	public ResponseEntity<Cursos> create(@Valid @RequestBody Cursos cursos){		//requestbody se pone para indicarle que el cliente vendra en la peticion
		
		return new ResponseEntity<>(cursosService.create(cursos), HttpStatus.CREATED);		//@Valid se pone por el tema de validaciones
		
	}
	
	@PutMapping
	public ResponseEntity<Cursos> update(@Valid @RequestBody Cursos cursos){
				
		return cursosService.findById(cursos.getId())
				.map( cursoEncontrado -> ResponseEntity.ok(cursosService.update(cursos)))
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Cursos> delete(@PathVariable("id") int id){
			
		return cursosService.findById(id)
				.map( cursoEncontrado -> {
					cursosService.delete(id);
					return ResponseEntity.ok(cursoEncontrado);
				})
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	

}
