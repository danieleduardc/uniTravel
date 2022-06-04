package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ReservaSilla implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @PositiveOrZero
    @Column(nullable = false)
    private long precio;

    @ManyToOne
    private Reserva reserva;

    @ManyToOne
    private Silla silla;

    public ReservaSilla(int codigo, long precio) {
        this.codigo = codigo;
        this.precio = precio;
    }
}
