package org.bootcamp.evaluacion001.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Schema(description = "Entidad del modelo de Dominio Cliente")
@Data   // genera codigo de los metodos y constructor mas repetidos (boilerplate)
@Entity // representacion de POJO
@Table(name="Client", indexes = { @Index(name = "IDX_Person", columnList = "personID asc") })
public class Client //extends Person
{
    public Client() {
    }

    @Id
    @Schema(description = "ID de Cliente")
    @Column(name = "clientID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clientID;

    @Schema(description = "Flag de estado de registro")
    @Column(name = "active", nullable = false)
    private boolean active;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employeerID",foreignKey = @ForeignKey(name="FK_EMPLOYEER"),referencedColumnName ="employeerID",nullable = false)
    private Employeer employeer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personID",foreignKey = @ForeignKey(name="FK_PERSON"),referencedColumnName ="personID",nullable = false)
    private Person person;


}
