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

import com.proyectodam.model.Usuarios_Asignaturas;
import com.proyectodam.service.usuariosasignaturas.IUsuariosAsignaturasService;

@RestController
@RequestMapping("/api/usuarios_asignaturas")
public class UsuariosAsignaturasController {
		
	@Autowired
	private IUsuariosAsignaturasService usuariosAsignaturasService;
	
	
	@GetMapping
	public ResponseEntity<List<Usuarios_Asignaturas>> findAll(){
		return ResponseEntity.ok(usuariosAsignaturasService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuarios_Asignaturas> findById(@PathVariable("id") int id){
		
			return usuariosAsignaturasService.findById(id)
					.map(ResponseEntity::ok)									//lo que hace si lo encuentra
					.orElseGet(() -> ResponseEntity.notFound().build());		//lo que hace si no lo encuentra
	}
		
	
	@GetMapping("/byasignaturas/{asignatura_id}")
	public List<Usuarios_Asignaturas> getByAsignaturas(@PathVariable Integer asignatura_id){
		return usuariosAsignaturasService.findByAsignaturas(asignatura_id);
	}	

	@GetMapping("/byusuarios/{usuario_id}")
	public List<Usuarios_Asignaturas> getByUsuarios(@PathVariable Integer usuario_id){
		return usuariosAsignaturasService.findByUsuarios(usuario_id);
	}	
	
		
	@PostMapping
	public ResponseEntity<Usuarios_Asignaturas> create(@Valid @RequestBody Usuarios_Asignaturas usuarios_Asignaturas){		//requestbody se pone para indicarle que el cliente vendra en la peticion
		
		return new ResponseEntity<>(usuariosAsignaturasService.create(usuarios_Asignaturas), HttpStatus.CREATED);		//@Valid se pone por el tema de validaciones
		
	}
	
	@PutMapping
	public ResponseEntity<Usuarios_Asignaturas> update(@Valid @RequestBody Usuarios_Asignaturas usuarios_Asignaturas){
				
		return usuariosAsignaturasService.findById(usuarios_Asignaturas.getId())
				.map( usaEncontrado -> ResponseEntity.ok(usuariosAsignaturasService.update(usuarios_Asignaturas)))
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuarios_Asignaturas> delete(@PathVariable("id") int id){
			
		return usuariosAsignaturasService.findById(id)
				.map( usaEncontrado -> {
					usuariosAsignaturasService.delete(id);
					return ResponseEntity.ok(usaEncontrado);
				})
				.orElseGet( () -> ResponseEntity.notFound().build());
	}		
	
	

}
