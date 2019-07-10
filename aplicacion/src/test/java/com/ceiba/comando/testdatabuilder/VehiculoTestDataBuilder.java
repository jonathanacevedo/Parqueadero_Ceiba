package com.ceiba.comando.testdatabuilder;

import com.ceiba.modelo.Carro;
import com.ceiba.modelo.Moto;
import com.ceiba.modelo.Vehiculo;

public class VehiculoTestDataBuilder {

	private static final String PLACA="ABC-123";	
	private static final int CILINDRAJE=250;
	private static final String TIPO_MOTO = "Moto";
	private static final String TIPO_CARRO ="Carro";
	
	private String placa;	
	private int cilindraje;
	
	public VehiculoTestDataBuilder() {		
		this.placa = PLACA;
		this.cilindraje = CILINDRAJE;
	}
	
	public VehiculoTestDataBuilder conPlaca(String placa){
		this.placa=placa;
		return this;
	}
	
	public VehiculoTestDataBuilder conCilindraje(int cilindraje){
		this.cilindraje=cilindraje;
		return this;
	}
	
	public Vehiculo buildMoto(){
		return new Moto(this.placa,this.cilindraje, TIPO_MOTO);
	}
	
	public Vehiculo buildCarro(){
		return new Carro(this.placa,TIPO_CARRO);
	}	
}
