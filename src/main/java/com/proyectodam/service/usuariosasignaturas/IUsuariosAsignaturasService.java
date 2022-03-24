package com.proyectodam.service.usuariosasignaturas;

import java.util.List;
import java.util.Optional;

import com.proyectodam.model.Usuarios_Asignaturas;

public interface IUsuariosAsignaturasService {
	
	public List<Usuarios_Asignaturas> findAll();
	
	public Optional<Usuarios_Asignaturas> findById(int id);
	
	public Usuarios_Asignaturas create(Usuarios_Asignaturas usuarios_Asignaturas);

	public Usuarios_Asignaturas update(Usuarios_Asignaturas usuarios_Asignaturas);
	
	void delete (int id);
	
	public List<Usuarios_Asignaturas> findByAsignaturas(Integer asignatura_id);	
	
	public List<Usuarios_Asignaturas> findByUsuarios(Integer usuario_id);	
		

}
