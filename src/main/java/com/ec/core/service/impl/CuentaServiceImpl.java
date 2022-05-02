package com.ec.core.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.core.entity.Cuenta;
import com.ec.core.repository.CuentaRepository;
import com.ec.core.service.ICuentaService;

@Service("cuentaService")
public class CuentaServiceImpl implements ICuentaService {

	@Autowired
	CuentaRepository cuentaRepository;

	@Override
	public List<Cuenta> obtenerCuentas() {
		return (List<Cuenta>) cuentaRepository.findAll();
	}

	@Override
	@Transactional()
	public Cuenta guardarCuenta(Cuenta cuenta) {
		return cuentaRepository.save(cuenta);
	}

	@Override
	public Cuenta obtenerCuentaPorNumero(String numeroCuenta) {
		return cuentaRepository.findByNumeroCuenta(numeroCuenta);
	}

}
