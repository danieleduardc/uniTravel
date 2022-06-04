package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Caracteristica implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false, length = 2)
    private String tipo;

    @Column(nullable = false, length = 200)
    @NotBlank(message = "El nombre de la característica es obligatorio")
    private String nombre;

    @ManyToMany(mappedBy = "caracteristicas")
    private List<Hotel> hoteles;

    @ManyToMany(mappedBy = "caracteristicas")
    private List<Habitacion> habitaciones;

    public Caracteristica(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
}
