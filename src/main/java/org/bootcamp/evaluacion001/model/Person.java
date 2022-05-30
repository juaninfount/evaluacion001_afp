package org.bootcamp.evaluacion001.model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.annotations.CollectionId;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Schema(description = "Entidad del modelo de Dominio Persona")
@Data  // genera codigo de los metodos y constructor mas repetidos (boilerplate)
@Entity // representacion de POJO
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Person {

    @Id
    @Schema(description = "ID de persona")
    @Column(name = "personID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personID;

    @Schema(description = "Nombres de persona")
    @Size(min=2, max=100, message = "Nombres debe tener como mínimo 2 caracteres y maximo 100")
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Schema(description = "Apellidos de persona")
    @Size(min=2, max=100, message = "Apellidos debe tener como mínimo 2 caracteres y maximo 100")
    @Column(name = "lastName", nullable = false, length = 100)
    private String lastName;

    @Schema(description = "Documento Nacional de Identidad")
    @Pattern(regexp = "\\d+", message = "El DNI está compuesto únicamente de 8 números enteros")
    @Size(min=8, max = 8, message = "Longitud de DNI de 8 dígitos")
    @Column(name = "idCard", nullable = false, length = 8, unique = true)
    private String idCard;

    @Schema(description = "Número de teléfono móvil")
    @Pattern(regexp = "\\d+", message = "Número de teléfono está compuesto únicamente de números enteros")
    @Size(min=9, max = 20, message = "Número de teléfono debe tener como mínimo 9 dígitos y máximo 20 dígitos")
    @Column(name = "phoneNumber", nullable = false, length = 20)
    private String phoneNumber;

    @Schema(description = "Email personal")
    @Pattern(regexp = "^[A-Z0-9+_.-]+@[A-Z0-9.-]+$", message = "Expresión no válida para email")
    @Size(max = 100, message = "Email debe tener como máximo 100 carateres")
    @Column(name = "email", nullable = false, length = 100)
    private String email;


    @OneToOne(mappedBy = "person")
    private Client client;

}
