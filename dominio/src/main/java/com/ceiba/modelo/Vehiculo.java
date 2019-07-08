package com.ceiba.modelo;

public class Vehiculo {
	
	private String placa;
	private int cilindraje;
	private String tipo;
	
	public Vehiculo(String placa, int cilindraje, String tipo) {
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.tipo = tipo;
	}
	
	public Vehiculo(String placa, int cilindraje) {
		this.placa = placa;
		this.cilindraje = cilindraje;
	}
	
	public Vehiculo(String placa,String tipo) {
		this.placa = placa;
		this.tipo = tipo;
	}
	
	public Vehiculo() {
		
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


}
