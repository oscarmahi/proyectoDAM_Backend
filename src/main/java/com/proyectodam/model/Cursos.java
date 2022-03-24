
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
 * Esta clase es almacena los datos de los cursos
 * 
 */
@Entity
@Table(name="cursos")
public class Cursos {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message="El nombre del curso no pueden ser nulo")
	@NotBlank(message="El nombre del curso es obligatorio")
	@Size(min=3, max=150,message="El nombre del curso debe ser mayor de 3 caracteres")
	@Column(name="nombre", nullable=false, length=150)	
	private String nombre;
	
	@Column(name="descripcion", nullable=true, length=150)	
	private String descripcion;
	
	@Column(name="horas_lectivas", nullable=true)	
	private int horas_lectivas;
	
	@NotNull(message="La modalidada no pueden ser nula")
	@NotBlank(message="La modalidad es obligatoria")
	@Size(min=3, max=20,message="La modalidad debe ser mayor de 3 caracteres")
	@Column(name="modalidad", nullable=false, length=20)	
	private String modalidad;
	//se refiere a on-line o presencial

	public Cursos(String nombre, String descripcion, int horas_lectivas, String modalidad) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.horas_lectivas = horas_lectivas;
		this.modalidad = modalidad;
	}

	public Cursos() {

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getHoras_lectivas() {
		return horas_lectivas;
	}

	public void setHoras_lectivas(int horas_lectivas) {
		this.horas_lectivas = horas_lectivas;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	


}
