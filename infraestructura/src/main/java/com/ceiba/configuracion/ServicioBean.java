package com.ceiba.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.fachadainterface.ParqueoFachadaInterface;
import com.ceiba.fachadainterface.VehiculoFachadaInterface;
import com.ceiba.servicio.ServicioParqueadero;

@Configuration
public class ServicioBean {
	
	@Bean
	public ServicioParqueadero crearServicio(ParqueoFachadaInterface parqueoFachadaInterface, VehiculoFachadaInterface vehiculoFachadaInterface) {
		return new ServicioParqueadero(vehiculoFachadaInterface, parqueoFachadaInterface);
	}
}
