package com.ceiba.fachada;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.entity.CarroEntity;
import com.ceiba.fachadainterface.CarroFachadaInterface;
import com.ceiba.modelo.Carro;

@Repository
public class CarroFachada implements CarroFachadaInterface {
	
	CrudRepository<CarroEntity, Long> repositorio;
	
	public CarroFachada(CrudRepository<CarroEntity, Long> repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public void crearCarro(Carro carro) {
		CarroEntity carroEntity = new CarroEntity(carro.getPlaca(), 100L);
		this.repositorio.save(carroEntity);
	}
	
}
