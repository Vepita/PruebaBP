package com.ec.core.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ec.core.entity.Cuenta;

@Component
public interface ICuentaService {

	List<Cuenta> obtenerCuentas();

	Cuenta guardarCuenta(Cuenta cuenta);

	Cuenta obtenerCuentaPorNumero(String numeroCuenta);

}
