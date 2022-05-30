package org.bootcamp.evaluacion001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan(basePackages = {"org.bootcamp.evaluacion001.model.entity"})
//@EnableJpaRepositories(basePackages = "org.bootcamp.evaluacion001.repository")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}