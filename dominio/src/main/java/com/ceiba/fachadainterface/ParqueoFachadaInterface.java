package com.ceiba.fachadainterface;

import java.util.List;

import com.ceiba.modelo.Parqueo;
import com.ceiba.modelo.Vehiculo;

public interface ParqueoFachadaInterface {

	public void registrarParqueo(Parqueo parqueo);
	
	public void retirarParqueo(Parqueo parqueo);
		
	public Parqueo obtenerParqueo(String placa);
	
	public boolean consultarVehiculo(String placa);
	
	public boolean consultarSalidaVehiculo(String placa);

	boolean existe(Vehiculo vehiculo);
	
	int contarVehiculosEnParqueadero(String tipoVehiculo);

}
