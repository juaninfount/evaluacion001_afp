package org.bootcamp.evaluacion001.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Schema(description = "Entidad del modelo de Dominio Empleador")
@Data // genera codigo de los metodos y constructor mas repetidos (boilerplate)
@Entity // representacion de POJO
@Table(name="Employeer")
public class Employeer {

    @Id
    @Schema(description = "ID de Empleado")
    @Column(name = "employeerID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeerID;

    @Schema(description = "Razón Social/Nombre de empleador")
    @Size(max = 100,message = "Razón Social/Nombre del empleador")
    @Column(name = "employerBusinessName", length = 100)
    private String employerBusinessName;

    @Schema(description = "RUC")
    @Pattern(regexp = "[0-9]+", message = "El nro RUC está compuesto únicamente de 11 dígitos")
    @Size(min=11, max = 11, message = "Longitud de RUC de 11 dígitos")
    @Column(name = "ruc", nullable = false, length = 11, unique = true)
    private String ruc;

    @Schema(description = "Flag de estado de registro")
    @Column(name = "active", nullable = false)
    private boolean active;

    @OneToMany(mappedBy = "employeer", cascade = CascadeType.ALL)
    private List<Client> client;

}
