package org.bootcamp.evaluacion001.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Schema(description = "Entidad del modelo de Dominio AFP")
@Data   // genera codigo de los metodos y constructor mas repetidos (boilerplate)
@Entity // representacion de POJO
@Table(name="AFP")
public class AFP {

    @Id
    @Schema(description = "ID de empresa AFP")
    @Column(name = "AFPID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long AFPID;

    @Schema(description = "Nombre de AFP")
    @Size(min=2, max=100, message = "Nombre de AFP debe tener como mínimo 2 caracteres y máximo 100")
    @Column(name = "businessName", nullable = false, length = 100)
    private String businessName;

    @Schema(description = "Nombre de AFP")
    @Size(max=16, message = "Acronimo de AFP debe tener como máximo 16 caracteres")
    @Column(name = "acronym", nullable = false, length = 16)
    private String acronym;

    @Schema(description = "Flag de estado de registro")
    @Column(name = "active", nullable = false)
    private boolean active;
}
