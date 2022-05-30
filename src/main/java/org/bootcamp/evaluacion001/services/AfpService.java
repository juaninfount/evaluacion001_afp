package org.bootcamp.evaluacion001.services;

import org.bootcamp.evaluacion001.model.AFP;
import org.bootcamp.evaluacion001.model.Person;
import org.bootcamp.evaluacion001.repository.AfpRepository;
import org.bootcamp.evaluacion001.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Interfaz Service para entidad AFP
 */
public interface AfpService {

    List<AFP> findAll();
    AFP create(AFP afp);
    AFP update(AFP afp);
    AFP findById(long id);
    void delete(long id);


}
