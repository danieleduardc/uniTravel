package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Habitacion implements Serializable {

    @Id
    @PositiveOrZero
    @EqualsAndHashCode.Include
    private int numero;

    @Column(nullable = false)
    @Positive
    private int precio;

    @Column(nullable = false)
    @PositiveOrZero
    private int capacidad;

    @ElementCollection
    private List<String> fotos;

    @ManyToOne
    private Hotel hotel;

    @ToString.Exclude
    @ManyToMany
    private List<Caracteristica> caracteristicas;

    @ManyToMany(mappedBy = "habitaciones")
    private List<Cama> camas;

    @ToString.Exclude
    @OneToMany(mappedBy = "habitacion")
    private List<ReservaHabitacion> reservaHabitaciones;

}
