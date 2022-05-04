package com.ec.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ec.core.entity.Movimiento;
import com.ec.core.entity.RestResponse;
import com.ec.core.service.IMovimientoService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/movimiento")
@ApiResponses(value = { @ApiResponse(code = 200, message = "true"),
		@ApiResponse(code = 404, message = "The resource not found") })
public class MovimientoControlador {

	private final IMovimientoService iMovimientoService;

	@Autowired
	public MovimientoControlador(IMovimientoService movimientoService) {
		this.iMovimientoService = movimientoService;
	}

	@RequestMapping(value = "/guardarMovimiento", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestResponse guardarMovimiento(@RequestBody Movimiento movimiento) {
		Movimiento movimientoNuevo = null;
		try {
			movimientoNuevo = this.iMovimientoService.guardarMovimiento(movimiento);
		} catch (Exception e) {
			return new RestResponse(null, true, "Error al guardar el movimiento: " + e.getMessage());
		}
		return new RestResponse(movimientoNuevo, false, null);
	}

}
