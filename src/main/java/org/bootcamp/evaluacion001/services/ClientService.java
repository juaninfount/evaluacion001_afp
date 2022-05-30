package org.bootcamp.evaluacion001.services;

import org.bootcamp.evaluacion001.model.Client;
import org.bootcamp.evaluacion001.model.Person;

import java.util.List;

/**
 * Interfaz Service para entidad Client
 */
public interface ClientService {
    List<Client> findAll();
    Client create(Client client);
    Client update(Client client);
    Client findById(long id);
    void delete(long id);
}
