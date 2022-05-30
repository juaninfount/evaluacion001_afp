package org.bootcamp.evaluacion001.services.impl;

import org.bootcamp.evaluacion001.exceptions.ModelNotFoundException;
import org.bootcamp.evaluacion001.model.FundAccount;
import org.bootcamp.evaluacion001.model.Person;
import org.bootcamp.evaluacion001.repository.FundAccountRepository;
import org.bootcamp.evaluacion001.repository.FundWithDrawalRequestRepository;
import org.bootcamp.evaluacion001.services.FundAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundAccountImpl implements FundAccountService {

    private static final org.slf4j.Logger log =  org.slf4j.LoggerFactory.getLogger(FundAccountImpl.class);
    @Autowired
    FundAccountRepository repository;

    @Override
    public List<FundAccount> findAll() {
        return repository.findAll();
    }

    @Override
    public FundAccount create(FundAccount fundAccount) {
        return repository.save(fundAccount);
    }

    @Override
    public FundAccount update(FundAccount fundAccount) {
        return repository.save(fundAccount);
    }

    @Override
    public FundAccount findById(long id) {
        var optional = repository.findById(id);
        if(optional.isEmpty())
            throw new ModelNotFoundException("Fondos AFP con id "+ id + " no encontrada.");

        return optional.get();
    }

    @Override
    public void delete(long id) {
        var optional = repository.findById(id);
        if(optional.isEmpty())
            throw new ModelNotFoundException("Cuenta de Fondos AFP con id "+ id + " no encontrada.");
        repository.deleteById(id);
    }
}
