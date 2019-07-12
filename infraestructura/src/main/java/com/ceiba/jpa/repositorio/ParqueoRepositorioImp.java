package com.ceiba.jpa.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ceiba.jpa.builder.BuilderParqueo;
import com.ceiba.jpa.entity.ParqueoEntity;
import com.ceiba.jpa.jpa.ParqueoJpa;
import com.ceiba.modelo.Parqueo;
import com.ceiba.modelo.RespuestaParqueo;
import com.ceiba.modelo.Vehiculo;
import com.ceiba.repositorio.ParqueoRepositorio;

@Repository
public class ParqueoRepositorioImp implements ParqueoRepositorio {
	
	private ParqueoJpa parqueoRepositorio;
	
	public ParqueoRepositorioImp(ParqueoJpa parqueoRepositorio) {
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

	@Override
	public boolean existe(Vehiculo vehiculo) {
		boolean existe = true;
		ParqueoEntity parqueoEntity = this.parqueoRepositorio.findByVehiculoPlaca(vehiculo.getPlaca());
		if(parqueoEntity == null) {
			existe = false;
		}
		return existe;
	}

	@Override
	public int contarVehiculosEnParqueadero(String tipoVehiculo) {
		int contadorVehiculos = 0;
		Iterable<ParqueoEntity> listaVehiculos = this.parqueoRepositorio.findByVehiculoTipo(tipoVehiculo);
		
		for (ParqueoEntity vehiculo : listaVehiculos) {
			if(vehiculo.getFechaSalida() == null) {
				contadorVehiculos++;
			}
		}
		return contadorVehiculos;
	}
	
	@Override
	public List<Parqueo> consultarVehiculosParqueados() {
		
		List<Parqueo> listaParqueo = new ArrayList<>();
		Iterable<ParqueoEntity> listaParqueosEntities = this.parqueoRepositorio.findAll();
	
		for (ParqueoEntity parqueoEntity : listaParqueosEntities) {
			listaParqueo.add(BuilderParqueo.convertirAModelo(parqueoEntity));
		}
				
		return listaParqueo;
	}
}
