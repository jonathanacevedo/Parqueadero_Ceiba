package com.ceiba.repositorioImp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.entity.ParqueoEntity;

@Repository
public interface ParqueoRepository2 extends CrudRepository<ParqueoEntity, Long> {

}
