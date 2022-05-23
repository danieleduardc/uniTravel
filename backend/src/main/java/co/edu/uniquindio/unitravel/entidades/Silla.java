package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Silla implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(nullable = false)
    private String posicion;

    @PositiveOrZero
    @Column(nullable = false)
    private long precio;

    @ToString.Exclude
    @OneToMany(mappedBy = "silla")
    private List<ReservaSilla> reservaSillas;

    @ManyToOne
    private Vuelo vuelo;

    public Silla(String codigo, String posicion, long precio) {
        this.codigo = codigo;
        this.posicion = posicion;
        this.precio = precio;
    }
}