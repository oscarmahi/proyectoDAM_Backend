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

import com.proyectodam.model.Centros;
import com.proyectodam.service.centros.ICentrosService;

@RestController
@RequestMapping("/api/centros")
public class CentrosController {
	
	
	@Autowired
	private ICentrosService centrosService;
	
	@GetMapping
	public ResponseEntity<List<Centros>> findAll(){
		return ResponseEntity.ok(centrosService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Centros> findById(@PathVariable("id") int id){
		
			return centrosService.findById(id)
					.map(ResponseEntity::ok)									//lo que hace si lo encuentra
					.orElseGet(() -> ResponseEntity.notFound().build());		//lo que hace si no lo encuentra
	}
		
	
	@GetMapping("/byname/{name}")
	public List<Centros> getCentrosByName(@PathVariable String name){
		return centrosService.findByName(name);
	}	
	
	
	@PostMapping
	public ResponseEntity<Centros> create(@Valid @RequestBody Centros centros){		//requestbody se pone para indicarle que el cliente vendra en la peticion
		
		return new ResponseEntity<>(centrosService.create(centros), HttpStatus.CREATED);		//@Valid se pone por el tema de validaciones
		
	}
	
	@PutMapping
	public ResponseEntity<Centros> update(@Valid @RequestBody Centros centros){
				
		return centrosService.findById(centros.getId())
				.map( centroEncontrado -> ResponseEntity.ok(centrosService.update(centros)))
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Centros> delete(@PathVariable("id") int id){
			
		return centrosService.findById(id)
				.map( centroEncontrado -> {
					centrosService.delete(id);
					return ResponseEntity.ok(centroEncontrado);
				})
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
		
	//esto es para hacer lo mismo pero no devuelve el centro borrao, no devuelve nada
//	@DeleteMapping("/{id}")
//	public ResponseEntity<Object> delete2(@PathVariable("id") int id){
//			
//		return centrosService.findById(id)
//				.map( centroEncontrado -> {
//					centrosService.delete(id);
//					return ResponseEntity.ok().build();
//				})
//				.orElseGet( () -> ResponseEntity.notFound().build());
//	}		

}
