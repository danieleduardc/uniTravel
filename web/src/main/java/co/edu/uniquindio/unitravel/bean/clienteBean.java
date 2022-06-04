package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import co.edu.uniquindio.unitravel.servicios.UnitravelServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;


@Component
@ViewScoped
public class clienteBean implements Serializable {

    @Autowired
    private ClienteServicio clienteServicio;
    @Autowired
    private UnitravelServicio unitravelServicio;

    @Getter @Setter
    private Cliente cliente;

    @Getter @Setter
    private List<Ciudad> ciudades;

    @PostConstruct
    public void init(){
        cliente = new Cliente();
        ciudades = unitravelServicio.ListarCiudades();
    }

    public void registrarCliente(){
        try {
            clienteServicio.registrarCliente(cliente);

            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Registro exitoso");
            FacesContext.getCurrentInstance().addMessage("msj-bean" , facesMsg);

        } catch (Exception e) {
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean", facesMsg);
            throw new RuntimeException(e);
        }
    }
}
