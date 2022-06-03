package co.edu.uniquindio.unitravel.entidades;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false, length = 200)
    private String nombre;

    @Column(nullable = false, length = 150)
    private String direccion;

    @Column(nullable = false, length = 50)
    private String telefono;

    @Lob
    private String descripcion;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> fotos;

    @PositiveOrZero
    @Column(nullable = false)
    private int numeroEstrellas;

    @ManyToOne
    private Ciudad ciudad;

    @ManyToOne
    private AdministradorHotel administradorHotel;

    @OneToMany(mappedBy="hotel")
    @ToString.Exclude
    private List<Habitacion>habitaciones;

    @ToString.Exclude
    @OneToMany(mappedBy = "hotel")
    private List<Comentario> comentarios;

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

    public String getImagenPrincipal(){
        if(fotos != null && !fotos.isEmpty()){
            return fotos.get(0);
        }
        return "default.png";
    }


}
