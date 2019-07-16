package com.ceiba.jpa.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.jpa.entity.ParqueoEntity;

@Repository
public interface ParqueoJpa extends CrudRepository<ParqueoEntity, Long> {
		
	public ParqueoEntity findByVehiculoPlaca(String placa);
	public Iterable<ParqueoEntity> findByFechaSalidaNotNull();
	public Iterable<ParqueoEntity> findByVehiculoTipo(String tipo);
	public Iterable<ParqueoEntity> findAll();	
	
	@Query("SELECT p FROM Parqueo p WHERE p.fechaSalida IS NULL")
	public Iterable<ParqueoEntity> consultarParqueados();	
	
	public void deleteById(Long id);
}