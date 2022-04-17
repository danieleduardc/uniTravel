package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private LocalDateTime fechaReserva;

    @Column(nullable = false)
    private LocalDateTime fechaInicio;

    @Future
    @Column(nullable = false)
    private LocalDateTime fechaFin;

    @Column(nullable = false)
    private int precioTotal;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String cantidadPersonas;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "reserva")
    private List<ReservaHabitacion> reservaHabitaciones;

    @OneToMany(mappedBy = "reserva")
    private List<ReservaSilla> reservaSillas;


}
