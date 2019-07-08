package com.ceiba.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.Vehiculo;
import com.ceiba.repositorio.VehiculoRepositorio;

@Component
public class ManejadorVehiculo {
	
	private VehiculoRepositorio vehiculoRepositorio;

	public ManejadorVehiculo(VehiculoRepositorio vehiculoRepositorio) {
		this.vehiculoRepositorio = vehiculoRepositorio;
	}
	
	public void ingresarVehiculo(Vehiculo vehiculo) {
		this.vehiculoRepositorio.ingresarVehiculo(vehiculo);
	}

}
