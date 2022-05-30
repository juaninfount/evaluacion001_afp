package org.bootcamp.evaluacion001.services;

import org.bootcamp.evaluacion001.model.FundAccount;
import org.bootcamp.evaluacion001.model.Person;

import java.util.List;

/**
 * Interfaz Service para entidad FundAccount
 */
public interface FundAccountService {
    List<FundAccount> findAll();
    FundAccount create(FundAccount fundAccount);
    FundAccount update(FundAccount fundAccount);
    FundAccount findById(long id);
    void delete(long id);
}
