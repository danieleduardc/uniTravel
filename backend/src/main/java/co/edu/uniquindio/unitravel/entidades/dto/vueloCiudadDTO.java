package co.edu.uniquindio.unitravel.entidades.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.repository.Query;

@AllArgsConstructor
@ToString
@Getter
@Setter

public class vueloCiudadDTO {

    private String nombreCiudad;
    private long numeroVuelo;

}
