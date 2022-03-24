package com.proyectodam.model;

import java.time.LocalDate;

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
 * Esta clase es almacena los datos de los proyectos
 * 
 */
@Entity
@Table(name="proyectos")
public class Proyectos {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message="El nombre del proyecto no pueden ser nulo")
	@NotBlank(message="El nombre del proyecto es obligatorio")
	@Size(min=3, max=100,message="El nombre del proyecto debe ser mayor de 3 caracteres")
	@Column(name="nombre", nullable=false, length=100)	
	private String nombre;
	
	@NotNull(message="La descripcion del proyecto no pueden ser nula")
	@NotBlank(message="La descripcion del proyecto es obligatoria")
	@Size(min=3, max=250,message="La descripcion del proyecto debe ser mayor de 3 caracteres")
	@Column(name="descripcion", nullable=false, length=250)	
	private String descripcion;
	
	@Column(name="nota", nullable=false)
	double nota;
	
	@Column(name="comentarios", nullable=true, length=250)
	private String comentarios;

	@NotNull(message="El estado del proyecto no pueden ser nulo")
	@NotBlank(message="El estado del proyecto es obligatorio")
	@Size(min=3, max=250,message="El estado del proyecto debe ser mayor de 3 caracteres")
	@Column(name="estado", nullable=false, length=25)	
	private String estado;
	//estados posibles: no asignado, en desarrollo, entregado
	
	@Column(name="fecha_presentacion", nullable=true)	
	private LocalDate fecha_presentacion;
	
	public Proyectos(String nombre, String descripcion, double nota, String comentarios, String estado, LocalDate fecha_presentacion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.nota = nota;
		this.comentarios = comentarios;
		this.estado = estado;
		this.fecha_presentacion = fecha_presentacion;
	}
	
	public Proyectos() {

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
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public LocalDate getFecha_presentacion() {
		return fecha_presentacion;
	}

	public void setFecha_presentacion(LocalDate fecha_presentacion) {
		this.fecha_presentacion = fecha_presentacion;
	}
	
	

}
