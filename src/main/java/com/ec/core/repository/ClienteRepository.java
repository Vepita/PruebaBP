package com.ec.core.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ec.core.entity.Cliente;


@Repository("clienteRepository")
public interface ClienteRepository extends CrudRepository<Cliente, Serializable> {
	
	public Cliente findByIdentificacion(String identificacion);


}
