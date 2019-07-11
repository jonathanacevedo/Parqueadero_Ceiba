package com.ceiba.comando.manejador;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.testdatabuilder.VehiculoTestDataBuilder;
import com.ceiba.fachadainterface.ParqueoFachadaInterface;
import com.ceiba.fachadainterface.VehiculoFachadaInterface;
import com.ceiba.modelo.Carro;
import com.ceiba.modelo.Vehiculo;
import com.ceiba.servicio.ServicioParqueadero;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManejadorVehiculoTest {

	@Autowired
	VehiculoFachadaInterface vehiculoRepositorio;
	
	@Autowired
	ParqueoFachadaInterface parqueoRepositorio;

	private static final String PLACA_VEHICULO_A_INSERTAR = "TPL782";
	
	@Test
	public void InsertarVehiculo() {
		
		//Arrange
		ServicioParqueadero servicioCrearVehiculo = new ServicioParqueadero(vehiculoRepositorio, parqueoRepositorio);
		Vehiculo vehiculo = new Carro(PLACA_VEHICULO_A_INSERTAR, "Carro");
		
		//Act
		servicioCrearVehiculo.ingresarVehiculo(vehiculo);
		Vehiculo vehiculoRetornado = this.vehiculoRepositorio.buscarVehiculo(vehiculo);

		//Assert
		Assert.assertEquals(PLACA_VEHICULO_A_INSERTAR, vehiculoRetornado.getPlaca());
	}
	
	@Test
	public void HayEspacioParaCarroEnParqueadero() {
		
		//Arrange
		ServicioParqueadero servicioCrearVehiculo = new ServicioParqueadero(vehiculoRepositorio, parqueoRepositorio);
		
		Vehiculo vehiculo1 = new VehiculoTestDataBuilder()
				.conPlaca("VHC1")
				.buildCarro();
		
		Vehiculo vehiculo2 = new VehiculoTestDataBuilder()
				.conPlaca("VHC2")
				.buildCarro();
		
		Vehiculo vehiculo3 = new VehiculoTestDataBuilder()
				.conPlaca("VHC3")
				.buildCarro();

		//Act
		servicioCrearVehiculo.ingresarVehiculo(vehiculo1);
		servicioCrearVehiculo.ingresarVehiculo(vehiculo2);
		servicioCrearVehiculo.ingresarVehiculo(vehiculo3);
		
		boolean hayEspacio = servicioCrearVehiculo.hayEspacio("Carro");

		//Assert
		Assert.assertTrue(hayEspacio);
	}	
	
	@Ignore
	@Test
	public void HayEspacioParaMotoEnParqueadero() {
		
		//Arrange
		ServicioParqueadero servicioCrearVehiculo = new ServicioParqueadero(vehiculoRepositorio, parqueoRepositorio);
		
		Vehiculo vehiculo1 = new VehiculoTestDataBuilder()
				.conPlaca("VHL1")
				.conCilindraje(150)
				.buildMoto();
		
		Vehiculo vehiculo2 = new VehiculoTestDataBuilder()
				.conPlaca("VHL2")
				.conCilindraje(150)
				.buildMoto();

		//Act
		servicioCrearVehiculo.ingresarVehiculo(vehiculo1);
		servicioCrearVehiculo.ingresarVehiculo(vehiculo2);
		
		boolean hayEspacio = servicioCrearVehiculo.hayEspacio("Moto");

		//Assert
		Assert.assertTrue(hayEspacio);
	}	

	@Test
	public void NoHayEspacioParaMotoEnParqueadero() {
		
		//Arrange
		ServicioParqueadero servicioCrearVehiculo = new ServicioParqueadero(vehiculoRepositorio, parqueoRepositorio);
		
		Vehiculo vehiculo1 = new VehiculoTestDataBuilder()
				.conPlaca("VHK1")
				.conCilindraje(150)
				.buildMoto();
		
		Vehiculo vehiculo2 = new VehiculoTestDataBuilder()
				.conPlaca("VHK2")
				.conCilindraje(150)
				.buildMoto();
		
		Vehiculo vehiculo3 = new VehiculoTestDataBuilder()
				.conPlaca("VHK3")
				.conCilindraje(150)
				.buildMoto();
		
		Vehiculo vehiculo4 = new VehiculoTestDataBuilder()
				.conPlaca("VHK4")
				.conCilindraje(150)
				.buildMoto();
		
		Vehiculo vehiculo5 = new VehiculoTestDataBuilder()
				.conPlaca("VHK5")
				.conCilindraje(150)
				.buildMoto();
		
		Vehiculo vehiculo6 = new VehiculoTestDataBuilder()
				.conPlaca("VHK6")
				.conCilindraje(150)
				.buildMoto();
		
		Vehiculo vehiculo7 = new VehiculoTestDataBuilder()
				.conPlaca("VHK7")
				.conCilindraje(150)
				.buildMoto();
		
		Vehiculo vehiculo8 = new VehiculoTestDataBuilder()
				.conPlaca("VHK8")
				.conCilindraje(150)
				.buildMoto();
		
		Vehiculo vehiculo9 = new VehiculoTestDataBuilder()
				.conPlaca("VHK9")
				.conCilindraje(150)
				.buildMoto();
		
		Vehiculo vehiculo10 = new VehiculoTestDataBuilder()
				.conPlaca("VHK10")
				.conCilindraje(150)
				.buildMoto();

		//Act
		servicioCrearVehiculo.ingresarVehiculo(vehiculo1);
		servicioCrearVehiculo.ingresarVehiculo(vehiculo2);
		servicioCrearVehiculo.ingresarVehiculo(vehiculo3);
		servicioCrearVehiculo.ingresarVehiculo(vehiculo4);
		servicioCrearVehiculo.ingresarVehiculo(vehiculo5);
		servicioCrearVehiculo.ingresarVehiculo(vehiculo6);
		servicioCrearVehiculo.ingresarVehiculo(vehiculo7);
		servicioCrearVehiculo.ingresarVehiculo(vehiculo8);
		servicioCrearVehiculo.ingresarVehiculo(vehiculo9);
		servicioCrearVehiculo.ingresarVehiculo(vehiculo10);
		
		boolean hayEspacio = servicioCrearVehiculo.hayEspacio("Moto");

		//Assert
		Assert.assertFalse(hayEspacio);
	}	

}
