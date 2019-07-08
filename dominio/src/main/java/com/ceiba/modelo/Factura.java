package com.ceiba.modelo;

public class Factura {

	private Parqueo parqueo;
	double precio;
	
	public Factura(Parqueo parqueo, double precio) {
		super();
		this.parqueo = parqueo;
		this.precio = precio;
	}
	public Parqueo getParqueo() {
		return parqueo;
	}
	public void setParqueo(Parqueo parqueo) {
		this.parqueo = parqueo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
