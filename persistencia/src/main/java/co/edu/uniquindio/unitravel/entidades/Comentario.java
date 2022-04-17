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
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(length = 200, nullable = false)
    private String comentario;

    @PositiveOrZero
    @Column(nullable = false)
    private int calificacion;

    @Column(nullable = false)
    private LocalDate fechaCalificacion;

    @ManyToOne
    private Cliente cliente;
}
