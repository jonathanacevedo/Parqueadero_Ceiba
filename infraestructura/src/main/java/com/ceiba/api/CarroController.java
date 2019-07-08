package com.ceiba.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.comando.manejador.ManejadorCarro;
import com.ceiba.modelo.Carro;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/parqueadero",
				headers = {
						"Accept = application/json",
						"Content-Type = application/json"
				})
public class CarroController {
	
	private ManejadorCarro manejadorCarro;

	public CarroController(ManejadorCarro manejadorCarro) {
		super();
		this.manejadorCarro = manejadorCarro;
	}

	@PostMapping(value="carros")
	public void crearCarro(@RequestBody Carro carro) {
		this.manejadorCarro.crearCarro(carro);
	
	}
	
}