package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

    private String codigoCiudad;

    @ElementCollection
    private Map<String, String> telefonos;

    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas;

    @ManyToOne
    private Ciudad ciudad;

    @OneToMany(mappedBy = "cliente")
    private List<Comentario> comentarios;

    public Cliente(String cedula, String nombre, @Email String email, String password, String codigoCiudad) {
        super(cedula, nombre, email, password);
        this.codigoCiudad = codigoCiudad;
    }
}
