package com.proyectodam.service.usuariostecnologias;

import java.util.List;
import java.util.Optional;

import com.proyectodam.model.Usuarios_Tecnologias;

public interface IUsuariosTecnologiasService {

	public List<Usuarios_Tecnologias> findAll();
	
	public Optional<Usuarios_Tecnologias> findById(int id);
	
	public Usuarios_Tecnologias create(Usuarios_Tecnologias usuarios_Tecnologias);

	public Usuarios_Tecnologias update(Usuarios_Tecnologias usuarios_Tecnologias);
	
	void delete (int id);
	
	public List<Usuarios_Tecnologias> findByTecnologias(Integer tecnologias_id);	
	
	public List<Usuarios_Tecnologias> findByUsuarios(Integer usuarios_id);	
		



}
