package com.ec.core.controller;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ec.core.entity.Cuenta;
import com.ec.core.entity.Movimiento;
import com.ec.core.entity.RestResponse;
import com.ec.core.enums.TipoMovimientoEnum;
import com.ec.core.service.ICuentaService;
import com.ec.core.service.IMovimientoService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/movimiento")
@ApiResponses(value = { @ApiResponse(code = 200, message = "true"),
		@ApiResponse(code = 404, message = "The resource not found") })
public class MovimientoControlador {

	private final IMovimientoService iMovimientoService;
	private final ICuentaService iCuentaService;

	@Autowired
	public MovimientoControlador(IMovimientoService movimientoService, ICuentaService cuentaServie) {
		this.iMovimientoService = movimientoService;
		this.iCuentaService = cuentaServie;
	}

	@RequestMapping(value = "/guardarMovimiento", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestResponse guardarMovimiento(@RequestBody Movimiento movimiento) {
		Movimiento movimientoNuevo = null;
		Cuenta cuentaActualizada = null;
		try {
			movimiento.setFecha(new Date());
			movimiento.setSaldo(calcularSaldo(movimiento.getValor(), movimiento.getCuenta().getSaldoInicial(),
					movimiento.getTipoMovimiento()));
			movimientoNuevo = this.iMovimientoService.guardarMovimiento(movimiento);
			cuentaActualizada = movimientoNuevo.getCuenta();
			cuentaActualizada.setSaldoInicial(movimiento.getSaldo());
			this.iCuentaService.guardarCuenta(cuentaActualizada);
		} catch (Exception e) {
			return new RestResponse(null, true, "Error al guardar el movimiento: " + e.getMessage());
		}
		return new RestResponse(movimientoNuevo, false, null);
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
