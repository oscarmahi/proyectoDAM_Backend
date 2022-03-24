package com.proyectodam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectodam.model.Usuarios_Tecnologias;

public interface IUsuariosTecnologiasRepository extends JpaRepository<Usuarios_Tecnologias, Integer>{

	
	//@Query("SELECT u FROM Usuarios_Tecnologias u WHERE u.tecnologias_id = ?1")
	//public List<Usuarios_Tecnologias> findByTecnologias(Integer tecnologias_id);	
	
	@Query(value="SELECT * FROM Usuarios_Tecnologias WHERE tecnologias_id = ?", nativeQuery= true)
	public List<Usuarios_Tecnologias> findByTecnologias(int tecnologias_id);
	
	//@Query("SELECT u FROM Usuarios_Tecnologias u WHERE u.usuarios_id = ?1")
	//public List<Usuarios_Tecnologias> findByUsuarios(Integer usuarios_id);		
	
	@Query(value="SELECT * FROM Usuarios_Tecnologias WHERE usuarios_id = ?", nativeQuery= true)
	public List<Usuarios_Tecnologias> findByUsuarios(int usuarios_id);

		
}
