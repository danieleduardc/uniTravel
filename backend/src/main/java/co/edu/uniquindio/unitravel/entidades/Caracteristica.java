package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Caracteristica implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false, length = 2)
    private String tipo;

    @Column(nullable = false, length = 200)
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
