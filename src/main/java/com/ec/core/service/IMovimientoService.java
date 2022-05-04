package com.ec.core.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ec.core.entity.Movimiento;

@Component
public interface IMovimientoService {

	List<Movimiento> obtenerMovimientos();
	
	Movimiento guardarMovimiento(Movimiento movimiento) throws Exception;
	
	Movimiento obtenerMovimientoPorCuenta(String identificacion);

}
