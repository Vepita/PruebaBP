package com.ec.core.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.core.entity.Cuenta;
import com.ec.core.entity.Movimiento;
import com.ec.core.enums.TipoMovimientoEnum;
import com.ec.core.repository.MovimientoRepository;
import com.ec.core.service.ICuentaService;
import com.ec.core.service.IMovimientoService;

@Service("movimientoService")
public class MovimientoServiceImpl implements IMovimientoService {

	@Autowired
	MovimientoRepository movimientoRepository;
	
	@Autowired
	ICuentaService cuentaService;

	@Override
	public Movimiento guardarMovimiento(Movimiento movimiento) throws Exception {
		Cuenta cuentaActualizada = null;
		movimiento.setFecha(new Date());
		movimiento.setSaldo(calcularSaldo(movimiento.getValor(), movimiento.getCuenta().getSaldoInicial(),
				movimiento.getTipoMovimiento()));
		cuentaActualizada = movimiento.getCuenta();
		cuentaActualizada.setSaldoInicial(movimiento.getSaldo());
		try {
			this.cuentaService.guardarCuenta(cuentaActualizada);
			return movimientoRepository.save(movimiento);
		} catch (Exception e) {
			throw new Exception("Ocurrio un error al guardar el movimiento"+ e.getMessage());
		}
		
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

	private BigDecimal calcularSaldo(BigDecimal valor, BigDecimal saldoInicial, TipoMovimientoEnum tipoMovimiento) {
		BigDecimal saldo = BigDecimal.ZERO;
		if (tipoMovimiento.getValor().equals("RETIRO")) {
			saldo = saldoInicial.subtract(valor);
		} else {
			saldo = saldoInicial.add(valor);
		}
		return saldo;
	}

}
