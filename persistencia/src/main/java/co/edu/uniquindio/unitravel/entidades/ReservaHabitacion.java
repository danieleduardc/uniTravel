package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ReservaHabitacion implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private Long codigo;

    @Column(nullable = false)
    @PositiveOrZero
    private long precio;

    @ManyToOne
    private Habitacion habitacion;

    @ManyToOne
    private Reserva reserva;

    public ReservaHabitacion(Long codigo, long precio) {
        this.codigo = codigo;
        this.precio = precio;
    }
}