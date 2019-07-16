package com.ceiba.servicio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.junit.Test;

import com.ceiba.databuilder.VehiculoTestDataBuilder;
import com.ceiba.modelo.Parqueo;
import com.ceiba.modelo.RespuestaParqueo;
import com.ceiba.modelo.Vehiculo;
import com.ceiba.repositorio.ParqueoRepositorio;
import com.ceiba.repositorio.VehiculoRepositorio;

public class ServicioParqueaderoTest {

	private static final String PLACA_QUE_EMPIEZA_CON_A = "AGT412";
	private static final String PLACA_VEHICULO = "KYQ125";
	private static final String HORAS = "HORAS";
	private static final String DIAS = "DIAS";
	private static final int CILINDRAJE_650 = 650;

	@Test
	public void ingresarVehiculoConPlacaQueEmpiezaConA() {
		
		//Arrange
		VehiculoRepositorio vehiculoFachada = mock(VehiculoRepositorio.class);
		ParqueoRepositorio parqueoFachada = mock(ParqueoRepositorio.class);
		
		ServicioParqueadero manejadorParqueadero = new ServicioParqueadero(vehiculoFachada, parqueoFachada);
		
		//Act
		boolean ingresoValido = manejadorParqueadero.puedeIngresar(PLACA_QUE_EMPIEZA_CON_A, new Date()); 
		
		//Assert
		assertFalse(ingresoValido);
		
	}
	
	@Test
	public void ingresarVehiculoConPlacaQueNoEmpiezaConA() {
		
		//Arrange
		VehiculoRepositorio vehiculoFachada = mock(VehiculoRepositorio.class);
		ParqueoRepositorio parqueoFachada = mock(ParqueoRepositorio.class);
		
		ServicioParqueadero manejadorParqueadero = new ServicioParqueadero(vehiculoFachada, parqueoFachada);
		
		//Act
		boolean ingresoValido = manejadorParqueadero.puedeIngresar("CFF41E", new Date()); 
		
		//Assert
		assertTrue(ingresoValido);
		
	}
	
	@Test
	public void ingresarVehiculoQueEmpiezaConAUnDomingo() {
		
		//Arrange
		VehiculoRepositorio vehiculoFachada = mock(VehiculoRepositorio.class);
		ParqueoRepositorio parqueoFachada = mock(ParqueoRepositorio.class);
		
		ServicioParqueadero manejadorParqueadero = new ServicioParqueadero(vehiculoFachada, parqueoFachada);
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
		VehiculoRepositorio vehiculoFachada = mock(VehiculoRepositorio.class);
		ParqueoRepositorio parqueoFachada = mock(ParqueoRepositorio.class);
		
		ServicioParqueadero manejadorParqueadero = new ServicioParqueadero(vehiculoFachada, parqueoFachada);
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
		VehiculoRepositorio vehiculoFachada = mock(VehiculoRepositorio.class);
		ParqueoRepositorio parqueoFachada = mock(ParqueoRepositorio.class);
		
		ServicioParqueadero manejadorParqueadero = new ServicioParqueadero(vehiculoFachada, parqueoFachada);
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
		VehiculoRepositorio vehiculoFachada = mock(VehiculoRepositorio.class);
		ParqueoRepositorio parqueoFachada = mock(ParqueoRepositorio.class);
		
		ServicioParqueadero manejadorParqueadero = new ServicioParqueadero(vehiculoFachada, parqueoFachada);
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
		VehiculoRepositorio vehiculoFachada = mock(VehiculoRepositorio.class);
		ParqueoRepositorio parqueoFachada = mock(ParqueoRepositorio.class);
		
		ServicioParqueadero manejadorParqueadero = new ServicioParqueadero(vehiculoFachada, parqueoFachada);
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
		VehiculoRepositorio vehiculoFachada = mock(VehiculoRepositorio.class);
		ParqueoRepositorio parqueoFachada = mock(ParqueoRepositorio.class);
		
		ServicioParqueadero manejadorParqueadero = new ServicioParqueadero(vehiculoFachada, parqueoFachada);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.HOUR_OF_DAY,  -2);
		
		//Act
		double periodoHoras = manejadorParqueadero.obtenerNumeroDeHoras(calendar.getTime());
		
