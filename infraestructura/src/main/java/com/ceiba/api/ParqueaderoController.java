package com.ceiba.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.comando.manejador.ManejadorParqueadero;
import com.ceiba.modelo.Carro;
import com.ceiba.modelo.Moto;
import com.ceiba.modelo.Parqueo;
import com.ceiba.modelo.Vehiculo;

@RestController
@CrossOrigin(origins = "*")
public class ParqueaderoController {
	
	private ManejadorParqueadero manejadorParqueadero;	
	private static final String VALORES_INCORRECTOS = "Valores incorrectos";
	
	public ParqueaderoController(ManejadorParqueadero manejadorParqueadero) {
		super();
		this.manejadorParqueadero = manejadorParqueadero;
	}	
	
	@PostMapping("/ingresar")
	public void ingresarVehiculo(@RequestBody Vehiculo vehiculoData) {
				
		if(vehiculoData.getPlaca() == null || vehiculoData.getTipo() == null) {
			throw new IllegalArgumentException(VALORES_INCORRECTOS);
		}
		
		Vehiculo vehiculo;
		
		if("moto".equalsIgnoreCase(vehiculoData.getTipo())) {
			vehiculo = new Moto(vehiculoData.getPlaca(), vehiculoData.getCilindraje(), vehiculoData.getTipo());
		} else {
			vehiculo = new Carro(vehiculoData.getPlaca(), vehiculoData.getTipo());
		}
			
		this.manejadorParqueadero.ingresarVehiculo(vehiculo);
		
	}
	
	@PutMapping("/retirar/{placaVehiculo}")
	public void sacarVehiculo(@PathVariable String placaVehiculo) {
		
		if(!this.manejadorParqueadero.consultarVehiculo(placaVehiculo)) {
			throw new IllegalArgumentException("El vehiculo no esta parqueado");
		}
		
		if(this.manejadorParqueadero.consultarSalidaVehiculo(placaVehiculo)) {
			throw new IllegalArgumentException("El vehiculo ya salio del parqueadero");
		}
						
		Parqueo parqueo;
		
		parqueo = this.manejadorParqueadero.obtenerParqueo(placaVehiculo);
		this.manejadorParqueadero.retirarParqueo(parqueo);
		
	}
	
}
