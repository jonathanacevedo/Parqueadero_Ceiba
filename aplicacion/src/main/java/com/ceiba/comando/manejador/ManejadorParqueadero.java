package com.ceiba.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.Parqueo;
import com.ceiba.modelo.Vehiculo;
import com.ceiba.servicio.ServicioParqueadero;

@Component
public class ManejadorParqueadero {
	
	
	private ServicioParqueadero servicioCrearParqueo;

	
	public ManejadorParqueadero(ServicioParqueadero servicioCrearParqueo) {
		this.servicioCrearParqueo = servicioCrearParqueo;
	}

	public void ingresarVehiculo(Vehiculo vehiculo) {
		this.servicioCrearParqueo.ingresarVehiculo(vehiculo);
	}
	
	public void retirarParqueo(Parqueo parqueo) {
		this.servicioCrearParqueo.retirarParqueo(parqueo);
	}
	
	public boolean consultarVehiculo(String placa) {
		return this.servicioCrearParqueo.consultarVehiculo(placa);
	}
	
	public boolean consultarSalidaVehiculo(String placa) {
		return this.servicioCrearParqueo.consultarSalidaVehiculo(placa);
	}

	public Parqueo obtenerParqueo(String placaVehiculo) {
		return this.servicioCrearParqueo.obtenerParqueo(placaVehiculo);
	}
	
}
