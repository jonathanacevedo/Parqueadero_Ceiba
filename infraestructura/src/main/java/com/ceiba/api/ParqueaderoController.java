package com.ceiba.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.comando.manejador.ManejadorParqueo;
import com.ceiba.comando.manejador.ManejadorVehiculo;
import com.ceiba.modelo.Carro;
import com.ceiba.modelo.Moto;
import com.ceiba.modelo.Parqueo;
import com.ceiba.modelo.Vehiculo;

@RestController
@CrossOrigin(origins = "*")
public class ParqueaderoController {
	
	private ManejadorVehiculo manejadorVehiculo;
	private ManejadorParqueo manejadorParqueo;
	
	private static final String VALORES_INCORRECTOS = "Valores incorrectos";
	
	public ParqueaderoController(ManejadorVehiculo manejadorVehiculo, ManejadorParqueo manejadorParqueo) {
		super();
		this.manejadorVehiculo = manejadorVehiculo;
		this.manejadorParqueo = manejadorParqueo;
	}	
	
	@PostMapping("/ingresar")
	public void ingresarVehiculo(@RequestBody Vehiculo vehiculoData) {
				
		if(vehiculoData.getPlaca() == null || vehiculoData.getCilindraje() == 0 || vehiculoData.getTipo() == null) {
			throw new IllegalArgumentException(VALORES_INCORRECTOS);
		}
		
		Vehiculo vehiculo;
		
		if("moto".equalsIgnoreCase(vehiculoData.getTipo())) {
			vehiculo = new Moto(vehiculoData.getPlaca(), vehiculoData.getCilindraje(), vehiculoData.getTipo());
		} else {
			vehiculo = new Carro(vehiculoData.getPlaca(), vehiculoData.getTipo());
		}
	
		this.manejadorVehiculo.ingresarVehiculo(vehiculo);		
		this.manejadorParqueo.registrarParqueo(vehiculo);
	}
	
	@PutMapping("/retirar/{placaVehiculo}")
	public void sacarVehiculo(@PathVariable String placaVehiculo) {
		
		if(!this.manejadorParqueo.consultarVehiculo(placaVehiculo)) {
			throw new IllegalArgumentException("El vehiculo no esta parqueado");
		}
		
		if(this.manejadorParqueo.consultarSalidaVehiculo(placaVehiculo)) {
			throw new IllegalArgumentException("El vehiculo ya salio del parqueadero");
		}
						
		Parqueo parqueo;
		
		parqueo = this.manejadorParqueo.obtenerParqueo(placaVehiculo);
		
		this.manejadorParqueo.retirarParqueo(parqueo);
		
	}

}
