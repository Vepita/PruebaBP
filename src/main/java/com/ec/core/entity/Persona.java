package com.ec.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5845061340430375203L;

	@Column(name = "nombre")
	private String nombre;
	@Column(name = "genero")
	private String genero;
	@Column(name = "edad")
	private Integer edad;
	@Column(name = "identificacion")
	private String identificacion;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "telefono")
	private String telefono;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
