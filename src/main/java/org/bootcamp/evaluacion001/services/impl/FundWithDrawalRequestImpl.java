package org.bootcamp.evaluacion001.services.impl;

import org.bootcamp.evaluacion001.exceptions.ModelNotFoundException;
import org.bootcamp.evaluacion001.model.FundWithDrawalRequest;
import org.bootcamp.evaluacion001.repository.FundWithDrawalRequestRepository;
import org.bootcamp.evaluacion001.services.FundWithDrawalRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundWithDrawalRequestImpl implements FundWithDrawalRequestService {

    private static final org.slf4j.Logger log =  org.slf4j.LoggerFactory.getLogger(FundWithDrawalRequestImpl.class);
    @Autowired
    FundWithDrawalRequestRepository repository;

    @Override
    public List<FundWithDrawalRequest> findAll() {
        return repository.findAll();
    }

    @Override
    public FundWithDrawalRequest create(FundWithDrawalRequest request) {
        return repository.save(request);
    }

    @Override
    public FundWithDrawalRequest update(FundWithDrawalRequest request) {
        return repository.save(request);
    }

    @Override
    public FundWithDrawalRequest findById(long id) {
        var optional = repository.findById(id);
        if(optional.isEmpty())
            throw new ModelNotFoundException("Retiro con id "+ id + " no encontrado.");

        return optional.get();
    }

    @Override
    public void delete(long id) {
        var optional = repository.findById(id);
        if(optional.isEmpty())
            throw new ModelNotFoundException("Retiro con id "+ id + " no encontrado.");

        repository.deleteById(id);
    }
}
