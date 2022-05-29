package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class InicioBean implements Serializable {

    @Getter @Setter
    private List<Hotel> hoteles;

    private ClienteServicio clienteServicio;

//    @PostConstruct
//    public void init() {
//        hoteles = clienteServicio.listarHoteles();
//    }

    public String irRegistro(){
        return "registrarCliente?faces-redirect=true";
    }
}
