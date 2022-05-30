package org.bootcamp.evaluacion001.services.impl;

import org.bootcamp.evaluacion001.exceptions.ModelNotFoundException;
import org.bootcamp.evaluacion001.model.AFP;
import org.bootcamp.evaluacion001.repository.AfpRepository;
import org.bootcamp.evaluacion001.services.AfpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AfpServiceImpl implements AfpService {

    private static final org.slf4j.Logger log =  org.slf4j.LoggerFactory.getLogger(AfpServiceImpl.class);
    @Autowired
    AfpRepository afpRepository;

    @Override
    public List<AFP> findAll() {
        log.debug("AfpServiceImpl::findAll");
        return afpRepository.findAll();
    }

    @Override
    public AFP create(AFP afp) {
        log.debug("AfpServiceImpl::create");
        return afpRepository.save(afp);
    }

    @Override
    public AFP update(AFP afp) {
        log.debug("AfpServiceImpl::update");
        return afpRepository.save(afp);
    }

    @Override
    public AFP findById(long id) {
        var optional = afpRepository.findById(id);
        if(optional.isEmpty())
            throw new ModelNotFoundException("AFP con id "+ id + " no encontrada.");

        log.debug("AfpServiceImpl::findById");
        return optional.get();
    }

    @Override
    public void delete(long id) {
        var optional = afpRepository.findById(id);
        if(optional.isEmpty())
            throw new ModelNotFoundException("AFP con id "+ id + " no encontrada.");

        log.debug("AfpServiceImpl::deleteById");
        afpRepository.deleteById(id);
    }
}
