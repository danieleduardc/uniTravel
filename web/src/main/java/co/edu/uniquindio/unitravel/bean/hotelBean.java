package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.AdministradorHotelServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class hotelBean implements Serializable {

    @Getter @Setter
    private Hotel hotel;

    @Autowired
    private AdministradorHotelServicio administradorHotelServicio;

    @PostConstruct
    public void init(){
        hotel = new Hotel();
    }

    public String RegistrarHotel(){
        try {

            Ciudad ciudad = administradorHotelServicio.obtenerCiudad(1);
            AdministradorHotel administradorHotel = administradorHotelServicio.obtenerAdministrador("111");

            hotel.setCiudad(ciudad);
            hotel.setAdministradorHotel(administradorHotel);

            administradorHotelServicio.crearHotel(hotel);
            return "registroExitoso?faces-redirect=true";
//            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Hotel Creado Correctamente");
//            FacesContext.getCurrentInstance().addMessage(null, msj);
        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msj);
            throw new RuntimeException(e);
        }
    }
}
