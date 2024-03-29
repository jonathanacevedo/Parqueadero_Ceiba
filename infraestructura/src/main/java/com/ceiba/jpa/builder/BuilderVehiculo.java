package com.ceiba.jpa.builder;

import com.ceiba.jpa.entity.VehiculoEntity;
import com.ceiba.modelo.Carro;
import com.ceiba.modelo.Moto;
import com.ceiba.modelo.Vehiculo;

public class BuilderVehiculo {
	
	private BuilderVehiculo() {
		
	}
		
	public static VehiculoEntity convertirAEntidad(Vehiculo vehiculo) {
		VehiculoEntity vehiculoEntity = null;
		
		if(vehiculo != null) {
			vehiculoEntity = new VehiculoEntity();
			vehiculoEntity.setPlaca(vehiculo.getPlaca());
			vehiculoEntity.setCilindraje(vehiculo.getCilindraje());
			vehiculoEntity.setTipo(vehiculo.getTipo());
		}
		return vehiculoEntity;
	}
	
	public static Vehiculo convertirAModelo(VehiculoEntity vehiculoEntity) {
		Vehiculo vehiculo = null;
		
		if(vehiculoEntity != null) {
			if("Carro".equals(vehiculoEntity.getTipo())) {
				vehiculo = new Carro(vehiculoEntity.getPlaca(), vehiculoEntity.getTipo());
			} else {
				vehiculo = new Moto(vehiculoEntity.getPlaca(), vehiculoEntity.getCilindraje(),vehiculoEntity.getTipo());
			}
		}
		
		return vehiculo;
	}

}
