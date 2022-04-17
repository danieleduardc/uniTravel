package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cama implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private String tipo;

    @ManyToMany
    private List<Habitacion> habitacion;

    public Cama(int codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }
}
