package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    @NotBlank(message = "la fecha no puede estar vacia formato(aa/mm/dd)" )
    private LocalDateTime fechaReserva;

    @Column(nullable = false)
    @NotBlank(message = "la fecha no puede estar vacia formato(aa/mm/dd)" )
    private LocalDateTime fechaInicio;

    @Future
    @Column(nullable = false)
    @NotBlank(message = "la fecha no puede estar vacia formato(aa/mm/dd)" )
    private LocalDateTime fechaFin;

    @Column(nullable = false)
    private int precioTotal;

    @Column(nullable = false)
    @NotBlank(message = "el estado no puede estar vacio" )
    private String estado;

    @Column(nullable = false)
    @NotBlank(message = "ingrese un numero minimo 1 de personas" )
    private String cantidadPersonas;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "reserva")
    private List<ReservaHabitacion> reservaHabitaciones;

    @OneToMany(mappedBy = "reserva")
    private List<ReservaSilla> reservaSillas;


}
