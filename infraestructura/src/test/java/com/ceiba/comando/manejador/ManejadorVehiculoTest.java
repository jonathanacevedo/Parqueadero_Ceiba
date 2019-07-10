package com.ceiba.comando.manejador;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.comando.testdatabuilder.VehiculoTestDataBuilder;
import com.ceiba.fachadainterface.ParqueoFachadaInterface;
import com.ceiba.fachadainterface.VehiculoFachadaInterface;
import com.ceiba.modelo.Vehiculo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManejadorVehiculoTest {

	@Autowired
	VehiculoFachadaInterface vehiculoRepositorio;
	
	@Autowired
	ParqueoFachadaInterface parqueoRepositorio;

	private static final String PLACA_EJEMPLO = "TPL782";

	@Test
	public void InsertarVehiculo() {
		ManejadorParqueadero manejadorVehiculo = new ManejadorParqueadero(vehiculoRepositorio, parqueoRepositorio);
		Vehiculo vehiculo = new VehiculoTestDataBuilder()
							.conPlaca(PLACA_EJEMPLO)
							.buildCarro();
		
		manejadorVehiculo.ingresarVehiculo(vehiculo);
		Vehiculo vehiculoReturn = this.vehiculoRepositorio.buscarVehiculo(vehiculo);

		Assert.assertEquals(PLACA_EJEMPLO, vehiculoReturn.getPlaca());

	}
}
