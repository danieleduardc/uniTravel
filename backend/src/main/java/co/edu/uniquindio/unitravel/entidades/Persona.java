package co.edu.uniquindio.unitravel.entidades;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    @Size(max = 10, message = "La cedula debe tener maximo 10 caracteres")
    @NotBlank(message = "La cedula no puede estar vacia")
    private String cedula;

    @Column(length = 100, nullable = false)
    @Size(max = 100, message = "El nombre debe tener maximo 100 caracteres")
    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;

    @Email(message = "El formato del correo no es valido")
    @Column(length = 150, nullable = false, unique = true)
    @Size(max = 150, message = "El email debe tener maximo 150 caracteres")
    private String email;

    @Column(nullable = false)
    private String password;

}
