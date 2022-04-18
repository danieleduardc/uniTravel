package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ciudad implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private String nombre;

//    @OneToMany(mappedBy = "ciudad")
//    private List<Cliente> clientes;

    @OneToMany(mappedBy = "ciudad")
    private List<Hotel> hoteles;

    @OneToMany(mappedBy = "ciudadOrigen")
    private List<Vuelo> vueloOrigen;

    @OneToMany(mappedBy = "ciudadDestino")
    private List<Vuelo> vueloDestino;

    public Ciudad(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
}
