package com.ceiba.excepcion;

public class ExcepcionVehiculoNoParqueado extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionVehiculoNoParqueado(String mensaje) {
        super(mensaje);
    }
}

