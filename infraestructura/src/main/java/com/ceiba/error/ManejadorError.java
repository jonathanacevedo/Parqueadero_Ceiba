package com.ceiba.error;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ceiba.excepcion.ExcepcionDuplicidad;
import com.ceiba.excepcion.ExcepcionSinCupo;
import com.ceiba.excepcion.ExcepcionVehiculoNoParqueado;

@ControllerAdvice
public class ManejadorError extends ResponseEntityExceptionHandler {
    
    public static final Logger LOGGER_ERROR = LoggerFactory.getLogger(ManejadorError.class);

    public static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR = "Ocurrio un error favor contactar al administrador.";

    public static final String RECURSO_NO_ENCONTRADO = "El recurso consultado no ha sido encontrado.";
    
    public static final String NO_AUTORIZADO_A_INGRESAR = "No esta autorizado a ingresar";
    
	public static final String VEHICULO_NO_PARQUEADO = "El vehiculo no esta parqueado";
	
	public static final String VEHICULO_SIN_CUPO = "No hay cupo disponible para el Vehiculo";

    
    private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();
    
    public ManejadorError() {
        CODIGOS_ESTADO.put(ExcepcionDuplicidad.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
    }


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Error> handleAllExceptions(Exception exception) {
        ResponseEntity<Error> resultado;

        String excepcionNombre = exception.getClass().getSimpleName();
        String mensaje = exception.getMessage();
        Integer codigo = CODIGOS_ESTADO.get(excepcionNombre);

        if (codigo != null) {
            Error error = new Error(excepcionNombre, mensaje);
            resultado = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
        } else {
            LOGGER_ERROR.error(excepcionNombre, exception);
            Error error = new Error(excepcionNombre, OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR);
            resultado = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return resultado;
    }
    
    
    @ExceptionHandler(ExcepcionVehiculoNoParqueado.class)
    public final ResponseEntity<Error> handleVehiculoNoParqueado(ExcepcionVehiculoNoParqueado exception) {
        ResponseEntity<Error> resultado;

        String excepcionNombre = exception.getClass().getSimpleName();
        String mensaje = exception.getMessage();
        Integer codigo = CODIGOS_ESTADO.get(excepcionNombre);

        if (codigo != null) {
            Error error = new Error(excepcionNombre, mensaje);
            resultado = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
        } else {
            LOGGER_ERROR.error(excepcionNombre, exception);
            Error error = new Error(excepcionNombre, VEHICULO_NO_PARQUEADO);
            resultado = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }

        return resultado;
    }
    
    @ExceptionHandler(ExcepcionSinCupo.class)
    public final ResponseEntity<Error> handleParqueoSinCupo(ExcepcionSinCupo exception) {
        ResponseEntity<Error> resultado;

        String excepcionNombre = exception.getClass().getSimpleName();
        String mensaje = exception.getMessage();
        Integer codigo = CODIGOS_ESTADO.get(excepcionNombre);

        if (codigo != null) {
            Error error = new Error(excepcionNombre, mensaje);
            resultado = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
        } else {
            LOGGER_ERROR.error(excepcionNombre, exception);
            Error error = new Error(excepcionNombre, VEHICULO_SIN_CUPO);
            resultado = new ResponseEntity<>(error, HttpStatus.INSUFFICIENT_STORAGE);
        }

        return resultado;
    }
}