package org.bootcamp.evaluacion001.services;

import org.bootcamp.evaluacion001.model.Client;
import org.bootcamp.evaluacion001.model.FundWithDrawalRequest;

import java.util.List;

/**
 * Interfaz Service para entidad FundWithDrawalRequest
 */
public interface FundWithDrawalRequestService {
    List<FundWithDrawalRequest> findAll();
    FundWithDrawalRequest create(FundWithDrawalRequest request);
    FundWithDrawalRequest update(FundWithDrawalRequest request);
    FundWithDrawalRequest findById(long id);
    void delete(long id);
}
