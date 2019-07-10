package com.ceiba.comando.manejador;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.junit.Test;

import com.ceiba.comando.databuilder.VehiculoTestDataBuilder;
import com.ceiba.fachadainterface.ParqueoFachadaInterface;
import com.ceiba.fachadainterface.VehiculoFachadaInterface;
import com.ceiba.modelo.Vehiculo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class ManejadorParqueaderoTest {
	
	private static final String PLACA_QUE_EMPIEZA_CON_A = "AGT412";

	
	@Test
	public void ingresarVehiculoConPlacaQueEmpiezaConA() {
		
		//Arrange
		VehiculoFachadaInterface vehiculoFachada = mock(VehiculoFachadaInterface.class);
		ParqueoFachadaInterface ParqueoFachada = mock(ParqueoFachadaInterface.class);
		
		ManejadorParqueadero manejadorParqueadero = new ManejadorParqueadero(vehiculoFachada, ParqueoFachada);
		
		//Act
		boolean ingresoValido = manejadorParqueadero.puedeIngresar(PLACA_QUE_EMPIEZA_CON_A, new Date()); 
		
		//Assert
		assertFalse(ingresoValido);
		
	}
	
	@Test
	public void ingresarVehiculoConPlacaQueNoEmpiezaConA() {
		
		//Arrange
		VehiculoFachadaInterface vehiculoFachada = mock(VehiculoFachadaInterface.class);
		ParqueoFachadaInterface ParqueoFachada = mock(ParqueoFachadaInterface.class);
		
		ManejadorParqueadero manejadorParqueadero = new ManejadorParqueadero(vehiculoFachada, ParqueoFachada);
		
		//Act
		boolean ingresoValido = manejadorParqueadero.puedeIngresar("CFF41E", new Date()); 
		
		//Assert
		assertTrue(ingresoValido);
		
	}
	
	@Test
	public void ingresarVehiculoQueEmpiezaConAUnDomingo() {
		
		//Arrange
		VehiculoFachadaInterface vehiculoFachada = mock(VehiculoFachadaInterface.class);
		ParqueoFachadaInterface ParqueoFachada = mock(ParqueoFachadaInterface.class);
		
		ManejadorParqueadero manejadorParqueadero = new ManejadorParqueadero(vehiculoFachada, ParqueoFachada);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);	
		
		//Act
		boolean ingresoValido = manejadorParqueadero.puedeIngresar(PLACA_QUE_EMPIEZA_CON_A, calendar.getTime()); 
		
		//Assert
		assertTrue(ingresoValido);
		
	}
	
	@Test
	public void ingresarVehiculoQueEmpiezaConAUnLunes() {
		
		//Arrange
		VehiculoFachadaInterface vehiculoFachada = mock(VehiculoFachadaInterface.class);
		ParqueoFachadaInterface ParqueoFachada = mock(ParqueoFachadaInterface.class);
		
		ManejadorParqueadero manejadorParqueadero = new ManejadorParqueadero(vehiculoFachada, ParqueoFachada);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);	
		
		//Act
		boolean ingresoValido = manejadorParqueadero.puedeIngresar(PLACA_QUE_EMPIEZA_CON_A, calendar.getTime()); 
		
		//Assert
		assertTrue(ingresoValido);
		
	}
	
	@Test
	public void ingresarVehiculoQueEmpiezaConAUnMiercoles() {
		
		//Arrange
		VehiculoFachadaInterface vehiculoFachada = mock(VehiculoFachadaInterface.class);
		ParqueoFachadaInterface ParqueoFachada = mock(ParqueoFachadaInterface.class);
		
		ManejadorParqueadero manejadorParqueadero = new ManejadorParqueadero(vehiculoFachada, ParqueoFachada);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);	
		
		//Act
		boolean ingresoValido = manejadorParqueadero.puedeIngresar(PLACA_QUE_EMPIEZA_CON_A, calendar.getTime()); 
		
		//Assert
		assertFalse(ingresoValido);
		
	}
	
	@Test
	public void ingresarVehiculoQueEmpiezaConAUnSabado() {
		
		//Arrange
		VehiculoFachadaInterface vehiculoFachada = mock(VehiculoFachadaInterface.class);
		ParqueoFachadaInterface ParqueoFachada = mock(ParqueoFachadaInterface.class);
		
		ManejadorParqueadero manejadorParqueadero = new ManejadorParqueadero(vehiculoFachada, ParqueoFachada);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);	
		
		//Act
		boolean ingresoValido = manejadorParqueadero.puedeIngresar(PLACA_QUE_EMPIEZA_CON_A, calendar.getTime()); 
		
		//Assert
		assertFalse(ingresoValido);
		
	}
	
	@Test
	public void ingresarVehiculoQueEmpiezaConBUnDomingo() {
		
		//Arrange
		VehiculoFachadaInterface vehiculoFachada = mock(VehiculoFachadaInterface.class);
		ParqueoFachadaInterface ParqueoFachada = mock(ParqueoFachadaInterface.class);
		
		ManejadorParqueadero manejadorParqueadero = new ManejadorParqueadero(vehiculoFachada, ParqueoFachada);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);	
		
		//Act
		boolean ingresoValido = manejadorParqueadero.puedeIngresar("BGT412", calendar.getTime()); 
		
		//Assert
		assertTrue(ingresoValido);
		
	}
	
	@Test
	public void calcularDiferenciaDe2Horas() {
		
		//Arrange
		VehiculoFachadaInterface vehiculoFachada = mock(VehiculoFachadaInterface.class);
		ParqueoFachadaInterface ParqueoFachada = mock(ParqueoFachadaInterface.class);
		
		ManejadorParqueadero manejadorParqueadero = new ManejadorParqueadero(vehiculoFachada, ParqueoFachada);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.HOUR_OF_DAY,  -2);
		
		//Act
		double periodoHoras = manejadorParqueadero.ObtenerNumeroDeHoras(calendar.getTime());
		
		//Assert
		assertEquals(2, periodoHoras, 0);
	}
	
	@Test
	public void calcularDiasYHorasEn27Horas() {
		
		//Arrange
		VehiculoFachadaInterface vehiculoFachada = mock(VehiculoFachadaInterface.class);
		ParqueoFachadaInterface ParqueoFachada = mock(ParqueoFachadaInterface.class);
		
		ManejadorParqueadero manejadorParqueadero = new ManejadorParqueadero(vehiculoFachada, ParqueoFachada);
		
		//Act
		Map<String, Integer> periodoDiasHoras = manejadorParqueadero.ObtenerNumeroDiasHoras(27);
		
		int dias = periodoDiasHoras.get("DIAS");
		int horas = periodoDiasHoras.get("HORAS");
		
		//Assert
		assertEquals(1, dias);
		assertEquals(3, horas);
	}
	
	@Test
	public void calcularDiasYHorasEn100Horas() {
		
		//Arrange
		VehiculoFachadaInterface vehiculoFachada = mock(VehiculoFachadaInterface.class);
		ParqueoFachadaInterface ParqueoFachada = mock(ParqueoFachadaInterface.class);
		
		ManejadorParqueadero manejadorParqueadero = new ManejadorParqueadero(vehiculoFachada, ParqueoFachada);
		
		//Act
		Map<String, Integer> periodoDiasHoras = manejadorParqueadero.ObtenerNumeroDiasHoras(100);
		
		int dias = periodoDiasHoras.get("DIAS");
		int horas = periodoDiasHoras.get("HORAS");
		
		//Assert
		assertEquals(4, dias);
		assertEquals(4, horas);
	}
	
	@Test
	public void calcularDiasYHorasEn7Horas() {
		
		//Arrange
		VehiculoFachadaInterface vehiculoFachada = mock(VehiculoFachadaInterface.class);
		ParqueoFachadaInterface ParqueoFachada = mock(ParqueoFachadaInterface.class);
		
		ManejadorParqueadero manejadorParqueadero = new ManejadorParqueadero(vehiculoFachada, ParqueoFachada);
		
		//Act
		Map<String, Integer> periodoDiasHoras = manejadorParqueadero.ObtenerNumeroDiasHoras(7);
		
		int dias = periodoDiasHoras.get("DIAS");
		int horas = periodoDiasHoras.get("HORAS");
		
		//Assert
		assertEquals(0, dias);
		assertEquals(7, horas);
	}
	
	@Test
	public void calcularDiasYHorasEn9Horas() {
		
		//Arrange
		VehiculoFachadaInterface vehiculoFachada = mock(VehiculoFachadaInterface.class);
		ParqueoFachadaInterface ParqueoFachada = mock(ParqueoFachadaInterface.class);
		
		ManejadorParqueadero manejadorParqueadero = new ManejadorParqueadero(vehiculoFachada, ParqueoFachada);
		
		//Act
		Map<String, Integer> periodoDiasHoras = manejadorParqueadero.ObtenerNumeroDiasHoras(9);
		
		int dias = periodoDiasHoras.get("DIAS");
		int horas = periodoDiasHoras.get("HORAS");
		
		//Assert
		assertEquals(1, dias);
		assertEquals(0, horas);
	}
	
	@Test
	public void calcularValorAPagarDeCarroPorUnDiaYTresHoras() {
		//Arrange
		VehiculoFachadaInterface vehiculoFachada = mock(VehiculoFachadaInterface.class);
		ParqueoFachadaInterface ParqueoFachada = mock(ParqueoFachadaInterface.class);
		
		ManejadorParqueadero manejadorParqueadero = new ManejadorParqueadero(vehiculoFachada, ParqueoFachada);
		Vehiculo carro = new VehiculoTestDataBuilder()
						.conPlaca("BGQ81B")
						.buildCarro();
					
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.HOUR_OF_DAY,  -27);
		
		//Act
		double valorAPagar = manejadorParqueadero.calcularValorAPagar(carro, calendar.getTime()); 
		
		//Assert
		assertEquals(11000, valorAPagar, 0);
	}
	
	@Test
	public void calcularValorAPagarDeMoto650CCPorDiezHoras() {
		//Arrange
		VehiculoFachadaInterface vehiculoFachada = mock(VehiculoFachadaInterface.class);
		ParqueoFachadaInterface ParqueoFachada = mock(ParqueoFachadaInterface.class);
		
		ManejadorParqueadero manejadorParqueadero = new ManejadorParqueadero(vehiculoFachada, ParqueoFachada);
		Vehiculo moto = new VehiculoTestDataBuilder()
						.conPlaca("KTR93F")
						.conCilindraje(650)
						.buildMoto();
				
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.HOUR_OF_DAY,  -10);
		
		//Act
		double valorAPagar = manejadorParqueadero.calcularValorAPagar(moto, calendar.getTime()); 
		
		//Assert
		assertEquals(6000, valorAPagar, 0);
	}
	
	
}
