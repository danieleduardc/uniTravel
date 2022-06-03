package co.edu.uniquindio.unitravel.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Cliente extends Persona implements Serializable {

    @ElementCollection

    private List<String> telefonos;

    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "cliente")
    private List<Comentario> comentarios;

    @ManyToOne
    private Ciudad ciudad;

    public Cliente(String cedula, String nombre, @Email String email, String password) {
        super(cedula, nombre, email, password);
    }
}
