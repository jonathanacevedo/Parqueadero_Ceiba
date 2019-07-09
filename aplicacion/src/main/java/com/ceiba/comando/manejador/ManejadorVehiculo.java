package com.ceiba.comando.manejador;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.ceiba.fachadainterface.VehiculoFachadaInterface;
import com.ceiba.modelo.Vehiculo;

@Component
public class ManejadorVehiculo {
	
	private VehiculoFachadaInterface vehiculoRepositorio;
	
	private static final String NO_AUTORIZADO_A_INGRESAR = "No esta autorizado a ingresar";
	
	public ManejadorVehiculo(VehiculoFachadaInterface vehiculoRepositorio) {
		this.vehiculoRepositorio = vehiculoRepositorio;
	}
	
	public void ingresarVehiculo(Vehiculo vehiculo) {
        
        if (!puedeIngresar(vehiculo.getPlaca(), new Date())) {
        	throw new IllegalStateException(NO_AUTORIZADO_A_INGRESAR);
        }
        
        this.vehiculoRepositorio.ingresarVehiculo(vehiculo);
	}
	
	public static boolean puedeIngresar(String placaVehiculo, Date fechaPosibleIngreso) {
		
		boolean ingresoValido = true;
		
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaPosibleIngreso);
        		
		if(placaVehiculo.startsWith("A") && (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY || calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY)) {
			ingresoValido = false;
		}
		
		return ingresoValido;
	}
	
	

}

