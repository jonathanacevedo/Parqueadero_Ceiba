package com.ceiba.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.comando.manejador.ManejadorVehiculo;
import com.ceiba.modelo.Carro;
import com.ceiba.modelo.Moto;
import com.ceiba.modelo.Vehiculo;

@RestController
@CrossOrigin(origins = "*")
public class VehiculoController {
	
	private ManejadorVehiculo manejadorVehiculo;

	public VehiculoController(ManejadorVehiculo manejadorVehiculo) {
		super();
		this.manejadorVehiculo = manejadorVehiculo;
	}

	@PostMapping("/vehiculo/ingresar")
	public void ingresarVehiculo(@RequestBody Vehiculo vehiculoBody) {
		
		Vehiculo vehiculo;
		
		String tipoVehiculo = vehiculoBody.getTipo();
						
		if("moto".equalsIgnoreCase(tipoVehiculo)) {
			vehiculo = new Moto(vehiculoBody.getPlaca(), vehiculoBody.getCilindraje(), tipoVehiculo);
		} else {
		    vehiculo = new Carro(vehiculoBody.getPlaca(), tipoVehiculo);
		}
		
		this.manejadorVehiculo.ingresarVehiculo(vehiculo);
	}
		
}