		//Assert
		assertEquals(2, periodoHoras, 0);
	}
	
	@Test
	public void calcularDiasYHorasEn27Horas() {
		
		//Arrange
		VehiculoRepositorio vehiculoFachada = mock(VehiculoRepositorio.class);
		ParqueoRepositorio parqueoFachada = mock(ParqueoRepositorio.class);
		
		ServicioParqueadero manejadorParqueadero = new ServicioParqueadero(vehiculoFachada, parqueoFachada);
		
		//Act
		Map<String, Integer> periodoDiasHoras = manejadorParqueadero.obtenerNumeroDiasHoras(27);
		
		int dias = periodoDiasHoras.get(DIAS);
		int horas = periodoDiasHoras.get(HORAS);
		
		//Assert
		assertEquals(1, dias);
		assertEquals(3, horas);
	}
	
	@Test
	public void calcularDiasYHorasEn100Horas() {
		
		//Arrange
		VehiculoRepositorio vehiculoFachada = mock(VehiculoRepositorio.class);
		ParqueoRepositorio parqueoFachada = mock(ParqueoRepositorio.class);
		
		ServicioParqueadero manejadorParqueadero = new ServicioParqueadero(vehiculoFachada, parqueoFachada);
		
		//Act
		Map<String, Integer> periodoDiasHoras = manejadorParqueadero.obtenerNumeroDiasHoras(100);
		
		int dias = periodoDiasHoras.get(DIAS);
		int horas = periodoDiasHoras.get(HORAS);
		
		//Assert
		assertEquals(4, dias);
		assertEquals(4, horas);
	}
	
	@Test
	public void calcularDiasYHorasEn7Horas() {
		
		//Arrange
		VehiculoRepositorio vehiculoFachada = mock(VehiculoRepositorio.class);
		ParqueoRepositorio parqueoFachada = mock(ParqueoRepositorio.class);
		
		ServicioParqueadero manejadorParqueadero = new ServicioParqueadero(vehiculoFachada, parqueoFachada);
		
		//Act
		Map<String, Integer> periodoDiasHoras = manejadorParqueadero.obtenerNumeroDiasHoras(7);
		
		int dias = periodoDiasHoras.get(DIAS);
		int horas = periodoDiasHoras.get(HORAS);
		
		//Assert
		assertEquals(0, dias);
		assertEquals(7, horas);
	}
	
	@Test
	public void calcularDiasYHorasEn9Horas() {
		
		//Arrange
		VehiculoRepositorio vehiculoFachada = mock(VehiculoRepositorio.class);
		ParqueoRepositorio parqueoFachada = mock(ParqueoRepositorio.class);
		
		ServicioParqueadero manejadorParqueadero = new ServicioParqueadero(vehiculoFachada, parqueoFachada);
		
		//Act
		Map<String, Integer> periodoDiasHoras = manejadorParqueadero.obtenerNumeroDiasHoras(9);
		
		int dias = periodoDiasHoras.get(DIAS);
		int horas = periodoDiasHoras.get(HORAS);
		
		//Assert
		assertEquals(1, dias);
		assertEquals(0, horas);
	}
	
	@Test
	public void calcularValorAPagarDeCarroPorUnDiaYTresHoras() {
		//Arrange
		VehiculoRepositorio vehiculoFachada = mock(VehiculoRepositorio.class);
		ParqueoRepositorio parqueoFachada = mock(ParqueoRepositorio.class);
		
		ServicioParqueadero manejadorParqueadero = new ServicioParqueadero(vehiculoFachada, parqueoFachada);
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
		VehiculoRepositorio vehiculoFachada = mock(VehiculoRepositorio.class);
		ParqueoRepositorio parqueoFachada = mock(ParqueoRepositorio.class);
		
		ServicioParqueadero manejadorParqueadero = new ServicioParqueadero(vehiculoFachada, parqueoFachada);
		Vehiculo moto = new VehiculoTestDataBuilder()
						.conPlaca("KTR93F")
						.conCilindraje(CILINDRAJE_650)
						.buildMoto();
						
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.HOUR_OF_DAY,  -10);
		
		//Act
		double valorAPagar = manejadorParqueadero.calcularValorAPagar(moto, calendar.getTime()); 
		
		//Assert
		assertEquals(6000, valorAPagar, 0);
	}
	
	@Test
	public void retornarRespuestaDeRetiro() {
		//Arrange
		VehiculoRepositorio vehiculoFachada = mock(VehiculoRepositorio.class);
		ParqueoRepositorio parqueoFachada = mock(ParqueoRepositorio.class);
		
		ServicioParqueadero manejadorParqueadero = new ServicioParqueadero(vehiculoFachada, parqueoFachada);
		
		Parqueo parqueo = new Parqueo();
		
		Vehiculo carro = new VehiculoTestDataBuilder()
				.conPlaca(PLACA_VEHICULO)
				.buildCarro();
		
		parqueo.setFechaInicio(new Date());
		parqueo.setFechaFin(new Date());
		parqueo.setVehiculo(carro);
		parqueo.setValor(manejadorParqueadero.calcularValorAPagar(carro, new Date()));
		
		RespuestaParqueo respuestaParqueo = new RespuestaParqueo(parqueo.getVehiculo().getPlaca(), parqueo.getVehiculo().getTipo(),DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(parqueo.getFechaInicio()));
		
		//Act
		String placaRetorno = respuestaParqueo.getPlaca();
		
		
		//Assert
		assertEquals(PLACA_VEHICULO, placaRetorno);
	}
	
}
