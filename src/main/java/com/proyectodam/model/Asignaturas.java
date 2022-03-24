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
 * Esta clase es almacena los datos de las asignaturas
 * 
 */
@Entity
@Table(name="asignaturas")
public class Asignaturas {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Cursos cursos;
	
	@NotNull(message="El nombre de la asignatura no pueden ser nulo")
	@NotBlank(message="El nombre de la asignatura es obligatorio")
	@Size(min=3, max=150,message="El nombre de la asignatura debe ser mayor de 3 caracteres")
	@Column(name="nombre", nullable=false, length=150)	
	private String nombre;
	
	@Column(name="descripcion", nullable=true, length=250)	
	private String descripcion;
	
	public Asignaturas(Cursos cursos, String nombre, String descripcion) {
		this.cursos = cursos;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public Asignaturas() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cursos getCursos() {
		return cursos;
	}
	public void setCursos(Cursos cursos) {
		this.cursos = cursos;
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
