package com.ceiba.jpa.repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.jpa.builder.BuilderVehiculo;
import com.ceiba.jpa.entity.VehiculoEntity;
import com.ceiba.modelo.Vehiculo;
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

	@Override
	public Vehiculo buscarVehiculo(Vehiculo vehiculo) {
		
		Vehiculo vehiculoModelo = null;
		
		Optional<VehiculoEntity> vehiculoEntity = this.vehiculoRepositorio.findById(vehiculo.getPlaca());
		boolean isPresent = vehiculoEntity.isPresent();
		
		if(isPresent) {
			vehiculoModelo = BuilderVehiculo.convertirAModelo(vehiculoEntity.get());
		}
		return vehiculoModelo;
	}

}
