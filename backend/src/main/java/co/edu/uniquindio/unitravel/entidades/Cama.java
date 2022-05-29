package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cama implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false)
    private String tipo;

    @ToString.Exclude
    @ManyToMany
    private List<Habitacion> habitaciones;

    public Cama(int codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }
}
