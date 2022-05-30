package org.bootcamp.evaluacion001.services.impl;

import org.bootcamp.evaluacion001.exceptions.ModelNotFoundException;
import org.bootcamp.evaluacion001.model.Client;
import org.bootcamp.evaluacion001.model.Employeer;
import org.bootcamp.evaluacion001.repository.EmployeerRepository;
import org.bootcamp.evaluacion001.repository.FundAccountRepository;
import org.bootcamp.evaluacion001.services.EmployeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeerServiceImpl implements EmployeerService {

    private static final org.slf4j.Logger log =  org.slf4j.LoggerFactory.getLogger(EmployeerServiceImpl.class);
    @Autowired
    EmployeerRepository repository;

    @Override
    public List<Employeer> findAll() {
        return repository.findAll();
    }

    @Override
    public Employeer create(Employeer employeer) {
        return repository.save(employeer);
    }

    @Override
    public Employeer update(Employeer employeer){
        return repository.save(employeer);
    }

    @Override
    public Employeer findById(long id) {
        var optional = repository.findById(id);
        if(optional.isEmpty())
            throw new ModelNotFoundException("Empleador con id "+ id + " no encontrado.");

        return optional.get();
    }

    @Override
    public void delete(long id) {
        var optional = repository.findById(id);
        if(optional.isEmpty())
            throw new ModelNotFoundException("Empleador con id "+ id + " no encontrado.");
        repository.deleteById(id);
    }
}
