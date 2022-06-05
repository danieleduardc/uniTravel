package co.edu.uniquindio.unitravel.entidades;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

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
    @Size(min = 1, max = 200)
    @NotBlank(message = "El nombre del hotel no puede estar vacío")
    private String nombre;

    @Column(nullable = false, length = 150)
    @Size(max = 150)
    @NotBlank(message = "La dirección del hotel no puede estar vacía")
    private String direccion;

    @Column(nullable = false, length = 50)
    @Size(max = 50)
    @NotBlank(message = "El teléfono del hotel no puede estar vacío")
    private String telefono;

    @Lob
    private String descripcion;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> fotos;

    @Positive
    @Max(5) @Min(1)
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
    @LazyCollection(LazyCollectionOption.FALSE)
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
