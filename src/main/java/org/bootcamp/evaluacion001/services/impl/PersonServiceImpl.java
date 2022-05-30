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

    private static final org.slf4j.Logger log =  org.slf4j.LoggerFactory.getLogger(PersonServiceImpl.class);
    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        log.debug("PersonServiceImpl::findAll");
        return personRepository.findAll();
    }

    @Override
    public Person create(Person persona) {
        log.debug("PersonServiceImpl::create");
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
        log.debug("PersonServiceImpl::update");
        return personRepository.save(person);
    }

    @Override
    public Person findById(long id){
        var optional = personRepository.findById(id);
         if(optional.isEmpty())
            throw new ModelNotFoundException("Persona con id "+ id + " no encontrada.");

        log.debug("PersonServiceImpl::findById");
        return optional.get();
    }

    @Override
    public void delete(long id) {
        var optional = personRepository.findById(id);
        if(optional.isEmpty())
            throw new ModelNotFoundException("Persona con id "+ id + " no encontrada.");

        log.debug("PersonServiceImpl::delete");
        personRepository.deleteById(id);
    }

    @Override
    public boolean createList(List<Person> personList) {
        personRepository.saveAll(personList);

        log.debug("PersonServiceImpl::createList");
        return true;
    }

}