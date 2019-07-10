package com.ceiba.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.fachadainterface.ParqueoFachadaInterface;
import com.ceiba.fachadainterface.VehiculoFachadaInterface;
import com.ceiba.servicio.ServicioCrearParqueo;

@Configuration
public class ServicioBean {
	
	@Bean
	public ServicioCrearParqueo crearServicio(ParqueoFachadaInterface parqueoFachadaInterface, VehiculoFachadaInterface vehiculoFachadaInterface) {
		return new ServicioCrearParqueo(vehiculoFachadaInterface, parqueoFachadaInterface);
	}
}
