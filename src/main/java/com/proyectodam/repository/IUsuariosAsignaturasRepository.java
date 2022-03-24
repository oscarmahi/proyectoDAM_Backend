package com.proyectodam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectodam.model.Usuarios_Asignaturas;

public interface IUsuariosAsignaturasRepository extends JpaRepository <Usuarios_Asignaturas, Integer>{
	
	//@Query("SELECT u FROM Usuarios_Asignaturas u WHERE u.asignaturas_id = ?1")
	//public List<Usuarios_Asignaturas> findByAsignaturas(Integer asignaturas_id);	
	
	@Query(value="SELECT * FROM Usuarios_Asignaturas WHERE asignaturas_id = ?", nativeQuery= true)
	public List<Usuarios_Asignaturas> findByAsignaturas(int asignaturas_id);
	
	//@Query("SELECT u FROM Usuarios_Asignaturas u WHERE u.usuarios_id = ?1")
	//public List<Usuarios_Asignaturas> findByUsuarios(Integer usuarios_id);		
	
	@Query(value="SELECT * FROM Usuarios_Asignaturas WHERE usuarios_id = ?", nativeQuery= true)
	public List<Usuarios_Asignaturas> findByUsuarios(int usuarios_id);

	

}
