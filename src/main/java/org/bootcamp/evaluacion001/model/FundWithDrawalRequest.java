package org.bootcamp.evaluacion001.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Schema(description = "Entidad del modelo de Dominio Retiro de cuenta de fondos")
@Data   // genera codigo de los metodos y constructor mas repetidos (boilerplate)
@Entity // representacion de POJO
@Table(name="FundWithDrawalRequest")
public class FundWithDrawalRequest {

    @Id
    @Schema(description = "ID de Retiro")
    @Column(name = "fundWithDrawalRequestID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long fundWithDrawalRequestID;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fundAccountID", foreignKey = @ForeignKey(name = "FK_FUNDACCOUNT"),
            referencedColumnName = "fundAccountID", nullable = false)
    private FundAccount fundAccount;

    @Schema(description = "Monto de retiro")
    @Column(name = "withdrawalAmount", nullable = false)
    private double   withdrawalAmount;

    @Schema(description = "Fecha de retiro de monto")
    @Column(name = "withDrawalDate", nullable = false)
    private Date withdrawalDate;

    @Schema(description = "Nombre de AFP")
    @Column(name = "businessName", nullable = false, length = 100)
    private String businessName;

    @Schema(description = "Flag de estado de registro")
    @Column(name = "active", nullable = false)
    private boolean active;

}
