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
 * Esta clase se refiere a las ramas de las tecnologías por ejemplo programación, bases de datos, etc.
 * 
 */
@Entity
@Table(name="ramas")
public class Ramas {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message="El nombre de la tecnologia no pueden ser nulo")
	@NotBlank(message="El nombre de la tecnologia es obligatorio")
	@Size(min=2, max=100,message="El nombre de la tecnologia debe ser mayor de 2 caracteres")
	@Column(name="nombre", nullable=false, length=100)	
	private String nombre;
	
	public Ramas(String nombre) {
		this.nombre = nombre;
	}

	public Ramas() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
	
	
	
}
