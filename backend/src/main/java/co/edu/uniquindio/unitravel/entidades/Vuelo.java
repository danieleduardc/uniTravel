package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Vuelo implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String aerolinea;

    @ToString.Exclude
    @OneToMany(mappedBy = "vuelo")
    private List<Silla> sillas;

    @ManyToOne
    private Ciudad ciudadOrigen;

    @ManyToOne
    private Ciudad ciudadDestino;

    public Vuelo(String codigo, String estado, String aerolinea) {
        this.codigo = codigo;
        this.estado = estado;
        this.aerolinea = aerolinea;
    }
}
