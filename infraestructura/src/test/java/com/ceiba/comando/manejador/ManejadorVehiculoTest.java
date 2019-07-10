package com.ceiba.comando.manejador;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.fachadainterface.ParqueoFachadaInterface;
import com.ceiba.fachadainterface.VehiculoFachadaInterface;
import com.ceiba.modelo.Carro;
import com.ceiba.modelo.Vehiculo;
import com.ceiba.servicio.ServicioCrearParqueo;

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
		
		ServicioCrearParqueo servicioCrearVehiculo = new ServicioCrearParqueo(vehiculoRepositorio, parqueoRepositorio);
		Vehiculo vehiculo = new Carro(PLACA_EJEMPLO, "Carro");
		
		servicioCrearVehiculo.ingresarVehiculo(vehiculo);
		Vehiculo vehiculoReturn = this.vehiculoRepositorio.buscarVehiculo(vehiculo);

		Assert.assertEquals(PLACA_EJEMPLO, vehiculoReturn.getPlaca());
	}
}
