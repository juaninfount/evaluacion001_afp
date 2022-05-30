package org.bootcamp.evaluacion001.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Schema(description = "Entidad del modelo de Dominio Cuenta de Fondos")
@Data   // genera codigo de los metodos y constructor mas repetidos (boilerplate)
@Entity // representacion de POJO
@Table(name="FundAccount")
public class FundAccount {

    @Id
    @Schema(description = "ID de Cuenta AFP de un cliente")
    @Column(name = "fundAccountID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long fundAccountID;

    @Schema(description = "Saldo actual de la cuenta", minimum = "1")
    @Column(name = "balance", nullable = false)
    private double balance;

    @Schema(description = "Nro de cuenta afp")
    @Pattern(regexp = "\\d-*", message = "Nro Cuenta afp compuesta de dígitos y guiones")
    @Size(min=10, max = 20, message = "Longitud de Nro de cuenta afp de máx de 20 caracteres")
    @Column(name = "account", nullable = false, length = 20, unique = true)
    private String account;

    @Schema(description = "Flag de estado de registro")
    @Column(name = "active", nullable = false)
    private boolean active;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clientID",foreignKey = @ForeignKey(name="FK_CLIENT"),referencedColumnName ="clientID",unique = true,nullable = false)
    private Client client;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "afpID",foreignKey = @ForeignKey(name="FK_AFP"),referencedColumnName ="afpID",nullable = false)
    private AFP afp;

    @OneToMany(mappedBy = "fundAccount", cascade = CascadeType.ALL)
    private List<FundWithDrawalRequest> requests;
}
