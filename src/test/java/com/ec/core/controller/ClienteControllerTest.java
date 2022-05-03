package com.ec.core.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ec.core.entity.Cliente;
import com.ec.core.entity.RestResponse;
import com.ec.core.service.IClienteService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class ClienteControllerTest {

	@InjectMocks
	ClienteControlador clienteControlador;
	@Mock
	IClienteService clienteService;

	@Test
	public void testGetClientes() {
		RestResponse clientesObtenidos = clienteControlador.obtenerClientes();
		assertNotNull("Existe un cliente", clientesObtenidos);
	}
	
	@Test
	public void testGuardarClientes() {
		Cliente clienteNuevo = new Cliente();
		clienteNuevo.setNombre("nombre Prueba");
		RestResponse clienteGuardado = clienteControlador.guardarCliente(clienteNuevo);
		assertNotNull("Existe un cliente guardado", clienteGuardado);
	}

}
