package com.ec.core.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ec.core.enums.EstadoCuentaEnum;
import com.ec.core.enums.TipoCuentaEnum;

@Table(name = "cuenta")
@Entity
public class Cuenta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3758496538014759324L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUENTA_ID_SEQ")
	@SequenceGenerator(sequenceName = "CUENTA_ID_SEQ", allocationSize = 1, name = "CUENTA_ID_SEQ")
	private long id;
	@Column(name = "NUMERO_CUENTA")
	private String numeroCuenta;
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_CUENTA")
	private TipoCuentaEnum tipoCuenta;
	@Column(name = "SALDO_INICIAL")
	private BigDecimal saldoInicial;
	@Enumerated(EnumType.STRING)
	@Column(name = "estado")
	private EstadoCuentaEnum estado;
	@ManyToOne
	@JoinColumn(name = "CODIGO_CLIENTE")
	private Cliente cliente;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public TipoCuentaEnum getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuentaEnum tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public EstadoCuentaEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoCuentaEnum estado) {
		this.estado = estado;
	}

	public BigDecimal getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(BigDecimal saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
