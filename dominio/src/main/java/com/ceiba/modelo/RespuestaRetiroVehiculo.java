package com.ceiba.modelo;

public class RespuestaRetiroVehiculo {
	
	private String fechaIngreso;
	private String fechaSalida;
	private double valorAPagar;
	public RespuestaRetiroVehiculo(String fechaIngreso, String fechaSalida, double valorAPagar) {
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.valorAPagar = valorAPagar;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public double getValorAPagar() {
		return valorAPagar;
	}
	public void setValorAPagar(double valorAPagar) {
		this.valorAPagar = valorAPagar;
	}
		
}
