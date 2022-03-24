package com.proyectodam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author oscarmartinezhidalgo
 * Esta clase se refiere a las tecnologias por ejemplo react, mysql, javascript, java, etc
 * 
 */
@Entity
@Table(name="tecnologias")
public class Tecnologias {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Ramas ramas;
	
	@NotNull(message="El nombre de la tecnologia no pueden ser nulo")
	@NotBlank(message="El nombre de la tecnologia es obligatorio")
	@Size(min=2, max=150,message="El nombre de la tecnologia debe ser mayor de 2 caracteres")
	@Column(name="nombre", nullable=false, length=150)	
	private String nombre;
	
	@Column(name="descripcion", nullable=true, length=250)	
	private String descripcion;
	
	public Tecnologias(Ramas ramas, String nombre, String descripcion) {
		this.ramas = ramas;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public Tecnologias() {

	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Ramas getRamas() {
		return ramas;
	}
	public void setRamas(Ramas ramas) {
		this.ramas = ramas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	
	

	

}
