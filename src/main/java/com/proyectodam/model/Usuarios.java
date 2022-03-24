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
 * Esta clase almacenará los datos de los usuarios
 * 
 */
@Entity
@Table(name="usuarios")
public class Usuarios {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Proyectos proyectos;
	
	@ManyToOne
	private Roles roles;
	
	@ManyToOne
	private Centros centros;
	
	@NotNull(message="El usuario(email) no pueden ser nulo")
	@NotBlank(message="El usuario(email) es obligatorio")
	@Size(min=5, max=100,message="El usuario(email) debe ser mayor de 3 caracteres")
	@Column(name="usuario", nullable=false, length=20)	
	private String usuario;
	
	@NotNull(message="El password no pueden ser nulo")
	@NotBlank(message="El password es obligatorio")
	@Size(min=8, max=15,message="El password debe ser mayor de 8 caracteres")
	@Column(name="password", nullable=false, length=15)	
	private String password;
	
	@NotNull(message="El nombre no pueden ser nulo")
	@NotBlank(message="El nombre es obligatorio")
	@Size(min=3, max=50,message="El nombre debe ser mayor de 3 caracteres")
	@Column(name="nombre", nullable=false, length=50)	
	private String nombre;
	
	@NotNull(message="El apellido1 no pueden ser nulo")
	@NotBlank(message="El apellido1 es obligatorio")
	@Size(min=3, max=50,message="El apellido1 debe ser mayor de 3 caracteres")
	@Column(name="apellido1", nullable=false, length=50)	
	private String apellido1;
	
	@NotNull(message="El apellido2 no pueden ser nulo")
	@NotBlank(message="El apellido2 es obligatorio")
	@Size(min=3, max=50,message="El apellido2 debe ser mayor de 3 caracteres")
	@Column(name="apellido2", nullable=false, length=50)	
	private String apellido2;
	
	@NotNull(message="La Direccion no pueden ser nula")
	@NotBlank(message="La Direccion es obligatorio")
	@Size(min=3, max=100,message="La direccion debe ser mayor de 3 caracteres")
	@Column(name="direccion", nullable=false, length=100)	
	private String direccion;
	
	@NotNull(message="La Poblacion no pueden ser nula")
	@NotBlank(message="La Poblacion es obligatorio")
	@Size(min=3, max=100,message="La poblacion debe ser mayor de 3 caracteres")
	@Column(name="poblacion", nullable=false, length=100)	
	private String poblacion;
	
	@NotNull(message="La Provincia no pueden ser nula")
	@NotBlank(message="La Provincia es obligatorio")
	@Size(min=3, max=100,message="La provincia debe ser mayor de 3 caracteres")
	@Column(name="provincia", nullable=false, length=100)	
	private String provincia;
	
	@Size(min=5, max=5,message="El CP debe ser de 5 caracteres")
	@Column(name="cp", nullable=true, length=5)	
	private String cp;
	
	@Size(min=8, max=15,message="El telefono debe ser mayor de 8 caracteres")
	@Column(name="telefono", nullable=true, length=15)	
	private String telefono;

	@Column(name="estudios", nullable=true, length=150)	
	private String estudios;
	
	@Column(name="comentarios", nullable=true, length=250)		
	private String comentarios;
	
	@Size(min=5, max=150,message="El enlace a Linkedin deben ser mayor de 2 caracteres")
	@Column(name="enlace_linkedin", nullable=true, length=150)		
	private String enlace_linkedin;
	
	@Size(min=5, max=150,message="El enlace a Git deben ser mayor de 2 caracteres")
	@Column(name="enlace_git", nullable=true, length=150)		
	private String enlace_git;
	
	@Column(name="anno_creacion", nullable=true)		
	private int anno_creacion;
	
	@Column(name="numero_empleados", nullable=true)	
	private int numero_empleados;
	
	@Column(name="numero_proyectos_abiertos", nullable=true)	
	private int numero_proyectos_abiertos;

	@Size(min=5, max=150,message="La direccion web deben ser mayor de 2 caracteres")
	@Column(name="web", nullable=true, length=150)			
	private String web;
	
	@Size(min=5, max=150,message="La direccion web deben ser mayor de 2 caracteres")
	@Column(name="fecha_alta", nullable=true, length=150)			
	private LocalDate fecha_alta;

	public Usuarios(Proyectos proyectos,Roles roles, Centros centros, String usuario, String password, String nombre, String apellido1, String apellido2, String direccion,
			String poblacion, String provincia, String cp, String telefono, String estudios,
			String comentarios, String enlace_Linkedin, String enlace_git,
			int anno_creacion, int numero_empleados, int numero_proyectos_abiertos, String web, LocalDate fecha_alta) {
		this.proyectos = proyectos;
		this.roles = roles;
		this.centros = centros;
		this.usuario = usuario;
		this.password = password;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.provincia = provincia;
		this.cp = cp;
		this.telefono = telefono;
		this.estudios = estudios;
		this.comentarios = comentarios;
		this.anno_creacion = anno_creacion;
		this.numero_empleados = numero_empleados;
		this.numero_proyectos_abiertos = numero_proyectos_abiertos;
		this.web = web;
		this.fecha_alta = fecha_alta;
	}

	public Usuarios() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Proyectos getProyectos() {
		return proyectos;
	}

	public void setProyectos(Proyectos proyectos) {
		this.proyectos = proyectos;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

		
	public Centros getCentros() {
		return centros;
	}

	public void setCentros(Centros centros) {
		this.centros = centros;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
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

	public String getEstudios() {
		return estudios;
	}

	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	public String getEnlace_linkedin() {
		return enlace_linkedin;
	}

	public void setEnlace_linkedin(String enlace_linkedin) {
		this.enlace_linkedin = enlace_linkedin;
	}

	public String getEnlace_git() {
		return enlace_git;
	}

	public void setEnlace_git(String enlace_git) {
		this.enlace_git = enlace_git;
	}

	public int getAnno_creacion() {
		return anno_creacion;
	}

	public void setAnno_creacion(int anno_creacion) {
		this.anno_creacion = anno_creacion;
	}

	public int getNumero_empleados() {
		return numero_empleados;
	}

	public void setNumero_empleados(int numero_empleados) {
		this.numero_empleados = numero_empleados;
	}

	public int getNumero_proyectos_abiertos() {
		return numero_proyectos_abiertos;
	}

	public void setNumero_proyectos_abiertos(int numero_proyectos_abiertos) {
		this.numero_proyectos_abiertos = numero_proyectos_abiertos;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public LocalDate getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(LocalDate fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	
	
	
	

}
