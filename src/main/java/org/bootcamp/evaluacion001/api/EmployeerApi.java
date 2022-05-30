package org.bootcamp.evaluacion001.api;

import org.bootcamp.evaluacion001.model.Employeer;
import org.bootcamp.evaluacion001.services.EmployeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "employeers")
public class EmployeerApi {

    @Autowired
    EmployeerService employeerService;
    
    @GetMapping
    public ResponseEntity<List<Employeer>> findAll(){
        return ResponseEntity.ok(employeerService.findAll());
    }

    @PostMapping
    public  ResponseEntity<Employeer> create(@Valid @RequestBody Employeer employeer){
        Employeer response = employeerService.create(employeer);
        return new ResponseEntity<Employeer>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public   ResponseEntity<Employeer> update(@Valid @RequestBody Employeer employeer){
        Employeer response = employeerService.update(employeer);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public   ResponseEntity<Employeer> findById(@PathVariable("id") long id){
        return ResponseEntity.ok(employeerService.findById(id));
    }

    @DeleteMapping("/{id}")
    public   ResponseEntity<Void> delete(@PathVariable("id") long id){
        employeerService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
