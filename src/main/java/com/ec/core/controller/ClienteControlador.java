package com.ec.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ec.core.entity.Cliente;
import com.ec.core.entity.RestResponse;
import com.ec.core.service.IClienteService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/cliente")
@ApiResponses(value = { @ApiResponse(code = 200, message = "true"),
		@ApiResponse(code = 404, message = "The resource not found") })
public class ClienteControlador {

	private final IClienteService iClienteService;

	@Autowired
	public ClienteControlador(IClienteService clienteService) {
		this.iClienteService = clienteService;
	}

	@RequestMapping(value = "/obtenerClientes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestResponse obtenerClientes() {
		List<Cliente> clientes = null;
		try {
			clientes = iClienteService.obtenerClientes();
		} catch (Exception e) {
			return new RestResponse(null, true, "Error al obtener los clientes: " + e.getMessage());
		}
		return new RestResponse(clientes, false, null);
	}
	
	@ApiOperation(value = "Obtener el cliente por identificacion")
	@RequestMapping(value = "/obtenerClientePorIdentificacion/{identificacion}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestResponse obtenerClientePorIdentificacion(@PathVariable("identificacion") String identificacion) {
		Cliente cliente = null;
		try {
			cliente = iClienteService.obtenerClientePorIdentificacion(identificacion);
		} catch (Exception e) {
			return new RestResponse(null, true, "Error al obtener el cliente por identificacion: " + e.getMessage());
		}
		return new RestResponse(cliente, false, null);
	}

	@RequestMapping(value = "/guardarCliente", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestResponse guardarCliente(@RequestBody Cliente cliente) {
		Cliente clienteNuevo = cliente;
		try {
			clienteNuevo = this.iClienteService.guardarCliente(clienteNuevo);
		} catch (Exception e) {
			return new RestResponse(null, true, "Error al guardar el cliente: " + e.getMessage());
		}
		return new RestResponse(clienteNuevo, false, null);
	}
	
	@DeleteMapping("/{id}")
	public RestResponse eliminarCliente(@PathVariable Long id) {
		try {
			iClienteService.eliminarCliente(id);
		} catch (Exception e) {
			return new RestResponse(null, true, "Error al eliminar el cliente: " + e.getMessage());
		}
		return new RestResponse("Cliente eliminado", false, null);
	}
	
	@RequestMapping(value = "/actualizarCliente/{identificacion}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse actualizarCliente(@PathVariable String identificacion, @RequestBody Cliente client) {
		Cliente clienteActualizado = null;
		try {
			clienteActualizado = this.iClienteService.actualizarcliente(identificacion, client);
		} catch (Exception e) {
			return new RestResponse(null, true, "Error al actualizar el cliente: " + e.getMessage());
		}
		return new RestResponse(clienteActualizado, false, null);
    }

}
