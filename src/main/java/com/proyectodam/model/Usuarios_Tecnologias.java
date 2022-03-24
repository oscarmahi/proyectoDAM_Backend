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
 * Esta clase es la reclacion N a M entre usuarios y tecnologias.
 * 
 */
@Entity
@Table(name="usuarios_tecnologias")
public class Usuarios_Tecnologias {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Usuarios usuarios;
	
	@ManyToOne
	private Tecnologias tecnologias;
	
	@Column(name="estrellas", nullable=true)	
	private int estrellas;
	
	
	@Column(name="comentarios", nullable=true, length=250)	
	private String comentarios;
	
	@Column(name="nombre_titulo", nullable=true, length=200)	
	private String nombre_titulo;
	
	public Usuarios_Tecnologias(Usuarios usuarios, Tecnologias tecnologias, int estrellas, String comentarios,
			String nombre_titulo) {
		this.usuarios = usuarios;
		this.tecnologias = tecnologias;
		this.estrellas = estrellas;
		this.comentarios = comentarios;
		this.nombre_titulo = nombre_titulo;
	}

	public Usuarios_Tecnologias() {

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
	public Tecnologias getTecnologias() {
		return tecnologias;
	}
	public void setTecnologias(Tecnologias tecnologias) {
		this.tecnologias = tecnologias;
	}
	public int getEstrellas() {
		return estrellas;
	}
	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getNombre_titulo() {
		return nombre_titulo;
	}
	public void setNombre_titulo(String nombre_titulo) {
		this.nombre_titulo = nombre_titulo;
	}
	
	
}
