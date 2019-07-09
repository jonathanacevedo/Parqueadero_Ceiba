package com.ceiba.fachadainterface;

import com.ceiba.modelo.Parqueo;

public interface ParqueoFachadaInterface {

	public void registrarParqueo(Parqueo parqueo);
	
	public void retirarParqueo(Parqueo parqueo);
	
	public Parqueo obtenerParqueo(String placa);
	
	public boolean consultarVehiculo(String placa);
	
	public boolean consultarSalidaVehiculo(String placa);
}
