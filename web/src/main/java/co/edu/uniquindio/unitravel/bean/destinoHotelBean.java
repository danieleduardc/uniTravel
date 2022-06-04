package co.edu.uniquindio.unitravel.bean;


import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class destinoHotelBean implements Serializable {

    @Autowired
    private ClienteServicio clienteServicio;
    @Value("#{param['ciudad']}")
    private String codigoCiudad;

    @Getter @Setter
    private List<Hotel> hoteles;

    @PostConstruct
    public void init(){

        hoteles = new ArrayList<>();

        try{
            if(codigoCiudad != null && !codigoCiudad.isEmpty()) {
                hoteles = clienteServicio.obtenerHotelCiudad(Integer.parseInt(codigoCiudad));
                hoteles.forEach(hotel -> System.out.println(hotel.getNombre()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
