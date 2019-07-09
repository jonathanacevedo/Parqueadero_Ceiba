package com.ceiba.fachada;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.builder.BuilderVehiculo;
import com.ceiba.entity.VehiculoEntity;
import com.ceiba.fachadainterface.VehiculoFachadaInterface;
import com.ceiba.modelo.Vehiculo;

@Repository
public class VehiculoFachada implements VehiculoFachadaInterface {
	
	CrudRepository<VehiculoEntity, String> vehiculoRepositorio;

	public VehiculoFachada(CrudRepository<VehiculoEntity, String> vehiculoRepositorio) {
		super();
		this.vehiculoRepositorio = vehiculoRepositorio;
	}

	@Override
	public void ingresarVehiculo(Vehiculo vehiculo) {
		this.vehiculoRepositorio.save(BuilderVehiculo.convertirAEntidad(vehiculo));
	}

}
