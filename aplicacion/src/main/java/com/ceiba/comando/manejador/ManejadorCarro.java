package com.ceiba.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.Carro;
import com.ceiba.repositorio.CarroRepositorio;

@Component
public class ManejadorCarro {
	
	CarroRepositorio carrorepo;

	public ManejadorCarro(CarroRepositorio carrorepo) {
		this.carrorepo = carrorepo;
	}
	
	public void crearCarro(Carro carro) {
		this.carrorepo.crearCarro(carro);
	}

}
