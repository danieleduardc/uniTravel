package co.edu.uniquindio.unitravel.entidades.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter

public class VueloCiudadDTO {

    private String nombreCiudad;
    private long numeroVuelo;

}
