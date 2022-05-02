package com.ec.core.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ec.core.entity.Cliente;

@Component
public interface IClienteService {

	List<Cliente> obtenerClientes();
	
	Cliente guardarCliente(Cliente cliente);
	
	Cliente obtenerClientePorIdentificacion(String identificacion);

}
