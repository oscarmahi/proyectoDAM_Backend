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

import com.proyectodam.model.Usuarios_Tecnologias;
import com.proyectodam.service.usuariostecnologias.IUsuariosTecnologiasService;

@RestController
@RequestMapping("/api/usuarios_tecnologias")
public class UsuariosTecnologiasController {
	
	@Autowired
	private IUsuariosTecnologiasService usuariosTecnologiasService;	
	
	@GetMapping
	public ResponseEntity<List<Usuarios_Tecnologias>> findAll(){
		return ResponseEntity.ok(usuariosTecnologiasService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuarios_Tecnologias> findById(@PathVariable("id") int id){
		
			return usuariosTecnologiasService.findById(id)
					.map(ResponseEntity::ok)									//lo que hace si lo encuentra
					.orElseGet(() -> ResponseEntity.notFound().build());		//lo que hace si no lo encuentra
	}
		
	
	@GetMapping("/bytecnologias/{tecnologias_id}")
	public List<Usuarios_Tecnologias> getByTecnologias(@PathVariable Integer tecnologias_id){
		return usuariosTecnologiasService.findByTecnologias(tecnologias_id);
	}	

	@GetMapping("/byusuarios/{usuario_id}")
	public List<Usuarios_Tecnologias> getByUsuarios(@PathVariable Integer usuario_id){
		return usuariosTecnologiasService.findByUsuarios(usuario_id);
	}	
	
		
	@PostMapping
	public ResponseEntity<Usuarios_Tecnologias> create(@Valid @RequestBody Usuarios_Tecnologias usuarios_Tecnologias){		//requestbody se pone para indicarle que el cliente vendra en la peticion
		
		return new ResponseEntity<>(usuariosTecnologiasService.create(usuarios_Tecnologias), HttpStatus.CREATED);		//@Valid se pone por el tema de validaciones
		
	}
	
	@PutMapping
	public ResponseEntity<Usuarios_Tecnologias> update(@Valid @RequestBody Usuarios_Tecnologias usuarios_Tecnologias){
				
		return usuariosTecnologiasService.findById(usuarios_Tecnologias.getId())
				.map( usteEncontrado -> ResponseEntity.ok(usuariosTecnologiasService.update(usuarios_Tecnologias)))
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuarios_Tecnologias> delete(@PathVariable("id") int id){
			
		return usuariosTecnologiasService.findById(id)
				.map( usteEncontrado -> {
					usuariosTecnologiasService.delete(id);
					return ResponseEntity.ok(usteEncontrado);
				})
				.orElseGet( () -> ResponseEntity.notFound().build());
	}		
	

}
