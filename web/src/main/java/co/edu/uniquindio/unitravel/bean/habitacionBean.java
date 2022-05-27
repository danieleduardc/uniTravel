package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Habitacion;
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
public class habitacionBean implements Serializable {

    @Autowired
    private AdministradorHotelServicio administradorHotelServicio;

    @Getter
    @Setter
    private Habitacion habitacion;

    @PostConstruct
    public void init(){
        habitacion = new Habitacion();
    }

    public void registrarHabitacion(){
        try {
            administradorHotelServicio.crearHabitacion(habitacion);

            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Registro exitoso");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);

        } catch (Exception e) {
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
            throw new RuntimeException(e);
        }
    }

}
