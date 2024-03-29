package com.ceiba.servicio;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ceiba.excepcion.ExcepcionDuplicidad;
import com.ceiba.excepcion.ExcepcionSinCupo;
import com.ceiba.excepcion.ExcepcionVehiculoNoParqueado;
import com.ceiba.modelo.Carro;
import com.ceiba.modelo.Moto;
import com.ceiba.modelo.Parqueo;
import com.ceiba.modelo.RespuestaParqueo;
import com.ceiba.modelo.RespuestaRetiroVehiculo;
import com.ceiba.modelo.Vehiculo;
import com.ceiba.repositorio.ParqueoRepositorio;
import com.ceiba.repositorio.VehiculoRepositorio;

public class ServicioParqueadero {
	
	private ParqueoRepositorio parqueoFachadaInterface;
	
	private VehiculoRepositorio vehiculoFachadaInterface;
	
	public static final String EL_VEHICULO_YA_EXISTE_EN_EL_SISTEMA = "El vehiculo ya existe en el sistema";
	public static final String VEHICULO_NO_PARQUEADO = "El vehiculo no esta parqueado";
	private static final int PRECIO_INICIAL = 0;
	private static final int PRECIO_HORA_MOTO = 500;
	private static final int PRECIO_HORA_CARRO = 1000;
	private static final int PRECIO_DIA_MOTO = 4000;
	private static final int PRECIO_DIA_CARRO = 8000;
	public static final String NO_AUTORIZADO_A_INGRESAR = "No esta autorizado a ingresar";
	public static final String NO_HAY_CUPO_PARA_EL_VEHICULO = "No hay cupo para el vehiculo que intenta ingresar";
	private static final int MAXIMO_CUPO_CARROS = 20;
	private static final int MAXIMO_CUPO_MOTOS = 10;
	private static final String CONSTANTE_DIAS = "DIAS";
	private static final String CONSTANTE_HORAS= "HORAS";
	
	
	public ServicioParqueadero(VehiculoRepositorio vehiculoFachadaInterface, ParqueoRepositorio parqueoFachadaInterface) {
		this.parqueoFachadaInterface = parqueoFachadaInterface;
		this.vehiculoFachadaInterface = vehiculoFachadaInterface;
	}

	public boolean consultarVehiculo(String placa) {
		return this.parqueoFachadaInterface.consultarVehiculo(placa);
	}
	
	public boolean consultarSalidaVehiculo(String placa) {
		return this.parqueoFachadaInterface.consultarSalidaVehiculo(placa);
	}
	
	public List<RespuestaParqueo> consultarVehiculosParqueados(){
		return this.parqueoFachadaInterface.consultarVehiculosParqueados();
	}
	
	
	public void ingresarVehiculo(Vehiculo vehiculoData) {
		
		Vehiculo vehiculo;
		
		if("moto".equalsIgnoreCase(vehiculoData.getTipo())) {
			vehiculo = new Moto(vehiculoData.getPlaca(), vehiculoData.getCilindraje(), vehiculoData.getTipo());
		} else {
			vehiculo = new Carro(vehiculoData.getPlaca(), vehiculoData.getTipo());
		}
				
		validarExistenciaPrevia(vehiculo);
		
		Date fechaActual = new Date();
		
		if (!puedeIngresar(vehiculo.getPlaca(), fechaActual)) {
			throw new IllegalStateException(NO_AUTORIZADO_A_INGRESAR);
		}
		
		if(!hayEspacio(vehiculo.getTipo())) {
			throw new ExcepcionSinCupo(NO_HAY_CUPO_PARA_EL_VEHICULO);
		}

		this.vehiculoFachadaInterface.ingresarVehiculo(vehiculo);
		
		Parqueo parqueo = new Parqueo(vehiculo, fechaActual, null, PRECIO_INICIAL);
		this.parqueoFachadaInterface.registrarParqueo(parqueo);
	}
	

