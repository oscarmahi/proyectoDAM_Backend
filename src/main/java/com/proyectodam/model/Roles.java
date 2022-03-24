package com.proyectodam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author oscarmartinezhidalgo
 * Esta clase almacenará los tipos de roles que son: administrador, docente, alumno, empresa
 * 
 */
@Entity
@Table(name="roles")
public class Roles {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message="El rol no pueden ser nulo")
	@NotBlank(message="El rol es obligatorio")
	@Size(min=3, max=20,message="El rol debe ser mayor de 3 caracteres")
	@Column(name="rol", nullable=false, length=20)	
	private String rol;
	
	public Roles(String rol) {
		this.rol = rol;
	}
	
	public Roles() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}	

}
