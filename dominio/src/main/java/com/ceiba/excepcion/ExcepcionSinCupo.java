package com.ceiba.excepcion;

public class ExcepcionSinCupo extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionSinCupo(String mensaje) {
        super(mensaje);
    }
    
}
