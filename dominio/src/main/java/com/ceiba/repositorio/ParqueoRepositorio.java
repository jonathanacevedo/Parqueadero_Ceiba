package com.ceiba.repositorio;

import java.util.List;

import com.ceiba.modelo.Parqueo;
import com.ceiba.modelo.RespuestaParqueo;
import com.ceiba.modelo.RespuestaRetiroVehiculo;
import com.ceiba.modelo.Vehiculo;

public interface ParqueoRepositorio {

	public void registrarParqueo(Parqueo parqueo);
	
	public RespuestaRetiroVehiculo retirarParqueo(Parqueo parqueo);
		
	public Parqueo obtenerParqueo(String placa);
	
	public boolean consultarVehiculo(String placa);
	
	public boolean consultarSalidaVehiculo(String placa);

	boolean existe(Vehiculo vehiculo);
	
	public int contarVehiculosEnParqueadero(String tipoVehiculo);

	public List<RespuestaParqueo> consultarVehiculosParqueados();

}
