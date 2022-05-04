package com.ec.core.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import com.ec.core.entity.Cliente;
import com.ec.core.entity.Cuenta;
import com.ec.core.enums.EstadoCuentaEnum;
import com.ec.core.enums.TipoCuentaEnum;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class CuentaControllerTest {
	
	private static final Logger logger = LoggerFactory.getLogger(CuentaControlador.class);

	String apiRootPath ="/cuentasBanco";
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	ObjectMapper objectmapper;

	@Test
	public void testGetCuentas() throws Exception {
		String response = mockMvc.perform(get(apiRootPath  + "/cuenta/obtenerCuentas/"))
				.andExpect(status().is(HttpStatus.OK.value())).andExpect(jsonPath("$.numeroCuenta", is("123456"))).andReturn()
				.getResponse().getContentAsString();

		logger.info("response: " + response);
	}
	
	 @Test
	    public void testGuardarCuenta() throws Exception {
	        Cuenta cuenta = new Cuenta("3333", TipoCuentaEnum.AHORROS, BigDecimal.TEN, EstadoCuentaEnum.A, new Cliente());
	         
	        String response = mockMvc.perform(post(apiRootPath + "/cuenta/guardarCuenta/")
	                .content(objectmapper.writeValueAsString(cuenta))
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().is(HttpStatus.CREATED.value()))
	                .andReturn().getResponse().getContentAsString();
	         
	        logger.info(response);
	    }

}
