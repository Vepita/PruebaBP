package com.ec.core.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.core.constantes.Constantes;
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
			throw new Exception("Ocurrio un error al guardar el movimiento: "+ e.getMessage());
		}
		
	}

	@Override
	public List<Movimiento> obtenerMovimientos() {
		return (List<Movimiento>) movimientoRepository.findAll();
	}

	private BigDecimal calcularSaldo(BigDecimal valor, BigDecimal saldoInicial, TipoMovimientoEnum tipoMovimiento) throws Exception {
		BigDecimal saldo = BigDecimal.ZERO;
		try {
			if (tipoMovimiento.getValor().equals(Constantes.RETIRO)) {
				if(saldoInicial.equals(BigDecimal.ZERO)) {
					throw new Exception("El saldo de la cuenta es 0.00");
				}
				saldo = saldoInicial.subtract(valor);
			} else {
				saldo = saldoInicial.add(valor);
			}
		} catch (Exception e) {
			throw new Exception("No se puddo realizar el retiro" + e.getMessage());
		}
		return saldo;
	}


	@Override
	public List<Movimiento> obtenerMovimientosPorCuenta(String numeroCuenta) {
		// TODO Auto-generated method stub
		return null;
	}

}
