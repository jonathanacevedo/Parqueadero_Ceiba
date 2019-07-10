package com.ceiba.comando.manejador;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ceiba.fachadainterface.ParqueoFachadaInterface;
import com.ceiba.fachadainterface.VehiculoFachadaInterface;
import com.ceiba.modelo.Moto;
import com.ceiba.modelo.Parqueo;
import com.ceiba.modelo.Vehiculo;

@Component
public class ManejadorParqueadero {

	private VehiculoFachadaInterface vehiculoRepositorio;
	private ParqueoFachadaInterface parqueoRepositorio;

	private static final int PRECIO_INICIAL = 0;
	private static final int PRECIO_HORA_MOTO = 500;
	private static final int PRECIO_HORA_CARRO = 1000;
	private static final int PRECIO_DIA_MOTO = 4000;
	private static final int PRECIO_DIA_CARRO = 8000;
	private static final String NO_AUTORIZADO_A_INGRESAR = "No esta autorizado a ingresar";

	public ManejadorParqueadero(VehiculoFachadaInterface vehiculoRepositorio, ParqueoFachadaInterface parqueoRepositorio) {
		this.vehiculoRepositorio = vehiculoRepositorio;
		this.parqueoRepositorio = parqueoRepositorio;
		
	}

	public void ingresarVehiculo(Vehiculo vehiculo) {
		
		Date fechaActual = new Date();

		if (!puedeIngresar(vehiculo.getPlaca(), fechaActual)) {
			throw new IllegalStateException(NO_AUTORIZADO_A_INGRESAR);
		}

		this.vehiculoRepositorio.ingresarVehiculo(vehiculo);
		
		Parqueo parqueo = new Parqueo(vehiculo, fechaActual, null, PRECIO_INICIAL);
		this.parqueoRepositorio.registrarParqueo(parqueo);
	}
	
	public Parqueo obtenerParqueo(String placa) {
		return this.parqueoRepositorio.obtenerParqueo(placa);
	}
	
	public void retirarParqueo(Parqueo parqueo) {
		double valorAPagar = 0;
		
		valorAPagar = calcularValorAPagar(parqueo.getVehiculo(), parqueo.getFechaInicio());
		parqueo.setValor(valorAPagar);
		parqueo.setFechaFin(new Date());
		this.parqueoRepositorio.retirarParqueo(parqueo);
	}
	
	public boolean consultarVehiculo(String placa) {
		return this.parqueoRepositorio.consultarVehiculo(placa);
	}
	
	public boolean consultarSalidaVehiculo(String placa) {
		return this.parqueoRepositorio.consultarSalidaVehiculo(placa);
	}
	
	public boolean puedeIngresar(String placaVehiculo, Date fechaPosibleIngreso) {

		boolean ingresoValido = true;

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaPosibleIngreso);

		if (placaVehiculo.startsWith("A") && (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY
				&& calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY)) {
			ingresoValido = false;
		}

		return ingresoValido;
	}
	
	public double calcularValorAPagar(Vehiculo vehiculo, Date fechaIngreso) {
		
		int numeroHoras = ObtenerNumeroDeHoras(fechaIngreso);
		double valorAPagar = 0;
		
		Map<String, Integer> diasHoras = ObtenerNumeroDiasHoras(numeroHoras);
		int dias = diasHoras.get("DIAS");
		int horas = diasHoras.get("HORAS");
			
		if(vehiculo instanceof Moto) {
			valorAPagar = (double)(dias * PRECIO_DIA_MOTO) + (horas * PRECIO_HORA_MOTO);
			if(vehiculo.getCilindraje() > 500) {
				valorAPagar = valorAPagar + 2000;
			}
		} else {
			valorAPagar = (double)(dias * PRECIO_DIA_CARRO) + (horas * PRECIO_HORA_CARRO);
		}
		
		return valorAPagar;
		
	}
	
	public Map<String, Integer> ObtenerNumeroDiasHoras(int numeroHoras) {
		
		int contDias = 0;
		int auxNumeroHoras = numeroHoras;
		int nroHoras = 0;
		
		Map<String, Integer> DiasHoras = new HashMap<String, Integer>();
		
		 while(auxNumeroHoras >= 9) {
			contDias++;
			auxNumeroHoras = auxNumeroHoras - 24;
		}
		
		if(auxNumeroHoras > 0) {
			nroHoras = auxNumeroHoras;
		}
		
		DiasHoras.put("DIAS", contDias);
		DiasHoras.put("HORAS", nroHoras);
		
	
		return DiasHoras;
	}
	
	public int ObtenerNumeroDeHoras(Date fechaIngreso) {
		long periodo = new Date().getTime() - fechaIngreso.getTime();
		double horasDiferencia = (periodo / (60 * 60 * 1000));
		
		System.out.println("Horas de diferencia : "+horasDiferencia);
		
		if(horasDiferencia == 0.0){
			horasDiferencia = 1;
		}
		
		return (int)horasDiferencia;
	}

}
