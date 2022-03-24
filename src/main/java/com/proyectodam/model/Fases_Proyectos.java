package com.proyectodam.model;

import java.time.LocalDate;

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
 * Esta clase es almacena los datos de las fases de los proyectos
 * 
 */
@Entity
@Table(name="fases_proyectos")
public class Fases_Proyectos {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Proyectos proyecto;
	
	@Column(name="fecha_inicio", nullable=false)	
	private LocalDate fecha_inicio;
	
	@Column(name="fecha_fin", nullable=true)	
	private LocalDate fecha_fin;
	
	@NotNull(message="El nombre de la fase del proyecto no pueden ser nulo")
	@NotBlank(message="El nombre de la fase del proyecto es obligatorio")
	@Size(min=3, max=150,message="El nombre de la fase del proyecto debe ser mayor de 3 caracteres")
	@Column(name="nombre", nullable=false, length=150)	
	private String nombre;
	
	@Column(name="descripcion", nullable=true, length=250)	
	private String descripcion;
	
	@NotNull(message="El estado de la fase del proyecto no pueden ser nulo")
	@NotBlank(message="El estado de la fase del proyecto es obligatorio")
	@Size(min=3, max=50,message="El estado de la fase del proyecto debe ser mayor de 3 caracteres")
	@Column(name="estado", nullable=false, length=50)	
	private String estado;
	//Los estados son los del tablero kanban: pendientes, en proceso, terminadas
	
	public Fases_Proyectos(Proyectos proyecto, LocalDate fecha_inicio, LocalDate fecha_fin, String nombre,
			String descripcion, String estado) {
		super();
		this.proyecto = proyecto;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public Fases_Proyectos() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Proyectos getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyectos proyecto) {
		this.proyecto = proyecto;
	}

	public LocalDate getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(LocalDate fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public LocalDate getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(LocalDate fecha_fin) {
		this.fecha_fin = fecha_fin;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
