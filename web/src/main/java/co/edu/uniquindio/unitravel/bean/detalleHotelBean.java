package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.*;
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
    @Getter @Setter
    private AdministradorHotel administradorHotel;

    @Getter @Setter
    private Integer calificacionPromedio;

    List<Habitacion> habitaciones;

    @Value(value = "#{seguridadBean.persona}")
    private Persona personaSecion;

    @PostConstruct
    public void inicializar(){
        nuevoComentario = new Comentario();
        comentarios = new ArrayList<Comentario>();

        if(codigoHotel != null && !codigoHotel.isEmpty()){
            try{
                hotel = unitravelServicio.obtenerHotel(Integer.parseInt(codigoHotel));
                administradorHotel = hotel.getAdministradorHotel();
                comentarios = hotel.getComentarios();
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }

//    public void actualizarHabitaciones(){
//       habitaciones = clienteServicio.obtenerHabitacionesDisponibles(Integer.parseInt(codigoHotel),rangoFechaInterna(0),rangoFechaInterna(1));
//    }


    public void crearComentario(){
        try {
            if(personaSecion != null){
                nuevoComentario.setHotel(hotel);
                nuevoComentario.setCliente((Cliente) personaSecion);
                unitravelServicio.crearComentario(nuevoComentario);
                comentarios.add(nuevoComentario);
                nuevoComentario = new Comentario();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public Object rangoFechaInterna(Integer i) {
        return null;
    }

    public Object getNumeroPersonasInterna() {
        return null;
    }


}
