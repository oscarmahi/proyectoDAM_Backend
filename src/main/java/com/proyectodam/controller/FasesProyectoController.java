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

import com.proyectodam.model.Fases_Proyectos;
import com.proyectodam.service.fasesproyectos.IFasesProyectosService;

@RestController
@RequestMapping("/api/fasesproyectos")
public class FasesProyectoController {

	@Autowired
	private IFasesProyectosService fasesService;	
	
	@GetMapping
	public ResponseEntity<List<Fases_Proyectos>> findAll(){
		return ResponseEntity.ok(fasesService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Fases_Proyectos> findById(@PathVariable("id") int id){
		
			return fasesService.findById(id)
					.map(ResponseEntity::ok)									//lo que hace si lo encuentra
					.orElseGet(() -> ResponseEntity.notFound().build());		//lo que hace si no lo encuentra
	}
		
	@GetMapping("/byproyectoid/{proyecto_id}")
	public List<Fases_Proyectos> getFasesByName(@PathVariable int proyecto_id){
		return fasesService.findByproyecto_id(proyecto_id);
	}	
	
	
	@PostMapping
	public ResponseEntity<Fases_Proyectos> create(@Valid @RequestBody Fases_Proyectos fases_proyectos){		//requestbody se pone para indicarle que el cliente vendra en la peticion
		
		return new ResponseEntity<>(fasesService.create(fases_proyectos), HttpStatus.CREATED);		//@Valid se pone por el tema de validaciones
		
	}
	
	@PutMapping
	public ResponseEntity<Fases_Proyectos> update(@Valid @RequestBody Fases_Proyectos fases_proyectos){
				
		return fasesService.findById(fases_proyectos.getId())
				.map( faseEncontrado -> ResponseEntity.ok(fasesService.update(fases_proyectos)))
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Fases_Proyectos> delete(@PathVariable("id") int id){
			
		return fasesService.findById(id)
				.map( faseEncontrado -> {
					fasesService.delete(id);
					return ResponseEntity.ok(faseEncontrado);
				})
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	
	
	
	
	
	
	
	
	
}
