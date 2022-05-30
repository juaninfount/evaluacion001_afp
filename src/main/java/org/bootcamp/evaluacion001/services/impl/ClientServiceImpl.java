package org.bootcamp.evaluacion001.services.impl;

import org.bootcamp.evaluacion001.exceptions.ModelNotFoundException;
import org.bootcamp.evaluacion001.model.Client;
import org.bootcamp.evaluacion001.repository.ClientRepository;
import org.bootcamp.evaluacion001.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private static final org.slf4j.Logger log =  org.slf4j.LoggerFactory.getLogger(ClientServiceImpl.class);
    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client findById(long id) {
        var optional = clientRepository.findById(id);
        if(optional.isEmpty())
            throw new ModelNotFoundException("Cliente con id "+ id + " no encontrado.");

        return optional.get();
    }

    @Override
    public void delete(long id) {
        var optional = clientRepository.findById(id);
        if(optional.isEmpty())
            throw new ModelNotFoundException("Cliente con id "+ id + " no encontrado.");

        clientRepository.deleteById(id);
    }
}
