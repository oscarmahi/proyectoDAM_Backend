package com.proyectodam.service.usuarios;

import java.util.List;
import java.util.Optional;

import com.proyectodam.model.Usuarios;

public interface IUsuariosService {
	
	public List<Usuarios> findAll();
	
	public Optional<Usuarios> findById(int id);
	
	public Usuarios create(Usuarios Usuarios);
	
	public Usuarios update(Usuarios Usuarios);
	
	void delete (int id);
	
	public List<Usuarios> findByApellido1(String apellido1);	
	
	public List<Usuarios> findByUsuario(String usuario);	
	
	public Usuarios findByUsuarioPassword(String usuario, String password);
	
	
	

}
