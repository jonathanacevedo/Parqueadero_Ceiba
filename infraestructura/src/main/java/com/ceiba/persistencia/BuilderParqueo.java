package com.ceiba.persistencia;

import com.ceiba.entity.ParqueoEntity;
import com.ceiba.modelo.Parqueo;

public class BuilderParqueo {
	
	public static Parqueo convertirAModelo(ParqueoEntity parqueoEntity) {
		
		Parqueo parqueo = null;
		
		if(parqueoEntity != null) {
			parqueo = new Parqueo(BuilderVehiculo.convertirAModelo(parqueoEntity.getVehiculo()), parqueoEntity.getFechaInicio(), parqueoEntity.getFechaFin(), parqueoEntity.getValor());
		}
		return parqueo;
		
	}
	
	public static ParqueoEntity convertirAEntidad(Parqueo parqueo) {
		ParqueoEntity parqueoEntity = null;
		
		if(parqueo != null) {
			parqueoEntity = new ParqueoEntity();
			parqueoEntity.setVehiculo(BuilderVehiculo.convertirAEntidad(parqueo.getVehiculo()));
			parqueoEntity.setFechaInicio(parqueo.getFechaInicio());
			parqueoEntity.setFechaFin(parqueo.getFechaFin());
			parqueoEntity.setValor(parqueo.getValor());
		}
		
		return parqueoEntity;
	}

}
