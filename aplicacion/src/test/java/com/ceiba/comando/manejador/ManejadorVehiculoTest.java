package com.ceiba.comando.manejador;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.ceiba.fachadainterface.VehiculoFachadaInterface;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class ManejadorVehiculoTest {

	
	@Test
	public void ingresarVehiculoConPlacaQueEmpiezaConA() {
		
		//Arrange
		VehiculoFachadaInterface vehiculoFachada = mock(VehiculoFachadaInterface.class);
		
		ManejadorVehiculo manejadorVehiculo = new ManejadorVehiculo(vehiculoFachada);
		
		//Act
		boolean ingresoValido = manejadorVehiculo.puedeIngresar("AGT412", new Date()); 
		
		//Assert
		assertFalse(ingresoValido);
		
	}
	
	@Test
	public void ingresarVehiculoConPlacaQueNoEmpiezaConA() {
		
		//Arrange
		VehiculoFachadaInterface vehiculoFachada = mock(VehiculoFachadaInterface.class);
		
		ManejadorVehiculo manejadorVehiculo = new ManejadorVehiculo(vehiculoFachada);
		
		//Act
		boolean ingresoValido = manejadorVehiculo.puedeIngresar("CFF41E", new Date()); 
		
		//Assert
		assertTrue(ingresoValido);
		
	}
	
	@Test
	public void ingresarVehiculoQueEmpiezaConAUnDomingo() {
		
		//Arrange
		VehiculoFachadaInterface vehiculoFachada = mock(VehiculoFachadaInterface.class);
		
		ManejadorVehiculo manejadorVehiculo = new ManejadorVehiculo(vehiculoFachada);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);	
		
		//Act
		boolean ingresoValido = manejadorVehiculo.puedeIngresar("AGT412", calendar.getTime()); 
		
		//Assert
		assertTrue(ingresoValido);
		
	}
	
	@Test
	public void ingresarVehiculoQueEmpiezaConAUnLunes() {
		
		//Arrange
		VehiculoFachadaInterface vehiculoFachada = mock(VehiculoFachadaInterface.class);
		
		ManejadorVehiculo manejadorVehiculo = new ManejadorVehiculo(vehiculoFachada);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);	
		
		//Act
		boolean ingresoValido = manejadorVehiculo.puedeIngresar("AGT412", calendar.getTime()); 
		
		//Assert
		assertTrue(ingresoValido);
		
	}
	
	@Test
	public void ingresarVehiculoQueEmpiezaConAUnMiercoles() {
		
		//Arrange
		VehiculoFachadaInterface vehiculoFachada = mock(VehiculoFachadaInterface.class);
		
		ManejadorVehiculo manejadorVehiculo = new ManejadorVehiculo(vehiculoFachada);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);	
		
		//Act
		boolean ingresoValido = manejadorVehiculo.puedeIngresar("AGT412", calendar.getTime()); 
		
		//Assert
		assertFalse(ingresoValido);
		
	}
	
	@Test
	public void ingresarVehiculoQueEmpiezaConAUnSabado() {
		
		//Arrange
		VehiculoFachadaInterface vehiculoFachada = mock(VehiculoFachadaInterface.class);
		
		ManejadorVehiculo manejadorVehiculo = new ManejadorVehiculo(vehiculoFachada);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);	
		
		//Act
		boolean ingresoValido = manejadorVehiculo.puedeIngresar("AGT412", calendar.getTime()); 
		
		//Assert
		assertFalse(ingresoValido);
		
	}
	
	@Test
	public void ingresarVehiculoQueEmpiezaConBUnDomingo() {
		
		//Arrange
		VehiculoFachadaInterface vehiculoFachada = mock(VehiculoFachadaInterface.class);
		
		ManejadorVehiculo manejadorVehiculo = new ManejadorVehiculo(vehiculoFachada);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);	
		
		//Act
		boolean ingresoValido = manejadorVehiculo.puedeIngresar("BGT412", calendar.getTime()); 
		
		//Assert
		assertTrue(ingresoValido);
		
	}
	
	
}
