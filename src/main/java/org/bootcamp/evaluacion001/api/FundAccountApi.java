package org.bootcamp.evaluacion001.api;


import org.bootcamp.evaluacion001.model.FundAccount;
import org.bootcamp.evaluacion001.services.FundAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "fundAccounts")

public class FundAccountApi {
    @Autowired
    FundAccountService fundAccountService;

    @GetMapping
    public ResponseEntity<List< FundAccount>> findAll() {
        return ResponseEntity.ok(fundAccountService.findAll());
    }

    @PostMapping
    public ResponseEntity< FundAccount> create(@Valid @RequestBody  FundAccount fundAccount) {
         FundAccount response = fundAccountService.create(fundAccount);
        return new ResponseEntity< FundAccount>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity< FundAccount> update(@Valid @RequestBody  FundAccount fundAccount) {
         FundAccount response = fundAccountService.update(fundAccount);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity< FundAccount> findById(@PathVariable("id") long id) {
        return ResponseEntity.ok(fundAccountService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        fundAccountService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}

