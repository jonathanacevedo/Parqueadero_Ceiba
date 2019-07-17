package com.ceiba.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.comando.manejador.ManejadorParqueadero;
import com.ceiba.modelo.Parqueo;
import com.ceiba.modelo.RespuestaParqueo;
import com.ceiba.modelo.RespuestaRetiroVehiculo;
import com.ceiba.modelo.Vehiculo;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ParqueaderoControlador {
	
	private ManejadorParqueadero manejadorParqueadero;	
	private static final String VALORES_INCORRECTOS = "Valores incorrectos";
	
	@Autowired
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
	public List<RespuestaParqueo> consultarVehiculosParqueados() {		
		return this.manejadorParqueadero.consultarVehiculosParqueados();
	}
	
	@PutMapping("/vehiculos/{placaVehiculo}")
	public RespuestaRetiroVehiculo sacarVehiculo(@PathVariable String placaVehiculo) {
		Parqueo parqueo;
		parqueo = this.manejadorParqueadero.obtenerParqueo(placaVehiculo);						
		return this.manejadorParqueadero.retirarParqueo(parqueo);
	}
	
}
