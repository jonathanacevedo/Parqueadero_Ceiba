package com.ceiba.repositorioImp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.entity.CarroEntity;
import com.ceiba.modelo.Carro;
import com.ceiba.repositorio.CarroRepositorio;

@Repository
public class CarroRepositorioImp implements CarroRepositorio {
	
	CrudRepository<CarroEntity, Long> repositorio;
	
	public CarroRepositorioImp(CrudRepository<CarroEntity, Long> repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public void crearCarro(Carro carro) {
		CarroEntity carroEntity = new CarroEntity(carro.getPlaca(), 100L);
		this.repositorio.save(carroEntity);
	}
	
}
