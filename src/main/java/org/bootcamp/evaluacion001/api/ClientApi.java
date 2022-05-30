package org.bootcamp.evaluacion001.api;

import org.bootcamp.evaluacion001.model.Client;
import org.bootcamp.evaluacion001.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "clients")
public class ClientApi {

    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        return ResponseEntity.ok(clientService.findAll());
    }

    @PostMapping
    public  ResponseEntity<Client> create(@Valid @RequestBody Client Client){
        Client response = clientService.create(Client);
        return new ResponseEntity<Client>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public   ResponseEntity<Client> update(@Valid @RequestBody Client Client){
        Client response = clientService.update(Client);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public   ResponseEntity<Client> findById(@PathVariable("id") long id){
        return ResponseEntity.ok(clientService.findById(id));
    }

    @DeleteMapping("/{id}")
    public   ResponseEntity<Void> delete(@PathVariable("id") long id){
        clientService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
