package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AdministradorHotel extends Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String cedula;

    @OneToMany(mappedBy = "administradorHotel")
    private List<Hotel> hoteles;

    public AdministradorHotel(String cedula, String nombre, @Email String email, String password, String cedula1) {
        super(cedula, nombre, email, password);
        this.cedula = cedula1;
    }
}
