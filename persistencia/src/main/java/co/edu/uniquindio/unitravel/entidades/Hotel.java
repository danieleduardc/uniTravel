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
public class Hotel implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false, length = 200)
    private String nombre;

    @Column(nullable = false, length = 150)
    private String direccion;

    @Column(nullable = false, length = 50)
    private String telefono;

    @PositiveOrZero
    @Column(nullable = false)
    private int numeroEstrellas;

    @ManyToOne
    private Ciudad ciudad;

    @ManyToOne
    private AdministradorHotel administradorHotel;

    @ToString.Exclude
    @OneToMany(mappedBy = "hotel")
    private List<Foto> fotos;

    @ToString.Exclude
    @ManyToMany
    private List<Caracteristica> caracteristicas;


    public Hotel(int codigo, String nombre, String direccion, String telefono, int numeroEstrellas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.numeroEstrellas = numeroEstrellas;
    }
}
