package com.ec.core.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ec.core.enums.TipoMovimientoEnum;

@Table(name = "movimiento")
@Entity
public class Movimiento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1879075512530185111L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MOVIMIENTO_ID_SEQ")
	@SequenceGenerator(sequenceName = "MOVIMIENTO_ID_SEQ", allocationSize = 1, name = "MOVIMIENTO_ID_SEQ")
	private long id;
	@Column(name = "fecha")
	private Date fecha;
	@Column(name = "TIPO_MOVIMIENTO")
	private TipoMovimientoEnum tipoMovimiento;
	@Column(name = "valor")
	private BigDecimal valor;
	@Column(name = "saldo")
	private BigDecimal saldo;
	@ManyToOne
	@JoinColumn(name = "CODIGO_CUENTA")
	private Cuenta cuenta;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public TipoMovimientoEnum getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(TipoMovimientoEnum tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
}
