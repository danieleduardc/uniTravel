package co.edu.uniquindio.unitravel.entidades;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class Autor extends Persona implements Serializable {

    @Positive
    @Column(nullable = false)
    private int anio_nacimiento;

    @ManyToMany(mappedBy = "autores")
    private List<Libro> libros;


    public Autor(String codigo, String nombre, int anio_nacimiento) {
        super(codigo, nombre);
        this.anio_nacimiento = anio_nacimiento;
    }
}
