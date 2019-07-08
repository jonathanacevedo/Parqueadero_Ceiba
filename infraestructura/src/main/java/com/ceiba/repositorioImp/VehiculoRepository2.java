package com.ceiba.repositorioImp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.entity.VehiculoEntity;

@Repository
public interface VehiculoRepository2 extends CrudRepository <VehiculoEntity, String>{

}
