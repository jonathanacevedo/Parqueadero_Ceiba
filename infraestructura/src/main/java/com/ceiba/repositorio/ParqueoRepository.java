package com.ceiba.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.entity.ParqueoEntity;

@Repository
public interface ParqueoRepository extends CrudRepository<ParqueoEntity, Long> {
		
	public ParqueoEntity findByVehiculoPlaca(String placa);
	public Iterable<ParqueoEntity> findByFechaSalidaNotNull();
	public Iterable<ParqueoEntity> findByVehiculoTipo(String tipo);
	
}
