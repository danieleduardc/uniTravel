package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Administrador extends Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String cedula;

    public Administrador(String cedula, String nombre, @Email String email, String password, String cedula1) {
        super(cedula, nombre, email, password);
        this.cedula = cedula1;
    }
}
