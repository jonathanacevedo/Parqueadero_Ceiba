package com.ceiba.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.entity.CarroEntity;

@Repository
public interface CarroRepositorio extends CrudRepository<CarroEntity, Long> {

}
