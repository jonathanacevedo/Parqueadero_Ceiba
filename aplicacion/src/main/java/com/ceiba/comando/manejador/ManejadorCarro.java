package com.ceiba.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.fachadainterface.CarroFachadaInterface;
import com.ceiba.modelo.Carro;

@Component
public class ManejadorCarro {
	
	CarroFachadaInterface carrorepo;

	public ManejadorCarro(CarroFachadaInterface carrorepo) {
		this.carrorepo = carrorepo;
	}
	
	public void crearCarro(Carro carro) {
		this.carrorepo.crearCarro(carro);
	}

}
