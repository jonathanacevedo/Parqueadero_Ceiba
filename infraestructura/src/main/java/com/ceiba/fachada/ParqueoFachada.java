package com.ceiba.fachada;

import com.ceiba.modelo.Parqueo;
import com.ceiba.repositorio.ParqueoRepository;

import org.springframework.stereotype.Repository;

import com.ceiba.builder.BuilderParqueo;
import com.ceiba.entity.ParqueoEntity;
import com.ceiba.fachadainterface.ParqueoFachadaInterface;

@Repository
public class ParqueoFachada implements ParqueoFachadaInterface {
	
	private ParqueoRepository parqueoRepositorio;
	
	public ParqueoFachada(ParqueoRepository parqueoRepositorio) {
		super();
		this.parqueoRepositorio = parqueoRepositorio;
	}

	@Override
	public void registrarParqueo(Parqueo parqueo) {
		ParqueoEntity parqueoEntity = this.parqueoRepositorio.findByVehiculoPlaca(parqueo.getVehiculo().getPlaca());
		if(parqueoEntity == null) {
			this.parqueoRepositorio.save(BuilderParqueo.convertirAEntidad(parqueo));
		} else {
			this.parqueoRepositorio.delete(parqueoEntity);
			this.parqueoRepositorio.save(BuilderParqueo.convertirAEntidad(parqueo));
		}
		
	}

	@Override
	public void retirarParqueo(Parqueo parqueo) {
		ParqueoEntity parqueoEntity = this.parqueoRepositorio.findByVehiculoPlaca(parqueo.getVehiculo().getPlaca());
		parqueoEntity.setFechaSalida(parqueo.getFechaFin());
		parqueoEntity.setValor(parqueo.getValor());
		this.parqueoRepositorio.save(parqueoEntity);
	}

	@Override
	public Parqueo obtenerParqueo(String placa) {
		ParqueoEntity parqueoEntity = parqueoRepositorio.findByVehiculoPlaca(placa);
		return BuilderParqueo.convertirAModelo(parqueoEntity);
	}

	@Override
	public boolean consultarVehiculo(String placa) {
		boolean vehiculoExiste = false;
		
		if(this.parqueoRepositorio.findByVehiculoPlaca(placa) != null) {
			vehiculoExiste = true;
		} 
		
		return vehiculoExiste;
	}
	
	@Override
	public boolean consultarSalidaVehiculo(String placa) {
		boolean vehiculoSalio = false;
		ParqueoEntity parqueoEntity = this.parqueoRepositorio.findByVehiculoPlaca(placa);
		
		if(BuilderParqueo.convertirAModelo(parqueoEntity).getFechaFin() != null) {
			vehiculoSalio = true;
		} 
		
		return vehiculoSalio;
	}

}
