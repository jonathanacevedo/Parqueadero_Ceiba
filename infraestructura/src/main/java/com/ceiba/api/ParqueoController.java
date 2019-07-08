package com.ceiba.api;

import org.springframework.web.bind.annotation.PostMapping;

import com.ceiba.comando.manejador.ManejadorParqueo;
import com.ceiba.modelo.Parqueo;

public class ParqueoController {
	
	private ManejadorParqueo manejadorParqueo;

	public ParqueoController(ManejadorParqueo manejadorParqueo) {
		super();
		this.manejadorParqueo = manejadorParqueo;
	}
	
	@PostMapping("registrar/parqueo")
	public void RegistrarParqueo(Parqueo parqueo) {
		
	}
	
	

}
