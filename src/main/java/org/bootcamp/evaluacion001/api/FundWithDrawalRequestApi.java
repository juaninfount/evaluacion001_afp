package org.bootcamp.evaluacion001.api;


import org.bootcamp.evaluacion001.model.FundWithDrawalRequest;
import org.bootcamp.evaluacion001.services.FundWithDrawalRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "requests")

public class FundWithDrawalRequestApi {
    @Autowired
    FundWithDrawalRequestService requestService;

    @GetMapping
    public ResponseEntity<List<FundWithDrawalRequest>> findAll() {
        return ResponseEntity.ok(requestService.findAll());
    }

    @PostMapping
    public ResponseEntity<FundWithDrawalRequest> create(@Valid @RequestBody FundWithDrawalRequest request) {
        FundWithDrawalRequest response = requestService.create(request);
        return new ResponseEntity<FundWithDrawalRequest>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<FundWithDrawalRequest> update(@Valid @RequestBody FundWithDrawalRequest request) {
        FundWithDrawalRequest response = requestService.update(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FundWithDrawalRequest> findById(@PathVariable("id") long id) {
        return ResponseEntity.ok(requestService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        requestService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}

