package com.ceiba.repositorioImp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.entity.VehiculoEntity;
import com.ceiba.modelo.Vehiculo;
import com.ceiba.persistencia.BuilderVehiculo;
import com.ceiba.repositorio.VehiculoRepositorio;

@Repository
public class VehiculoRepositorioImp implements VehiculoRepositorio {
	
	CrudRepository<VehiculoEntity, String> vehiculoRepositorio;

	public VehiculoRepositorioImp(CrudRepository<VehiculoEntity, String> vehiculoRepositorio) {
		super();
		this.vehiculoRepositorio = vehiculoRepositorio;
	}

	@Override
	public void ingresarVehiculo(Vehiculo vehiculo) {
		this.vehiculoRepositorio.save(BuilderVehiculo.convertirAEntidad(vehiculo));
	}

}
