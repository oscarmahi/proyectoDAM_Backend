package com.proyectodam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
* @author oscarmartinezhidalgo
* Esta clase es la reclacion N a M entre usuarios y asignaturas.
* 
*/
@Entity
@Table(name="usuarios_asignaturas")
public class Usuarios_Asignaturas {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Usuarios usuarios;
	
	@ManyToOne
	private Asignaturas asignaturas;
	
	@Column(name="nota", nullable=true)	
	private double nota;
	
	@Column(name="comentarios", nullable=true, length=255)	
	private String comentarios;
	
	public Usuarios_Asignaturas(Usuarios usuarios, Asignaturas asignaturas, double nota, String comentarios) {
		this.usuarios = usuarios;
		this.asignaturas = asignaturas;
		this.nota = nota;
		this.comentarios = comentarios;
	}

	public Usuarios_Asignaturas() {

	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuarios getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
	public Asignaturas getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(Asignaturas asignaturas) {
		this.asignaturas = asignaturas;
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
	

}
