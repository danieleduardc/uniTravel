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
public class busquedaBean implements Serializable {

    @Getter @Setter
    private String busqueda;

    @Value("#{param['busqueda']}")
    private String busquedaParams;

    @Autowired
    private ClienteServicio clienteServicio;

    @Getter @Setter
    private List<Hotel> hoteles;

    @PostConstruct
    public void init() {

        hoteles = new ArrayList<>();
       try {
           if (busquedaParams != null && !busquedaParams.isEmpty()) {
               hoteles = clienteServicio.buscarHotelesPorNombre(busquedaParams);
           }
       }catch (Exception e) {
           e.printStackTrace();
       }
    }
    public String buscar(){
        return "resultadosBusqueda?faces-redirect=true&amp;busqueda="+busqueda;
    }

    public String irDetalleHotel(String codigoHotel){
        System.out.println("codigoHotel: "+codigoHotel);
        return "detalle_hotel?faces-redirect=true&amp;hotel_id="+codigoHotel;
    }

}
