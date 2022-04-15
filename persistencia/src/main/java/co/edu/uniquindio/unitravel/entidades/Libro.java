package co.edu.uniquindio.unitravel.entidades;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;


@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Libro implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 13)
    private String isbn;

    @Column(length = 100, nullable = false)
    private String titulo;

    @Min(0) //valor minimo de 0 //@positiveorzero
    @Column(nullable = false)
    private int unidades;

    @Max(9999)
    @Column(nullable = false)
    private Short anio;

    @Enumerated(EnumType.STRING)
    @Column(length = 100, nullable = false)
    private Genero genero;

    @ManyToMany(mappedBy = "libros")
    private List<Prestamo> prestamos;

    @ManyToMany
    private List<Autor> autores;

    public Libro(String isbn, String nombre, int unidades, Short anio) {
        this.isbn = isbn;
        this.titulo = nombre;
        this.unidades = unidades;
        this.anio = anio;
    }

}
