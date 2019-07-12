package com.ceiba.repositorio;

import com.ceiba.modelo.Vehiculo;

public interface VehiculoRepositorio {

	public void ingresarVehiculo(Vehiculo vehiculo);
	
	public Vehiculo buscarVehiculo(Vehiculo vehiculo);
}
