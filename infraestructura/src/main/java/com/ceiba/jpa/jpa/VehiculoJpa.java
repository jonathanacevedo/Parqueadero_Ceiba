package com.ceiba.jpa.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.jpa.entity.VehiculoEntity;

@Repository
public interface VehiculoJpa extends CrudRepository <VehiculoEntity, String>{

}
