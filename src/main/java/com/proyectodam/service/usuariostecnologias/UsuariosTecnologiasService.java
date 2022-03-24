package com.proyectodam.service.usuariostecnologias;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectodam.model.Usuarios_Tecnologias;
import com.proyectodam.repository.IUsuariosTecnologiasRepository;

@Service
public class UsuariosTecnologiasService implements IUsuariosTecnologiasService{
	
	@Autowired
	private IUsuariosTecnologiasRepository usuarioTecnologiaRepo;
	
	
	@Override
	public List<Usuarios_Tecnologias> findAll() {

		return usuarioTecnologiaRepo.findAll();
	}

	@Override
	public Optional<Usuarios_Tecnologias> findById(int id) {

		return usuarioTecnologiaRepo.findById(id);
	}

	@Override
	public Usuarios_Tecnologias create(Usuarios_Tecnologias usuarios_Tecnologias) {

		return usuarioTecnologiaRepo.save(usuarios_Tecnologias);
	}

	@Override
	public Usuarios_Tecnologias update(Usuarios_Tecnologias usuarios_Tecnologias) {

		return usuarioTecnologiaRepo.save(usuarios_Tecnologias);
	}

	@Override
	public void delete(int id) {

		usuarioTecnologiaRepo.deleteById(id);
	}

	@Override
	public List<Usuarios_Tecnologias> findByTecnologias(Integer tecnologia_id) {

		return usuarioTecnologiaRepo.findByTecnologias(tecnologia_id);
	}
	
	@Override
	public List<Usuarios_Tecnologias> findByUsuarios(Integer usuario_id) {

		return usuarioTecnologiaRepo.findByUsuarios(usuario_id);
	}	
	
	
	
	
	
	

}
