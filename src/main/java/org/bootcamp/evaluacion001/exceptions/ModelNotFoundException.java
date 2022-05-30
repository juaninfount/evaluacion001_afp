package org.bootcamp.evaluacion001.exceptions;


import org.bootcamp.evaluacion001.services.impl.AfpServiceImpl;

public class ModelNotFoundException extends RuntimeException {

    public ModelNotFoundException(String mensaje) {
        super(mensaje);
    }
}

