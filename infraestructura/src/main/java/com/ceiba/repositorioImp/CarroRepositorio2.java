package com.ceiba.repositorioImp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.entity.CarroEntity;

@Repository
public interface CarroRepositorio2 extends CrudRepository<CarroEntity, Long> {

}
