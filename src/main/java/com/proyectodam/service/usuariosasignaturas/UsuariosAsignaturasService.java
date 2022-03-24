package com.proyectodam.service.usuariosasignaturas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectodam.model.Usuarios_Asignaturas;
import com.proyectodam.repository.IUsuariosAsignaturasRepository;

@Service
public class UsuariosAsignaturasService implements IUsuariosAsignaturasService{

	@Autowired
	private IUsuariosAsignaturasRepository usuarioAsignaturaRepo;
	
	
	@Override
	public List<Usuarios_Asignaturas> findAll() {

		return usuarioAsignaturaRepo.findAll();
	}

	@Override
	public Optional<Usuarios_Asignaturas> findById(int id) {

		return usuarioAsignaturaRepo.findById(id);
	}

	@Override
	public Usuarios_Asignaturas create(Usuarios_Asignaturas usuarios_Asignaturas) {

		return usuarioAsignaturaRepo.save(usuarios_Asignaturas);
	}

	@Override
	public Usuarios_Asignaturas update(Usuarios_Asignaturas usuarios_Asignaturas) {

		return usuarioAsignaturaRepo.save(usuarios_Asignaturas);
	}

	@Override
	public void delete(int id) {

		usuarioAsignaturaRepo.deleteById(id);
	}

	@Override
	public List<Usuarios_Asignaturas> findByAsignaturas(Integer asignatura_id) {

		return usuarioAsignaturaRepo.findByAsignaturas(asignatura_id);
	}
	
	@Override
	public List<Usuarios_Asignaturas> findByUsuarios(Integer usuario_id) {

		return usuarioAsignaturaRepo.findByUsuarios(usuario_id);
	}
	
	
	
}
