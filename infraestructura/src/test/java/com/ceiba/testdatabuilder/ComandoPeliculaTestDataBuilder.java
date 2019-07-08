package com.ceiba.testdatabuilder;


public class ComandoPeliculaTestDataBuilder {

	private String nombre;
	
	public ComandoPeliculaTestDataBuilder() {
		this.nombre = "Batman";
	}
	
	public ComandoPeliculaTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	/*
	
	public ComandoPelicula build() {
		return new ComandoPelicula(nombre);
	}
	*/
}
