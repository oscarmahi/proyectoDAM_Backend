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
 * Esta clase almacena los datos de los centros educativos
 * 
 */
@Entity
@Table(name="centros")
public class Centros {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message="El nombre del centro no pueden ser nulo")
	@NotBlank(message="El nombre del centro es obligatorio")
	@Size(min=3, max=50,message="El nombre del centro debe ser mayor de 3 caracteres")
	@Column(name="nombre", nullable=false, length=50)	
	private String nombre;
	
	@Size(min=3, max=150,message="La direccion del centro debe ser mayor de 3 caracteres")
	@Column(name="direccion", nullable=true, length=150)	
	private String direccion;
	
	@Size(min=3, max=150,message="La poblacion del centro debe ser mayor de 3 caracteres")
	@Column(name="poblacion", nullable=true, length=150)	
	private String poblacion;
	
	@Size(min=3, max=100,message="La provincia del centro debe ser mayor de 3 caracteres")
	@Column(name="provincia", nullable=true, length=100)	
	private String provincia;

	@Size(min=5, max=5,message="El CP debe ser de 5 caracateres")
	@Column(name="cp", nullable=true, length=5)	
	private String cp;
	
	@Size(min=8, max=15,message="El telefono debe ser mayor de 8 caracteres")
	@Column(name="telefono", nullable=true, length=15)	
	private String telefono;
	
	@NotNull(message="El Email no pueden ser nulo")
	@NotBlank(message="El Email es obligatorio")
	@Size(min=5, max=100,message="El Email debe ser mayor de 5 caracteres")
	@Column(name="email", nullable=false, length=100)	
	private String email;
	
	@NotNull(message="La web no pueden ser nulo")
	@NotBlank(message="La web es obligatorio")	
	@Size(min=5, max=50,message="La web debe ser mayor de 5 caracteres")
	@Column(name="web", nullable=false, length=50)	
	private String web;
	
	public Centros(String nombre, String direccion, String poblacion, String provincia,
			String cp, String telefono, String email, String web) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.provincia = provincia;
		this.cp = cp;
		this.telefono = telefono;
		this.email = email;
		this.web = web;
	}
	
	public Centros() {

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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
		

}
