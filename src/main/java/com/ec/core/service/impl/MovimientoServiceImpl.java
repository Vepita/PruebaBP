package com.ec.core.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.core.entity.Movimiento;
import com.ec.core.repository.MovimientoRepository;
import com.ec.core.service.IMovimientoService;

@Service("movimientoService")
public class MovimientoServiceImpl implements IMovimientoService {
	
	@Autowired
	MovimientoRepository movimientoRepository;

	@Override
	public Movimiento guardarMovimiento(Movimiento movimiento) {
		return movimientoRepository.save(movimiento);
	}

	@Override
	public Movimiento obtenerMovimientoPorCuenta(String identificacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movimiento> obtenerMovimientos() {
		return (List<Movimiento>) movimientoRepository.findAll();
	}
	


}
