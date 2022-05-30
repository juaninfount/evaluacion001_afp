package org.bootcamp.evaluacion001.api;
import org.bootcamp.evaluacion001.model.Person;
import org.bootcamp.evaluacion001.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "persons")
public class PersonApi {

    @Autowired
    PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> findAll(){
        return ResponseEntity.ok(personService.findAll());
    }

    @PostMapping
    public  ResponseEntity<Person> create(@Valid @RequestBody Person person){
        Person response = personService.create(person);
        return new ResponseEntity<Person>(response, HttpStatus.CREATED);
    }

    @PostMapping("/createList")
    public  ResponseEntity<Boolean> createList(@RequestBody List<Person> personList){
        return new ResponseEntity<Boolean>(personService.createList(personList), HttpStatus.CREATED);
    }

    @PutMapping
    public   ResponseEntity<Person> update(@Valid @RequestBody Person person){
        Person response = personService.update(person);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public   ResponseEntity<Person> findById(@PathVariable("id") long id){
        return ResponseEntity.ok(personService.findById(id));
    }

    @DeleteMapping("/{id}")
    public   ResponseEntity<Void> delete(@PathVariable("id") long id){
        personService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