	public RespuestaRetiroVehiculo retirarParqueo(Parqueo parqueo) {
		
		if(parqueo == null) {
			throw new ExcepcionVehiculoNoParqueado(VEHICULO_NO_PARQUEADO);
		}
		
		String placaVehiculo = parqueo.getVehiculo().getPlaca();
		
		if(!this.parqueoFachadaInterface.consultarVehiculo(placaVehiculo)) {
			throw new ExcepcionVehiculoNoParqueado(VEHICULO_NO_PARQUEADO);
		}
		
		if(this.parqueoFachadaInterface.consultarSalidaVehiculo(placaVehiculo)) {
			throw new ExcepcionVehiculoNoParqueado(VEHICULO_NO_PARQUEADO);
		}
				
		double valorAPagar = 0;
		
		valorAPagar = calcularValorAPagar(parqueo.getVehiculo(), parqueo.getFechaInicio());
		parqueo.setValor(valorAPagar);
		parqueo.setFechaFin(new Date());
		return this.parqueoFachadaInterface.retirarParqueo(parqueo);
	}
		
	public boolean puedeIngresar(String placaVehiculo, Date fechaPosibleIngreso) {

		boolean ingresoValido = true;

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaPosibleIngreso);

		if (placaVehiculo.startsWith("A") && (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY
				&& calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY)) {
			ingresoValido = false;
		}

		return ingresoValido;
	}
	
	public double calcularValorAPagar(Vehiculo vehiculo, Date fechaIngreso) {
		
		int numeroHoras = obtenerNumeroDeHoras(fechaIngreso);
		double valorAPagar = 0;
				
		Map<String, Integer> diasHoras = obtenerNumeroDiasHoras(numeroHoras);
		int dias = diasHoras.get(CONSTANTE_DIAS);
		int horas = diasHoras.get(CONSTANTE_HORAS);
			
		if(vehiculo instanceof Moto) {
			valorAPagar = (double)(dias * PRECIO_DIA_MOTO) + (horas * PRECIO_HORA_MOTO);
			if(vehiculo.getCilindraje() > 500) {
				valorAPagar = valorAPagar + 2000;
			}
		} else {
			valorAPagar = (double)(dias * PRECIO_DIA_CARRO) + (horas * PRECIO_HORA_CARRO);
		}
		
		return valorAPagar;
		
	}
	
	public Map<String, Integer> obtenerNumeroDiasHoras(int numeroHoras) {
		
		int contDias = 0;
		int auxNumeroHoras = numeroHoras;
		int nroHoras = 0;
		
		Map<String, Integer> diasHoras = new HashMap<>();
		
		 while(auxNumeroHoras >= 9) {
			contDias++;
			auxNumeroHoras = auxNumeroHoras - 24;
		}
		
		if(auxNumeroHoras > 0) {
			nroHoras = auxNumeroHoras;
		}
		
		diasHoras.put(CONSTANTE_DIAS, contDias);
		diasHoras.put(CONSTANTE_HORAS, nroHoras);
		
		return diasHoras;
	}
	
	public int obtenerNumeroDeHoras(Date fechaIngreso) {
		long periodo = new Date().getTime() - fechaIngreso.getTime();
		double horasDiferencia = (periodo / (60 * 60 * 1000));
				
		if(horasDiferencia == 0){
			horasDiferencia = 1;
		}
		
		return (int)horasDiferencia;
	}
	
	public Parqueo obtenerParqueo(String placa) {
		return this.parqueoFachadaInterface.obtenerParqueo(placa);
	}
		
	public void validarExistenciaPrevia(Vehiculo vehiculo) {
				
		Parqueo parqueo = this.parqueoFachadaInterface.obtenerParqueo(vehiculo.getPlaca());
		
		if(parqueo != null && parqueo.getFechaFin() == null) {
			throw new ExcepcionDuplicidad(EL_VEHICULO_YA_EXISTE_EN_EL_SISTEMA);
		}
	}
	
	public boolean hayEspacio(String tipoVehiculo) {
		boolean hayEspacio = true;
		
		int numeroVehiculos = this.parqueoFachadaInterface.contarVehiculosEnParqueadero(tipoVehiculo);
				
		if("Carro".equals(tipoVehiculo) && numeroVehiculos >= MAXIMO_CUPO_CARROS) {
			hayEspacio = false;
		}
		
		if("Moto".equals(tipoVehiculo) && numeroVehiculos >= MAXIMO_CUPO_MOTOS) {
			hayEspacio = false;
		}
		
		return hayEspacio;
	}

		
}
