package com.ceiba.comando.manejador;

import java.util.Date;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ManejadorVehiculoTest {

	
	@Test
	public void validarQuePuedeIngresar() {
		
		
		//Act
		boolean ingresoValido = ManejadorVehiculo.puedeIngresar("AGT412", new Date()); 
		
		//Assert
		assertFalse(ingresoValido);
		
	}
}
