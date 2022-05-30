package org.bootcamp.evaluacion001.services;

import org.bootcamp.evaluacion001.model.Client;
import org.bootcamp.evaluacion001.model.Employeer;

import java.util.List;


/**
 * Interfaz Service para entidad Employeer
 */
public interface EmployeerService {
    List<Employeer> findAll();
    Employeer create(Employeer client);
    Employeer update(Employeer client);
    Employeer findById(long id);
    void delete(long id);
}
