package com.ceiba.comando.manejador;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.ceiba.fachadainterface.ParqueoFachadaInterface;
import com.ceiba.modelo.Carro;
import com.ceiba.modelo.Moto;
import com.ceiba.modelo.Parqueo;
import com.ceiba.modelo.Vehiculo;

@Component
public class ManejadorParqueo {

	private ParqueoFachadaInterface parqueoRepositorio;
	private static final int PRECIO_HORA_MOTO = 500;
	private static final int PRECIO_HORA_CARRO = 1000;
	private static final int PRECIO_DIA_MOTO = 4000;
	private static final int PRECIO_DIA_CARRO = 8000;

	public ManejadorParqueo(ParqueoFachadaInterface daoParqueo) {
		super();
		this.parqueoRepositorio = daoParqueo;
	}
	
	public Parqueo obtenerParqueo(String placa) {
		return this.parqueoRepositorio.obtenerParqueo(placa);
	}
	
	public void registrarParqueo(Vehiculo vehiculo) {

		Parqueo parqueo = new Parqueo(vehiculo, new Date(), null, 0);		
		this.parqueoRepositorio.registrarParqueo(parqueo);
	}
	
	public void retirarParqueo(Parqueo parqueo) {
		
		this.parqueoRepositorio.retirarParqueo(parqueo);
	}
	
	public boolean consultarVehiculo(String placa) {
		return this.parqueoRepositorio.consultarVehiculo(placa);
	}
	
	public boolean consultarSalidaVehiculo(String placa) {
		return this.parqueoRepositorio.consultarSalidaVehiculo(placa);
	}
	
}
