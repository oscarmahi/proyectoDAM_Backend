package com.proyectodam.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyectodam.model.Usuarios;
import com.proyectodam.service.usuarios.IUsuariosService;

@RestController
@RequestMapping("/api/usuarios")
//@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.PUT})
public class UsuariosController {
	
	@Autowired
	private IUsuariosService usuarioService;		
	
	
	@GetMapping
	public ResponseEntity<List<Usuarios>> findAll(){
		return ResponseEntity.ok(usuarioService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuarios> findById(@PathVariable("id") int id){
		
			return usuarioService.findById(id)
					.map(ResponseEntity::ok)									//lo que hace si lo encuentra
					.orElseGet(() -> ResponseEntity.notFound().build());		//lo que hace si no lo encuentra
	}
		
	
	@GetMapping("/byapellido1/{apellido1}")
	public List<Usuarios> getUsuariosByApellido1(@PathVariable String apellido1){
		return usuarioService.findByApellido1(apellido1);
	}	

	@GetMapping("/byusuario/{usuario}")
	public List<Usuarios> getUsuariosByUsuario(@PathVariable String usuario){
		return usuarioService.findByUsuario(usuario);
	}	
	
	@GetMapping("byusuariopassword/")
	public Usuarios getUsuarioPassword(String usuario, String password) {
		return usuarioService.findByUsuarioPassword(usuario, password);
	}
	
		
	@PostMapping
	public ResponseEntity<Usuarios> create(@Valid @RequestBody Usuarios usuarios){		//requestbody se pone para indicarle que el cliente vendra en la peticion
		
		return new ResponseEntity<>(usuarioService.create(usuarios), HttpStatus.CREATED);		//@Valid se pone por el tema de validaciones
		
	}
	
	@PutMapping
	public ResponseEntity<Usuarios> update(@Valid @RequestBody Usuarios usuarios){
				
		return usuarioService.findById(usuarios.getId())
				.map( usuarioEncontrado -> ResponseEntity.ok(usuarioService.update(usuarios)))
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuarios> delete(@PathVariable("id") int id){
			
		return usuarioService.findById(id)
				.map( tecnoEncontrado -> {
					usuarioService.delete(id);
					return ResponseEntity.ok(tecnoEncontrado);
				})
				.orElseGet( () -> ResponseEntity.notFound().build());
	}		
	
	
	
	

}
