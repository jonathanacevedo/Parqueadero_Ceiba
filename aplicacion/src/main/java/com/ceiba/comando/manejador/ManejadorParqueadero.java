package com.ceiba.comando.manejador;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.Parqueo;
import com.ceiba.modelo.RespuestaParqueo;
import com.ceiba.modelo.RespuestaRetiroVehiculo;
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
	
	public RespuestaRetiroVehiculo retirarParqueo(Parqueo parqueo) {		
		return this.servicioCrearParqueo.retirarParqueo(parqueo);
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
	
	public List<RespuestaParqueo> consultarVehiculosParqueados() {
		return this.servicioCrearParqueo.consultarVehiculosParqueados();
	}
	
}
