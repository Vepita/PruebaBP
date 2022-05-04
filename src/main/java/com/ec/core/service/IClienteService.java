package com.ec.core.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ec.core.entity.Cliente;

@Component
public interface IClienteService {

	public List<Cliente> obtenerClientes();
	
	public Cliente guardarCliente(Cliente cliente);
	
	public Cliente obtenerClientePorIdentificacion(String identificacion);
	
	public void eliminarCliente(Long id);
	
	public Cliente actualizarcliente(String identificacion, Cliente cliente);

}
