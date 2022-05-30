package org.bootcamp.evaluacion001.repository;

import org.bootcamp.evaluacion001.model.Client;
import org.bootcamp.evaluacion001.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource

public interface ClientRepository  extends JpaRepository<Client, Long> {

}
