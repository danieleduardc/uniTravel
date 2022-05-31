package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.UnitravelServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class detalleHotelBean implements Serializable {

    @Getter @Setter
    private Hotel hotel;

    private UnitravelServicio unitravelServicio;
    @Value("#{param['codigoHotel']}")
    private String codigoHotel;


    @PostConstruct
    public void init() {
        if(codigoHotel != null && !codigoHotel.isEmpty()) {
            try {
                hotel = unitravelServicio.obtenerHotel(Integer.parseInt(codigoHotel));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
//    public void crearComentario(){
//        try {
//            nuevoComentario.setHotel(this.hotel);
//            nuevoComentario.setUsuario( /* Quemar usuario */);
//            hotelServicio.crearComentario(nuevoComentario);
//            this.comentarios.add(nuevoComentario);
//            this.nuevoComentario = new Comentario();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

}
