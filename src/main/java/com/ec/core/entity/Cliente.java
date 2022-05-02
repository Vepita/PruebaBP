package com.ec.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ec.core.enums.EstadoClienteEnum;

@Table(name = "cliente")
@Entity
public class Cliente extends Persona {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6014425673395513456L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTE_ID_SEQ")
    @SequenceGenerator(sequenceName = "CLIENTE_ID_SEQ", allocationSize = 1, name = "CLIENTE_ID_SEQ")
	@Column(name = "id")
	private long id;
	@Column(name = "cliente_id")
	private String clienteId;
	@Column(name = "contrasenia")
	private String contrasenia;
	@Enumerated(EnumType.STRING)
	@Column(name = "estado")
	private EstadoClienteEnum estado;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClienteId() {
		return clienteId;
	}

	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public EstadoClienteEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoClienteEnum estado) {
		this.estado = estado;
	}

}
