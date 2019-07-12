package com.ceiba.controlador;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.comando.manejador.ManejadorParqueadero;
import com.ceiba.error.ManejadorError;
import com.ceiba.excepcion.ExcepcionVehiculoNoParqueado;
import com.ceiba.modelo.Parqueo;
import com.ceiba.modelo.Vehiculo;

@RestController
@CrossOrigin(origins = "*")
public class ParqueaderoControlador {
	
	private ManejadorParqueadero manejadorParqueadero;	
	private static final String VALORES_INCORRECTOS = "Valores incorrectos";
	
	public ParqueaderoControlador(ManejadorParqueadero manejadorParqueadero) {
		this.manejadorParqueadero = manejadorParqueadero;
	}	
	
	
	@PostMapping("/vehiculos")
	public void ingresarVehiculo(@RequestBody Vehiculo vehiculo) {
				
		if(vehiculo.getPlaca() == null || vehiculo.getTipo() == null) {
			throw new IllegalArgumentException(VALORES_INCORRECTOS);
		}
		this.manejadorParqueadero.ingresarVehiculo(vehiculo);
	}
	
	@GetMapping("/vehiculos")
	public List<Parqueo> consultarVehiculosParqueados() {
		
		Date fecha = new Date();
		
		return this.manejadorParqueadero.consultarVehiculosParqueados();
	}
	
	@PutMapping("/vehiculos/{placaVehiculo}")
	public void sacarVehiculo(@PathVariable String placaVehiculo) {
		
		
		if(!this.manejadorParqueadero.consultarVehiculo(placaVehiculo)) {
			throw new ExcepcionVehiculoNoParqueado(ManejadorError.VEHICULO_NO_PARQUEADO);
		}
		
		if(this.manejadorParqueadero.consultarSalidaVehiculo(placaVehiculo)) {
			throw new ExcepcionVehiculoNoParqueado(ManejadorError.VEHICULO_NO_PARQUEADO);
		}
		
		Parqueo parqueo;
		
		parqueo = this.manejadorParqueadero.obtenerParqueo(placaVehiculo);
		
						
		this.manejadorParqueadero.retirarParqueo(parqueo);
		
	}
	
}
