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

import com.proyectodam.model.Tecnologias;
import com.proyectodam.service.tecnologias.ITecnologiasService;

@RestController
@RequestMapping("/api/tecnologias")
public class TecnologiasController {
	
	@Autowired
	private ITecnologiasService tecnoService;		
	
	@GetMapping
	public ResponseEntity<List<Tecnologias>> findAll(){
		return ResponseEntity.ok(tecnoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tecnologias> findById(@PathVariable("id") int id){
		
			return tecnoService.findById(id)
					.map(ResponseEntity::ok)									//lo que hace si lo encuentra
					.orElseGet(() -> ResponseEntity.notFound().build());		//lo que hace si no lo encuentra
	}
		
	
	@GetMapping("/byname/{name}")
	public List<Tecnologias> getTecnologiasByName(@PathVariable String name){
		return tecnoService.findByName(name);
	}	
	
	
	@PostMapping
	public ResponseEntity<Tecnologias> create(@Valid @RequestBody Tecnologias tecnologias){		//requestbody se pone para indicarle que el cliente vendra en la peticion
		
		return new ResponseEntity<>(tecnoService.create(tecnologias), HttpStatus.CREATED);		//@Valid se pone por el tema de validaciones
		
	}
	
	@PutMapping
	public ResponseEntity<Tecnologias> update(@Valid @RequestBody Tecnologias tecnologias){
				
		return tecnoService.findById(tecnologias.getId())
				.map( tecnoEncontrado -> ResponseEntity.ok(tecnoService.update(tecnologias)))
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Tecnologias> delete(@PathVariable("id") int id){
			
		return tecnoService.findById(id)
				.map( tecnoEncontrado -> {
					tecnoService.delete(id);
					return ResponseEntity.ok(tecnoEncontrado);
				})
				.orElseGet( () -> ResponseEntity.notFound().build());
	}	
	
	

}
