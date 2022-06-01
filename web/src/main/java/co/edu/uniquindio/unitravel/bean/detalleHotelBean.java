package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import co.edu.uniquindio.unitravel.servicios.UnitravelServicio;
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
public class detalleHotelBean implements Serializable {

    @Getter @Setter
    private Hotel hotel;
    @Autowired
    private UnitravelServicio unitravelServicio;

    @Value("#{param['hotel_id']}")
    private String codigoHotel;

    @Autowired
    private ClienteServicio clienteServicio;

    @Getter @Setter
    private Comentario nuevoComentario;

    @Getter @Setter
    private List<Comentario> comentarios;

    @PostConstruct
    public void init() {
        nuevoComentario = new Comentario();
       comentarios = new ArrayList<>();
        if(codigoHotel != null && !codigoHotel.isEmpty()) {
            try {
                hotel = unitravelServicio.obtenerHotel(Integer.parseInt(codigoHotel));
                comentarios = hotel.getComentarios();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void crearComentario(){
        try {
            nuevoComentario.setHotel(hotel);
            nuevoComentario.setCliente(clienteServicio.obtenerCliente("112"));
            unitravelServicio.crearComentario(nuevoComentario);
            comentarios.add(nuevoComentario);
            nuevoComentario = new Comentario();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
