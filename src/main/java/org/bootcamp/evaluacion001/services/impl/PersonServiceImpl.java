package org.bootcamp.evaluacion001.services.impl;

import org.bootcamp.evaluacion001.exceptions.ModelNotFoundException;
import org.bootcamp.evaluacion001.model.Person;
import org.bootcamp.evaluacion001.repository.PersonRepository;
import org.bootcamp.evaluacion001.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person create(Person persona) {
        return personRepository.save(persona);
    }

    @Override
    public Person update(Person person) {

        try {
            var optional = personRepository.findById(person.getPersonID());
            if(optional.isEmpty())
                throw new ModelNotFoundException("Persona con id "+ person.getPersonID() + " no encontrada.");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return personRepository.save(person);
    }

    @Override
    public Person findById(long id){
        var optional = personRepository.findById(id);
         if(optional.isEmpty())
            throw new ModelNotFoundException("Persona con id "+ id + " no encontrada.");

        return optional.get();
    }

    @Override
    public void delete(long id) {
        var optional = personRepository.findById(id);
        if(optional.isEmpty())
            throw new ModelNotFoundException("Persona con id "+ id + " no encontrada.");
        personRepository.deleteById(id);
    }

}