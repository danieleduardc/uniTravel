package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Lob
    @Column(nullable = false)
    private String mensaje;

    @Positive
    @Max(5)
    @Column(nullable = false)
    private Integer calificacion;

    @Column(nullable = false)
    private LocalDateTime fechaCalificacion;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Hotel hotel;

    public Comentario(String mensaje, Integer calificacion, LocalDateTime fechaCalificacion, Cliente cliente, Hotel hotel) {
        this.mensaje = mensaje;
        this.calificacion = calificacion;
        this.fechaCalificacion = fechaCalificacion;
        this.cliente = cliente;
        this.hotel = hotel;
    }
}
