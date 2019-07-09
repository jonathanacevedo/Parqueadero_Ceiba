package com.ceiba.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.entity.VehiculoEntity;

@Repository
public interface VehiculoRepository extends CrudRepository <VehiculoEntity, String>{

}
