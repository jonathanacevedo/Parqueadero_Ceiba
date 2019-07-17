package com.ceiba.servicio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.junit.Test;

import com.ceiba.databuilder.VehiculoTestDataBuilder;
import com.ceiba.excepcion.ExcepcionVehiculoNoParqueado;
import com.ceiba.modelo.Parqueo;
import com.ceiba.modelo.RespuestaParqueo;
import com.ceiba.modelo.Vehiculo;
import com.ceiba.repositorio.ParqueoRepositorio;
import com.ceiba.repositorio.VehiculoRepositorio;

public class ServicioParqueaderoTest {

	private static final String PLACA_QUE_EMPIEZA_CON_A = "AGT412";
	private static final String PLACA_VEHICULO = "KYQ125";
	private static final String PLACA_VEHICULO_A_CONSULTAR_EXISTENCIA = "IUQ154";
	private static final String PLACA_VEHICULO_A_RETIRAR = "OUQ354";
	private static final String HORAS = "HORAS";
	private static final String DIAS = "DIAS";
	private static final int CILINDRAJE_650 = 650;

	@Test
	public void ingresarVehiculoConPlacaQueEmpiezaConATest() {
		
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
	public void ingresarVehiculoConPlacaQueNoEmpiezaConATest() {
		
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
	public void ingresarVehiculoQueEmpiezaConAUnDomingoTest() {
		
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
	public void ingresarVehiculoQueEmpiezaConAUnLunesTest() {
		
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
	public void ingresarVehiculoQueEmpiezaConAUnMiercolesTest() {
		
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
	public void ingresarVehiculoQueEmpiezaConAUnSabadoTest() {
		
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
	public void ingresarVehiculoQueEmpiezaConBUnDomingoTest() {
		
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
	public void calcularDiferenciaDe2HorasTest() {
		
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
	public void calcularDiasYHorasEn27HorasTest() {
		
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
	public void calcularDiasYHorasEn100HorasTest() {
		
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
	public void calcularDiasYHorasEn7HorasTest() {
		
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
	public void calcularDiasYHorasEn9HorasTest() {
		
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
	public void calcularValorAPagarDeCarroPorUnDiaYTresHorasTest() {
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
	public void calcularValorAPagarDeMoto650CCPorDiezHorasTest() {
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
	public void retornarRespuestaDeRetiroTest() {
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
	
	@Test
	public void consultarExistenciaVehiculoTest() {
		
		//Arrange
		VehiculoRepositorio vehiculoFachada = mock(VehiculoRepositorio.class);
		ParqueoRepositorio parqueoFachada = mock(ParqueoRepositorio.class);
		
		ServicioParqueadero manejadorParqueadero = new ServicioParqueadero(vehiculoFachada, parqueoFachada);
		
		Vehiculo moto = new VehiculoTestDataBuilder()
				.conPlaca(PLACA_VEHICULO_A_CONSULTAR_EXISTENCIA)
				.conCilindraje(150)
				.buildMoto();
		
		manejadorParqueadero.ingresarVehiculo(moto);
		
		//Act
		boolean ingresoValido = manejadorParqueadero.consultarVehiculo(PLACA_VEHICULO_A_CONSULTAR_EXISTENCIA); 
		
		//Assert
		assertFalse(ingresoValido);
	}
		
	
	@Test
	public void consultarSalidaDeVehiculoTest() {
		
		//Arrange
		VehiculoRepositorio vehiculoFachada = mock(VehiculoRepositorio.class);
		ParqueoRepositorio parqueoFachada = mock(ParqueoRepositorio.class);
		
		ServicioParqueadero manejadorParqueadero = new ServicioParqueadero(vehiculoFachada, parqueoFachada);
		
		Vehiculo carro = new VehiculoTestDataBuilder()
				.conPlaca(PLACA_VEHICULO_A_RETIRAR)
				.buildCarro();
		
		manejadorParqueadero.ingresarVehiculo(carro);
		
		Parqueo parqueo = new Parqueo(carro, new Date(), null, 0);
		
		try {
			//Act
			manejadorParqueadero.retirarParqueo(parqueo);
			fail();

		} catch (ExcepcionVehiculoNoParqueado e) {
			//Assert
			assertEquals(ServicioParqueadero.VEHICULO_NO_PARQUEADO, e.getMessage());
		}

	}

	
	@Test
	public void ingresarVehiculoQueYaExisteTest() {
		
		//Arrange
		VehiculoRepositorio vehiculoFachada = mock(VehiculoRepositorio.class);
		ParqueoRepositorio parqueoFachada = mock(ParqueoRepositorio.class);
		
		ServicioParqueadero manejadorParqueadero = new ServicioParqueadero(vehiculoFachada, parqueoFachada);
		
		Vehiculo carro = new VehiculoTestDataBuilder()
				.conPlaca(PLACA_VEHICULO_A_RETIRAR)
				.buildCarro();
		
		manejadorParqueadero.ingresarVehiculo(carro);
		
		Vehiculo carro2 = new VehiculoTestDataBuilder()
				.conPlaca(PLACA_VEHICULO_A_RETIRAR)
				.buildCarro();
		
		manejadorParqueadero.ingresarVehiculo(carro);
		manejadorParqueadero.ingresarVehiculo(carro2);
		
		//Act
		boolean ingresoValido = manejadorParqueadero.consultarSalidaVehiculo(PLACA_VEHICULO_A_RETIRAR); 
		
		//Assert
		assertFalse(ingresoValido);
		
	}
	
}
