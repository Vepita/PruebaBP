package com.ec.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ec.core.entity.Cuenta;
import com.ec.core.entity.RestResponse;
import com.ec.core.service.ICuentaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/cuenta")
@ApiResponses(value = { @ApiResponse(code = 200, message = "true"),
		@ApiResponse(code = 404, message = "The resource not found") })
public class CuentaControlador {

	private final ICuentaService iCuentaService;

	@Autowired
	public CuentaControlador(ICuentaService cuentaService) {
		this.iCuentaService = cuentaService;
	}
	
	@RequestMapping(value = "/obtenerCuentas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestResponse obtenerCuentas() {
		List<Cuenta> cuentas = null;
		try {
			cuentas = iCuentaService.obtenerCuentas();
		} catch (Exception e) {
			return new RestResponse(null, true, "Error al obtener las cuentas: " + e.getMessage());
		}
		return new RestResponse(cuentas, false, null);
	}

	@ApiOperation(value = "Obtener la cuenta por el numero de cuenta")
	@RequestMapping(value = "/obtenerCuentaPorNumero/{numeroCuenta}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestResponse obtenerCuentaPorNumero(@PathVariable("numeroCuenta") String numeroCuenta) {
		Cuenta cuenta = null;
		try {
			cuenta = iCuentaService.obtenerCuentaPorNumero(numeroCuenta);
		} catch (Exception e) {
			return new RestResponse(null, true, "Error al obtener la cuenta por numero de cuenta: " + e.getMessage());
		}
		return new RestResponse(cuenta, false, null);
	}

	@RequestMapping(value = "/guardarCuenta", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestResponse guardarCuenta(@RequestBody Cuenta cuenta) {
		Cuenta cuentaNueva = null;
		try {
			cuentaNueva = this.iCuentaService.guardarCuenta(cuenta);
		} catch (Exception e) {
			return new RestResponse(null, true, "Error al guardar la cuenta: " + e.getMessage());
		}
		return new RestResponse(cuentaNueva, false, null);
	}

}
