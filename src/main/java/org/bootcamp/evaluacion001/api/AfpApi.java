package org.bootcamp.evaluacion001.api;

import org.bootcamp.evaluacion001.model.AFP;
import org.bootcamp.evaluacion001.services.AfpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "afps")
public class AfpApi {
    @Autowired
    AfpService afpService;

    @GetMapping
    public ResponseEntity<List<AFP>> findAll(){
        return ResponseEntity.ok(afpService.findAll());
    }

    @PostMapping
    public  ResponseEntity<AFP> create(@Valid @RequestBody AFP afp){
        AFP response = afpService.create(afp);
        return new ResponseEntity<AFP>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public   ResponseEntity<AFP> update(@Valid @RequestBody AFP afp){
        AFP response = afpService.update(afp);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public   ResponseEntity<AFP> findById(@PathVariable("id") long id){
        return ResponseEntity.ok(afpService.findById(id));
    }

    @DeleteMapping("/{id}")
    public   ResponseEntity<Void> delete(@PathVariable("id") long id){
        afpService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
