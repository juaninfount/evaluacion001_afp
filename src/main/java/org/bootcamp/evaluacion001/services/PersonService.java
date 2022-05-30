package org.bootcamp.evaluacion001.services;

import org.bootcamp.evaluacion001.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {

    List<Person> findAll();
    Person create(Person persona);
    Person update(Person persona);
    Person findById(long id);
    void delete(long id);
    //Page<Person> pagination(Pageable pageable);
}