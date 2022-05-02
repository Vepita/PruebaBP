package com.ec.core.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ec.core.entity.Movimiento;

@Repository("movimientoRepository")
public interface MovimientoRepository extends CrudRepository<Movimiento, Serializable> {

}
