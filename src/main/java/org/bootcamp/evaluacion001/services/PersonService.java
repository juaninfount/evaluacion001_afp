package org.bootcamp.evaluacion001.services;

import org.bootcamp.evaluacion001.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Interfaz Service para entidad Person
 */
public interface PersonService {

    List<Person> findAll();
    Person create(Person persona);
    Person update(Person persona);
    Person findById(long id);
    void delete(long id);

    boolean createList(List<Person> personList);
    //Page<Person> pagination(Pageable pageable);
}