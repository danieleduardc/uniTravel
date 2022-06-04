package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Habitacion implements Serializable {

    @Id
    @PositiveOrZero
    @EqualsAndHashCode.Include
    @Size(max = 10000)
    private int numero;

    @Column(nullable = false)
    @Positive
    private long precio;

    @Column(nullable = false)
    @PositiveOrZero
    private int capacidad;

    @ElementCollection
    private List<String> fotos;

    @ManyToOne
    private Hotel hotel;

    @ToString.Exclude
    @ManyToMany
    private List<Caracteristica> caracteristicas;

    @ManyToMany(mappedBy = "habitaciones")
    private List<Cama> camas;

    @ToString.Exclude
    @OneToMany(mappedBy = "habitacion")
    private List<ReservaHabitacion> reservaHabitaciones;

    public String getImagenPrincipal(){
        if(fotos != null && !fotos.isEmpty()){
            return fotos.get(0);
        }
        return "image.png";
    }

    public String formatearDinerro(){
        Locale locale = new Locale("es", "CO");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        return currencyFormatter.format(precio);
    }

}
