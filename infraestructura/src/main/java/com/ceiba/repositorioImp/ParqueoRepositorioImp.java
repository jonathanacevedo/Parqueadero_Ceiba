package com.ceiba.repositorioImp;

import com.ceiba.modelo.Parqueo;
import com.ceiba.persistencia.BuilderParqueo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.entity.ParqueoEntity;
import com.ceiba.repositorio.ParqueoRepositorio;

@Repository
public class ParqueoRepositorioImp implements ParqueoRepositorio {
	
	CrudRepository<ParqueoEntity, Long> parqueoRepositorio;
	
	
	public ParqueoRepositorioImp(CrudRepository<ParqueoEntity, Long> parqueoRepositorio) {
		this.parqueoRepositorio = parqueoRepositorio;
	}


	@Override
	public void registrarParqueo(Parqueo parqueo) {
		this.parqueoRepositorio.save(BuilderParqueo.convertirAEntidad(parqueo));
	}

}
