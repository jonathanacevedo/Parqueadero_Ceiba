package com.ceiba.comando.manejador;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.fachadainterface.VehiculoFachadaInterface;
import com.ceiba.modelo.Vehiculo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManejadorVehiculoTest {

	@Autowired
	VehiculoFachadaInterface vehiculoRepositorio;


	@Test
	public void integracion() {
		ManejadorVehiculo manejadorVehiculo = new ManejadorVehiculo(vehiculoRepositorio);
		Vehiculo vehiculo = new Vehiculo("EA", "CARRO");
		manejadorVehiculo.ingresarVehiculo(vehiculo);
		Vehiculo vehiculoReturn = this.vehiculoRepositorio.buscar(vehiculo);

		Assert.assertEquals("EA", vehiculoReturn.getPlaca());

	}
}
