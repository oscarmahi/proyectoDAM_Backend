package com.proyectodam.service.usuarios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectodam.model.Usuarios;
import com.proyectodam.repository.IUsuariosRepository;

@Service
public class UsuariosService implements IUsuariosService{

	@Autowired
	private IUsuariosRepository usuarioRepo;

	@Override
	public List<Usuarios> findAll() {

		return usuarioRepo.findAll();
	}

	@Override
	public Optional<Usuarios> findById(int id) {

		return usuarioRepo.findById(id);
	}

	@Override
	public Usuarios create(Usuarios usuarios) {

		return usuarioRepo.save(usuarios);
	}

	@Override
	public Usuarios update(Usuarios usuarios) {

		return usuarioRepo.save(usuarios);
	}

	@Override
	public void delete(int id) {

		usuarioRepo.deleteById(id);
	}

	@Override
	public List<Usuarios> findByApellido1(String apellido1) {

		return usuarioRepo.findByApellido1(apellido1);
	}
	
	@Override
	public List<Usuarios> findByUsuario(String usuario) {

		return usuarioRepo.findByUsuario(usuario);
	}

	@Override
	public Usuarios findByUsuarioPassword(String usuario, String password) {
		
		return usuarioRepo.findByUsuarioPassword(usuario, password);
	}
			
	
}
