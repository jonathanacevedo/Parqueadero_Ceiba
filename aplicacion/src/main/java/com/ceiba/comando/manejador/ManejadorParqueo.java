package com.ceiba.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.Parqueo;
import com.ceiba.repositorio.ParqueoRepositorio;

@Component
public class ManejadorParqueo {

	private ParqueoRepositorio parqueoRepositorio;

	public ManejadorParqueo(ParqueoRepositorio parqueoRepositorio) {
		super();
		this.parqueoRepositorio = parqueoRepositorio;
	}
	
	public void registrarParqueo(Parqueo parqueo) {
		this.parqueoRepositorio.registrarParqueo(parqueo);
	}
	
}
