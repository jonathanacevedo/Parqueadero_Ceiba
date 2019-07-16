package com.ceiba.jpa.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.repositorio.ParqueoRepositorio;
import com.ceiba.repositorio.VehiculoRepositorio;
import com.ceiba.servicio.ServicioParqueadero;

@Configuration
public class ServicioBean {
	
	@Bean
	public ServicioParqueadero crearServicio(ParqueoRepositorio parqueoFachadaInterface, VehiculoRepositorio vehiculoFachadaInterface) {
		return new ServicioParqueadero(vehiculoFachadaInterface, parqueoFachadaInterface);
	}
	
}	
