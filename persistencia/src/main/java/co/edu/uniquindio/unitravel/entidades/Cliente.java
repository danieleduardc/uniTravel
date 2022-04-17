package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente extends Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String cedula;

    @OneToMany(mappedBy = "cliente")
    private List<Telefono> telefonos;

    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas;

    @ManyToOne
    private Ciudad ciudad;

    @OneToMany(mappedBy = "cliente")
    private List<Comentario> comentarios;

    @Email
    private String correo;

    public Cliente(String cedula, String nombre, @Email String email, String password, String cedula1) {
        super(cedula, nombre, email, password);
        this.cedula = cedula1;
    }
}
