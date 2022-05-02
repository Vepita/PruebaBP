package com.ec.core.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ec.core.entity.Cuenta;

@Repository("cuentaRepository")
public interface CuentaRepository extends CrudRepository<Cuenta, Serializable> {
	
	public Cuenta findByNumeroCuenta(String numeroCuenta);
	
}
