package org.bootcamp.evaluacion001.exceptions;


public class ModelNotFoundException extends RuntimeException {

    public ModelNotFoundException(String mensaje) {
        super(mensaje);
    }
}

