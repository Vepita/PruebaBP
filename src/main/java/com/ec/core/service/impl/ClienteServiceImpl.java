package com.ec.core.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.core.entity.Cliente;
import com.ec.core.repository.ClienteRepository;
import com.ec.core.service.IClienteService;

@Service("clienteService")
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public List<Cliente> obtenerClientes() {
		return (List<Cliente>) clienteRepository.findAll();
	}

	@Override
	public Cliente guardarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente obtenerClientePorIdentificacion(String identificacion) {
		return clienteRepository.findByIdentificacion(identificacion);
	}
	


}
